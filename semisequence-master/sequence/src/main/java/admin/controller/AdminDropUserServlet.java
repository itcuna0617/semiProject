package admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.model.service.AdminService;

@WebServlet("/AdminDropUserServlet")
public class AdminDropUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delUser = request.getParameter("delUserid");
		String status = request.getParameter("UseridStatus");
		String userType = request.getParameter("userType");
		String[] userArr = delUser.split("-");
		
		if(userArr != null && userArr.length > 0){
			 for(int i = 0 ; i < userArr.length ; i++){
				 String userNo = userArr[i];
				 if(userType.equals("user") && status.equals("N")) {
					 new AdminService().userStatusUpdate(userNo);
				 } else if(userType.equals("user") && status.equals("Y")) {
					 new AdminService().userStatusUpdateY(userNo);
				 } else if(userType.equals("ent") && status.equals("N")) {
					 new AdminService().entStatusUpdate(userNo);
				 } else if(userType.equals("ent") && status.equals("Y")) {
					 new AdminService().entStatusUpdateY(userNo);
				 }
			 }
		}
		response.sendRedirect("admin/membermanagement");
	}

}
