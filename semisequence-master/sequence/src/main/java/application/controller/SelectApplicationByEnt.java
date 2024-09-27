package application.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.notice.NoticePagenation;
import application.model.dto.ApplicationDTO;
import application.model.service.ApplicationService;
@WebServlet("/application/select/by/ent")
public class SelectApplicationByEnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ApplicationService appService= new ApplicationService();
		int currentPage = Integer.parseInt(request.getParameter("page"));
		String criteria = request.getParameter("criteria");
		
		HttpSession session = request.getSession();
		int entNo = (int)session.getAttribute("entNo");
		Map<String,String> criteriaMap = new HashMap<>();
		criteriaMap.put("criteria", criteria);
		
		int size=10;
		int pagingCount=5;
		
		Integer endNo = currentPage*10;
		Integer startNo = endNo-9;
		
		criteriaMap.put("startNo", startNo.toString());
		criteriaMap.put("endNo", endNo.toString());
		
		if("posting".equals(criteria)) {
			criteriaMap.put("postingNo", request.getParameter("postingNo"));
		} 
		else if("ent".equals(criteria)) {
			criteriaMap.put("entNo", session.getAttribute("entNo").toString());
		}
		else if("project".equals(criteria)) {
			criteriaMap.put("projectNo", request.getParameter("projectNo"));
		}
		
		int total=appService.selectTotalCount(criteriaMap);
		NoticePagenation pagenation = new NoticePagenation(total, size, currentPage, pagingCount);
		
		List<ApplicationDTO> applicationList=appService.selectApplicationByEnt(criteriaMap);
		
		request.setAttribute("noticePaging", pagenation);
		
		String path="";
		request.setAttribute("applicationList", applicationList);
		if("posting".equals(criteria)) {
			path="/WEB-INF/views/posting/selectApplicationByPosting.jsp";
			request.setAttribute("criteria", "공고");
		} 
		else if("ent".equals(criteria)) {
			path="/WEB-INF/views/posting/selectApplicationByPosting.jsp";
			request.setAttribute("criteria", "기업");
		}
		else if("project".equals(criteria)) {
			path="/WEB-INF/views/posting/selectApplicationByPosting.jsp";
			request.setAttribute("criteria", "프로젝트");
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
