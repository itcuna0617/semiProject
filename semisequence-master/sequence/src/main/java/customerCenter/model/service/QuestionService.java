package customerCenter.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.TypeException;

import common.paging.SelectCriteria;
import customerCenter.model.dao.QuestionDAO;
import customerCenter.model.dto.QuestionAndAnswerAndFileDTO;
import customerCenter.model.dto.QuestionAndAnswerDTO;
import customerCenter.model.dto.QuestionAndQuestionFileDTO;
import customerCenter.model.dto.QuestionDTO;

public class QuestionService {
	
	private final QuestionDAO questionDAO;
	
	public QuestionService() {
		questionDAO = new QuestionDAO();
	}

	/* 문의 리스트 셀렉트 */
	public List<QuestionAndAnswerDTO> selectAllQuestionList(SelectCriteria selectCriteria) {
		
		SqlSession session = getSqlSession();
		
		List<QuestionAndAnswerDTO> questionList = questionDAO.selectAllQuestionList(session, selectCriteria);
		
		
		session.close();
		
		return  questionList;
	}

	/* 새로운 문의 생성 */
	public int insertNewQuestion(QuestionAndQuestionFileDTO newQuestion) {
		
		SqlSession session = getSqlSession();
		
		/* 문의내역 insert */
		int newQuestionResult = questionDAO.insertNewQuestion(session, newQuestion);
		
		System.out.println("newQuestion : " +  newQuestion);
		
		/* 문의내역 insert 후 커밋 */
		if(newQuestionResult > 0) {
			session.commit();
			System.out.println("새로운 문의 커밋완료");
			
		}else {
			session.rollback();
		}
	
		return newQuestionResult;
		
	}

	/* 문의 상세 내역 조회 */
	public QuestionAndAnswerAndFileDTO selectQuestionDetail(int queNo) {
		
		SqlSession session = getSqlSession();
		
		QuestionAndAnswerAndFileDTO queDetail = questionDAO.selectQuestionDetail(session, queNo);
			
		if(queDetail != null) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();
				
		return queDetail;
	}
	
	public QuestionAndAnswerAndFileDTO selectQuestionAnswerDetail(int queNo) {
		
		SqlSession session = getSqlSession();
		
		QuestionAndAnswerAndFileDTO ansDetail = questionDAO.selectQuestionAnswerDetail(session, queNo);
			
		if(ansDetail != null) {
			session.commit();
		} else {
			session.rollback();
		}

		session.close();
				
		return ansDetail;
	}
	
	public int selectUserQueNo(int userNo) {
		
		SqlSession session = getSqlSession();
		
		/* 문의 번호 가져오기 */
		int queNo = questionDAO.selectUserQueNo(session, userNo);
		
		
		session.close();
		
		
		return queNo;
	}

	public int selectEntQueNo(int entNo) {
		
		SqlSession session = getSqlSession();
		
		
		/* 문의 번호 가져오기 */
		int queNo = questionDAO.selectEntQueNo(session, entNo);
		
		
		session.close();
		
		
		return queNo;
	}

	public int insertNewQuestionFile(QuestionAndQuestionFileDTO newQuestionFile) {
		
		SqlSession session = getSqlSession();
		
		/* 문의파일 insert */
		int newQuestionFileResult =  0;
			
		newQuestionFileResult =	questionDAO.insertNewQuestionFile(session, newQuestionFile);
			
			if(newQuestionFileResult > 0) {
				session.commit();
				
			} else {
				session.rollback();
			}
		
		session.close();
		
		return newQuestionFileResult;
		
	}

	/* 문의 내역 파일 조회 */
	public QuestionAndAnswerAndFileDTO selectQuestionFile(int queNo) {
		
		SqlSession session = getSqlSession();
		
		QuestionAndAnswerAndFileDTO questionFile = questionDAO.selectQuestionFile(session, queNo);
		
		if(questionFile != null) {
			session.commit();
		} else {
			session.rollback();
		}
		
		return questionFile;
	}

	public int selectTotalCount() {
		
		SqlSession session = getSqlSession();
		
		int totalCount = questionDAO.selectTotalCount(session);
		
		session.close();
		
		return totalCount;

	}
	
	

}
