package customerCenter.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.paging.SelectCriteria;
import customerCenter.model.dto.QuestionAndAnswerAndFileDTO;
import customerCenter.model.dto.QuestionAndAnswerDTO;
import customerCenter.model.dto.QuestionAndQuestionFileDTO;

public class QuestionDAO {

	public List<QuestionAndAnswerDTO> selectAllQuestionList(SqlSession session, SelectCriteria selectCriteria) {
	
		return session.selectList("QuestionDAO.selectAllQuestionList", selectCriteria);
	}

	public int insertNewQuestion(SqlSession session, QuestionAndQuestionFileDTO newQuestion) {
		
		return session.insert("QuestionDAO.insertNewQuestion", newQuestion);
	}

	public int insertNewQuestionFile(SqlSession session, QuestionAndQuestionFileDTO newQuestion) {
		
		return session.insert("QuestionDAO.insertQuestionFile", newQuestion);
	}

	public QuestionAndAnswerAndFileDTO selectQuestionDetail(SqlSession session, int queNo) {
		
		return session.selectOne("QuestionDAO.selectQuestionDetail", queNo);
	}

	public QuestionAndAnswerAndFileDTO selectQuestionAnswerDetail(SqlSession session, int queNo) {
		
		return session.selectOne("QuestionDAO.selectQuestionAnswerDetail", queNo);
	}

	public int selectUserQueNo(SqlSession session, int userNo) {

		return session.selectOne("QuestionDAO.selectUserQueNo", userNo);
	}
	
	public int selectEntQueNo(SqlSession session, int entNo) {

		return session.selectOne("QuestionDAO.selectEntQueNo", entNo);
	}
	
	public QuestionAndAnswerAndFileDTO selectQuestionFile(SqlSession session, int queNo) {
		
		return session.selectOne("QuestionDAO.selectQuestionFile", queNo);
	}

	public int selectTotalCount(SqlSession session) {
		
		return session.selectOne("QuestionDAO.selectTotalCount");
	}

}
