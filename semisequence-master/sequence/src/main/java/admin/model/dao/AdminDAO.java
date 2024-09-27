package admin.model.dao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import admin.model.dto.QuestionAndAnswerAndFileDTO;
import common.paging.SelectCriteria;
import customerCenter.model.dto.QuestionAndAnswerDTO;

@WebServlet("/AdminDAO")
public class AdminDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminDAO() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	public List<QuestionAndAnswerAndFileDTO> adminSelectAllQuestionList(SqlSession session, SelectCriteria selectCriteria) {
		
		return session.selectList("AdminDAO.adminSelectAllQuestionList", selectCriteria);
	}

	public QuestionAndAnswerAndFileDTO selectAdminQuestionDetail(SqlSession session, int queNo) {
		
		return session.selectOne("AdminDAO.selectAdminQuestionDetail", queNo);
	}

	public QuestionAndAnswerAndFileDTO selectAdminQuestionFile(SqlSession session, int queNo) {
		
		return session.selectOne("AdminDAO.selectAdminQuestionFile", queNo);
	}

	public int insertAdminAnswer(SqlSession session, QuestionAndAnswerAndFileDTO adminAnswer) {
		
		return session.insert("AdminDAO.insertAdminAnswer", adminAnswer);
	}

	public int updateAnswerYN(SqlSession session, int queNo) {
		
		return session.update("AdminDAO.updateAnswerYN", queNo) ;
	}



}
