package ent.model.service;

import static common.mybatis.Template.getSqlSession;

import java.io.File;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ent.EntInfoMapper;
import ent.model.dao.EntDAO;
import ent.model.dto.EntDTO;
import ent.model.dto.EntPhotoDTO;
import ent.model.dto.EntProfileDTO;
import ent.model.dto.PaymentHistoryDTO;
import ent.model.dto.RatePlanByEntDTO;
import ent.model.dto.RatePlanDTO;

public class EntService {
	
	private EntInfoMapper entInfoMapper;
	private EntDAO entDAO;
	
	public EntService() {
		entDAO = new EntDAO();
	}

	public int passCheck(EntDTO requestMember) {
		
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		String encPwd = entInfoMapper.selectEncryptedPwd(requestMember);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		int result = 0;
		
		if(passwordEncoder.matches(requestMember.getEntPwd(), encPwd)) {
			result = entInfoMapper.entInfoDelete(requestMember);
			
			if(result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} 
		sqlSession.close();
		return result;
	}

	public int entInfoPasswordUpdate(EntDTO entInfo) {
		
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.entInfoPasswordUpdate(entInfo);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}

	public int entInfoUpdate(EntDTO entDTO) {
		
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.entInfoUpdate(entDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return result;
	}

	public List<PaymentHistoryDTO> selectPaymentHistory(int entNo) {
		
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		List<PaymentHistoryDTO> paymentHistory = entInfoMapper.selectPaymentHistory(entNo);
		
		sqlSession.close();
		
		return paymentHistory;
	}
	
	public EntDTO loginCheck(EntDTO requestMember, String userType) {

	      SqlSession session = getSqlSession();
	      EntDTO loginMember = null;
	      
	      /* Test용으로 비밀번호와 직접 비교하여 로그인 시키기 위해 비밀번호 불러옴 */
	      /* 암호화된 비밀번호 저장 후에 다시 구현 */
	      System.out.println(requestMember);
	      String entId = requestMember.getEntId();
	      
	      String encPwd = entDAO.selectEncryptedPwd(session, entId);
	      

	      /* 암호화된 비밀번호와 비교하는 부분 */
	      BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	      
	      System.out.println("받아온 비밀번호 : " + encPwd);

	      if(passwordEncoder.matches(requestMember.getEntPwd(), encPwd)) {
	         System.out.println("로그인 성공!");
	         loginMember = entDAO.selectLoginMember(session, requestMember);
	      }
	      
	      System.out.println("Service에서 받은 login 정보 : " + loginMember);
	      
	      /* 로그인 기록을 insert */
			int result = 0;
			
			if(loginMember != null) {
				result = entDAO.insertEntLoginSucccessHistory(session, loginMember);
			}
			
			if(result > 0) {
				System.out.println("로그인 성공 기록 완료!");
				session.commit();
			} else {
				session.rollback();
			}
	      
	      session.close();
	      
	      return loginMember;
	   }

	public int registEnt(EntDTO requestEnt, String savePath) {
		SqlSession session = getSqlSession();
		
		String originPath = savePath + requestEnt.getEnrollmentFileName();
		
		int result = 0;
		
		/* 기원회원 테이블(TBL_ENT_INFO)에 insert 성공 여부 */
		int result1 = EntDAO.insertEnt(session, requestEnt);
		
		System.out.println("result1 : " + result1);
		System.out.println("entNo 넣기 전 requestEnt : " + requestEnt);
		
		/* insert에 성공한다면 가입신청 테이블에 insert할 때 필요한 entNo을 받아와야 한다. */
		int entNo = EntDAO.selectEntNo(session, requestEnt);
		
		requestEnt.setEntNo(entNo);
		File origin = new File(originPath);
		File renamed = new File(savePath + entNo + ".pdf");
		
		origin.renameTo(renamed);
		String newFileName = entNo + "";
		requestEnt.setEnrollmentFileName(newFileName);
		
		System.out.println("entNo 넣은 후 requestEnt : " + requestEnt);
		
		/* 가입신청 내역 테이블에 insert 성공 여부 */
		int result2 = EntDAO.insertRegistApplicationEnt(session, requestEnt);
		System.out.println("result2 : " + result2);
		
		int result3 = entDAO.insertEntEnrollmentFile(session, requestEnt);
		
		if(result1 > 0 && result2 > 0 && result3 > 0) {
			result = 1;
			session.commit();
		} else {
			session.rollback();
		}
	      
	      return result;
	   }

	public int entInsertProfile(EntProfileDTO entProfileDTO) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.entInsertProfile(entProfileDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int entSelectProfNo(int entNo) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int profNo = entInfoMapper.entSelectProfNo(entNo);
		
		if(profNo > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return profNo;
	}

	public int entInsertPhoto(EntPhotoDTO entPhotoDTO) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.entInsertPhoto(entPhotoDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public EntProfileDTO selectProfYn(int entNo) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		EntProfileDTO profYn = entInfoMapper.selectProfYn(entNo);
		
		sqlSession.close();
		
		return profYn;
	}

	public int entUpdateProfile(EntProfileDTO entProfileDTO) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.entUpdateProfile(entProfileDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int entUpdatePhoto(EntPhotoDTO entPhotoDTO) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.entUpdatePhoto(entPhotoDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public String selectProfileImg(int entNo) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		String result = entInfoMapper.selectProfileImg(entNo);
		
		if(result != null) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public RatePlanByEntDTO selectRatePlanByEntInfo(int entNo) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		RatePlanByEntDTO result = entInfoMapper.selectRatePlanByEntInfo(entNo);
		
		sqlSession.close();
		
		return result;
	}

	public int insertPaymentHistory(PaymentHistoryDTO paymentHistoryDTO) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.insertPaymentHistory(paymentHistoryDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}

	public int selectPaymentNo(int entNo) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.selectPaymentNo(entNo);
		
		return result;
	}

	public RatePlanDTO selectRatePlanInfo(String planName) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		RatePlanDTO result = entInfoMapper.selectRatePlanInfo(planName);
		
		return result;
	}

	public int UpdateRatePlanByEnt(RatePlanByEntDTO ratePlanByEntDTO) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		int result = entInfoMapper.UpdateRatePlanByEnt(ratePlanByEntDTO);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
	}
	
	public int updateEntPassword(String passwordCheck, EntDTO requestMember) {
		SqlSession session = getSqlSession();
		
		int result = EntDAO.updateEntPassword(session, requestMember);

		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result;
	}

	public String entSelectPassword(int entNo) {
		SqlSession sqlSession = getSqlSession();
		entInfoMapper = sqlSession.getMapper(EntInfoMapper.class);
		
		String result = entInfoMapper.entSelectPasword(entNo);
		
		return result;
	}

}
