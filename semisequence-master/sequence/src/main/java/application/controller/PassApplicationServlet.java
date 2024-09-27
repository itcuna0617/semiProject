package application.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.service.ApplicationService;

@WebServlet("/application/pass")
public class PassApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int applicationNo = Integer.parseInt(request.getParameter("applicationNo"));
		
		ApplicationService appService = new ApplicationService();
		
		boolean result = appService.passApplication(applicationNo);
		
		String path="";
		
		String criteria= request.getParameter("criteria");
		
		
		request.setAttribute("criteria", criteria);
		request.setAttribute("page", 1);
		
		if("posting".equals(criteria)) {
			request.setAttribute("postingNo", request.getParameter("postingNo"));
		} 
		else if("ent".equals(criteria)) {
		}
		else if("project".equals(criteria)) {
			request.setAttribute("projectNo", request.getParameter("projectNo"));
		}
		
		if(result) {
			path="/WEB-INF/views/application/applicationPass.jsp";
//			path="/application/select/by/ent";
		} else {
			path="/WEB-INF/views/error/500error.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}
