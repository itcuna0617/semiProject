package ent;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ent.model.dto.PaymentHistoryDTO;
import ent.model.dto.RatePlanByEntDTO;
import ent.model.service.EntService;

@WebServlet("/ent/paymenthistory")
public class EntMyPageToPaymentHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String url = "../WEB-INF/views/ent/entPaymentHistory.jsp";
		HttpSession session = request.getSession();
		int entNo = (int)session.getAttribute("entNo");
		
		System.out.println(entNo);
		
		EntService entService = new EntService();
		
		RatePlanByEntDTO ratePlanByEntDTO = new RatePlanByEntDTO();
		ratePlanByEntDTO = entService.selectRatePlanByEntInfo(entNo);
		
		List<PaymentHistoryDTO> paymentHistory = entService.selectPaymentHistory(entNo);
		
		String path = "";
		
		if(paymentHistory != null) {
			path = "/WEB-INF/views/ent/entPaymentHistory.jsp";
			request.setAttribute("paymentHistory", paymentHistory);
			request.setAttribute("ratePlanByEntInfo", ratePlanByEntDTO);
		} 
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
