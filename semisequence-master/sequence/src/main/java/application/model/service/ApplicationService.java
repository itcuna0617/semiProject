package application.model.service;
import static common.mybatis.Template.getSqlSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import application.model.dao.ApplicationDAO;
import application.model.dto.ApplicationDTO;

public class ApplicationService {
	private ApplicationDAO applicationDAO;
	
	public ApplicationService() {
		applicationDAO = new ApplicationDAO();
	}


	public List<ApplicationDTO> selectApplicationByEnt(Map<String, String> criteriaMap) {
		SqlSession session = getSqlSession();
		
		List<ApplicationDTO> applicationList = applicationDAO.selectApplicationByEnt(session, criteriaMap);
		
		if(!applicationList.isEmpty() && applicationList!=null) {
			System.out.println("조회 성공, 첫번째 지원 조회");
			System.out.println(applicationList.get(0));
		} else {
			System.out.println("조회에 실패했거나 비어있음");
		}
		
		session.close();
		
		return applicationList;
	}


	public boolean passApplication(int applicationNo) {
		SqlSession session = getSqlSession();
		
		int result = applicationDAO.passApplication(session, applicationNo);
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		
		return result==1? true : false;
	}
	
	public boolean failApplication(int applicationNo) {
		SqlSession session = getSqlSession();
		
		int result = applicationDAO.failApplication(session, applicationNo);
		
		if(result==1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		
		return result==1? true : false;
	}


//	public int selectTotalCount(int entNo) {
//		SqlSession session = getSqlSession();
//		
//		int result = applicationDAO.selectTotalCount(session, entNo);
//		
//		session.close();
//		
//		return result;
//	}
	public int selectTotalCount(Map<String, String> criteriaMap) {
		SqlSession session = getSqlSession();
		
		int result = applicationDAO.selectTotalCount(session, criteriaMap);
		
		session.close();
		
		return result;
	}


	public List<ApplicationDTO> selectApplicationPass(Map<String, String> criteriaMap) {
		SqlSession session = getSqlSession();
		
		List<ApplicationDTO> applicationList = applicationDAO.selectApplicationPass(session, criteriaMap);
		
		if(!applicationList.isEmpty() && applicationList!=null) {
			System.out.println("조회 성공, 첫번째 지원 조회");
			System.out.println(applicationList.get(0));
		} else {
			System.out.println("조회에 실패했거나 비어있음");
		}
		
		session.close();
		
		return applicationList;
	}



	public List<ApplicationDTO> selectApplicationFail(Map<String, String> criteriaMap) {
		SqlSession session = getSqlSession();
		
		List<ApplicationDTO> applicationList = applicationDAO.selectApplicationFail(session, criteriaMap);
		
		if(!applicationList.isEmpty() && applicationList!=null) {
			System.out.println("조회 성공, 첫번째 지원 조회");
			System.out.println(applicationList.get(0));
		} else {
			System.out.println("조회에 실패했거나 비어있음");
		}
		
		session.close();
		
		return applicationList;
	}


	public int selectFailTotalCount(Map<String, String> criteriaMap) {
		SqlSession session = getSqlSession();
		
		int result = applicationDAO.selectFailTotalCount(session, criteriaMap);
		
		session.close();
		
		return result;
	}
	public int selectPassTotalCount(Map<String, String> criteriaMap) {
		SqlSession session = getSqlSession();
		
		int result = applicationDAO.selectPassTotalCount(session, criteriaMap);
		
		session.close();
		
		return result;
	}
}
