package admin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.dto.ApprovalAndEntInfoDTO;
import admin.model.dto.ApprovalDTO;
import admin.model.service.AdminService;
import user.paging.Pagenation;
import user.paging.SelectCriteria;
@WebServlet("/admin/entRegist/approval")
public class AdminRegistApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/* paging 처리 */
		String currentPage = request.getParameter("currentPage");
		int pageNo = 1;
		if(currentPage != null && !"".equals(currentPage)) {
			pageNo = Integer.parseInt(currentPage);
		}
		AdminService adminService = new AdminService();
		int totalCount = adminService.selectTotalCount();
		
		int limit = 2;
		int buttonAmount = 5;
		SelectCriteria selectCriteria = null;
		selectCriteria = Pagenation.getSelectCriteria(pageNo, totalCount, limit, buttonAmount);
		
		/* 가입 신청 내역 전체조회 */
		List<ApprovalDTO> approvalList = new ArrayList<ApprovalDTO>();
		approvalList = adminService.selectApproval();
		System.out.println("approvalList" + approvalList);
		
		/* 가입 신청 내역에 있는 회원의 정보를 뿌려주기 위해 부가적인 정보 조회 */
		List<ApprovalAndEntInfoDTO> approvalAndEntInfoList = new ArrayList<ApprovalAndEntInfoDTO>();
		for(int i = 0; i < approvalList.size(); i++) {
			int entNo = approvalList.get(i).getEntNo();
			ApprovalAndEntInfoDTO approval = adminService.selectApprovalAndEntInfoList(entNo, selectCriteria);
			approvalAndEntInfoList.add(approval);
		}
		System.out.println("approvalAndEntInfoList" + approvalAndEntInfoList);
		
		String path = "";
		if(approvalAndEntInfoList.size() > 0) {
			path = "/WEB-INF/views/admin/adminEntRegistApproval.jsp";
			request.setAttribute("approvalAndEntInfoList", approvalAndEntInfoList);
			request.setAttribute("selectCriteria", selectCriteria);
		} else if(approvalAndEntInfoList.size() == 0) {
			path = "/WEB-INF/views/admin/adminEntRegistApproval.jsp";
			request.setAttribute("code", "기업 가입 신청 내역이 없습니다.");
		} else {
			path = "/WEB-INF/views/common/failed.jsp";
			request.setAttribute("message", "기업 가입 신청 승인 실패!");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
