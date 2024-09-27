package admin.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;
import user.model.dto.UserInfoDTO;
import ent.model.dto.EntDTO;

@WebServlet("/admin/membermanagement")
public class AdminMemberManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "../WEB-INF/views/admin/membermanagement.jsp";
		
		UserInfoDTO userinfo = new UserInfoDTO();
		EntDTO entinfo = new EntDTO();
		
		List<UserInfoDTO> userList = new AdminService().selectUserInfo();
		request.setAttribute("userList", userList);
		
		List<EntDTO> entList = new AdminService().selectEntInfo();
		request.setAttribute("entList", entList);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
