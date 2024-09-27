package ent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ent.model.dto.PaymentHistoryDTO;
import ent.model.dto.RatePlanByEntDTO;
import ent.model.dto.RatePlanDTO;
import ent.model.service.EntService;

@WebServlet("/ent/paymentinsert")
public class EntPaymentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/ent/entPaymentHistory.jsp";
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int entNo = (int)session.getAttribute("entNo");
		String planName = request.getParameter("planName");
		
		EntService entService = new EntService();
		
		PaymentHistoryDTO paymentHistoryDTO = new PaymentHistoryDTO();
		paymentHistoryDTO.setEntNo(entNo);
		paymentHistoryDTO.setPlanName(planName);
		
		int result = entService.insertPaymentHistory(paymentHistoryDTO);
		
		System.out.println(result);
		
		int paymentNo = entService.selectPaymentNo(entNo);
		
		System.out.println(paymentNo);
		
		RatePlanDTO ratePlanDTO = new RatePlanDTO();
		ratePlanDTO = entService.selectRatePlanInfo(planName);
		
		System.out.println(ratePlanDTO);
		
		RatePlanByEntDTO ratePlanByEntDTO = new RatePlanByEntDTO();
		ratePlanByEntDTO.setEntNo(entNo);
		ratePlanByEntDTO.setEntPaymentNo(paymentNo);
		ratePlanByEntDTO.setPlanName(planName);
		ratePlanByEntDTO.setPlanOfferCount(ratePlanDTO.getPlanOffer());
		ratePlanByEntDTO.setPlanProjectCount(ratePlanDTO.getPlanProject());
		
		int updateresult = entService.UpdateRatePlanByEnt(ratePlanByEntDTO);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
