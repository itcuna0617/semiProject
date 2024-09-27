package project.model.service;

import static common.mybatis.Template.getSqlSession;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import posting.model.dao.PostingDAO;
import project.model.dao.ProjectDAO;
import project.model.dto.ProjectDTO;

public class ProjectService {
	
	private final ProjectDAO projectDAO;
	private final PostingDAO postingDAO;

	public ProjectService() {
		projectDAO = new ProjectDAO();
		postingDAO = new PostingDAO();
		
	}

	public List<ProjectDTO> selectProjectList(int entNo) {
		SqlSession session = getSqlSession();
		System.out.println("service 도달 확인");
		
		List<ProjectDTO> projectList = projectDAO.selectProjectList(session, entNo);
		
		session.close();
		for (ProjectDTO project : projectList) {
			System.out.println(project);
		}
		return projectList;
	}

	public ProjectDTO selectProjectDetail(int projectNo) {
		SqlSession session = getSqlSession();
		
		ProjectDTO project = projectDAO.selectProjectDetail(session, projectNo);
		
		session.close();
		
		System.out.println(project);
		
		return project;
	}
	
	public int selectGenreNo(int projectNo) {
		SqlSession session = getSqlSession();
		
		int genreNo = projectDAO.selectGenreNo(session, projectNo);
		
		session.close();
		
		return genreNo;
	}

	public boolean updateProject(ProjectDTO project) {
		SqlSession session = getSqlSession();
		
		int result = projectDAO.updateProject(session, project);
		
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		
		
		session.close();
		
		System.out.println(result);
		
		return result > 0 ? true : false;
	}

	public boolean insertProject(ProjectDTO project) {
		SqlSession session = getSqlSession();
		
		int result = projectDAO.insertProject(session, project);
		
		if(result == 1) {
			session.commit();
		} else {
			session.rollback();
		}
		
		session.close();
		
		return result ==1 ? true : false;
	}

	public boolean deleteProject(int projectNo) {
		SqlSession session = getSqlSession();
		System.out.println("service 도착" + projectNo);
		
		int result = projectDAO.deleteProject(session, projectNo);
			System.out.println("첫번째 로직 실행");
		int result2 = postingDAO.deletePostingGroupByProject(session, projectNo);
			System.out.println("dao 종료");
		if(result==1 && result2 > 0 ) {
			session.commit();
			System.out.println("삭제 성공");
		} else {
			session.rollback();
			System.out.println("삭제 실패");
			System.out.println("project 삭제 : " + result);
			System.out.println("posting 삭제 : " + result2);
		}
		
		session.close();
		
		return (result==1 && result2 > 0)?true : false;
	}

	public String selectProjectName(int projectNo) {
		SqlSession session = getSqlSession();
		
		String projectName = projectDAO.selectProjectName(session, projectNo);
		return projectName;
	}

	public boolean deletePosting(int projectNo) {
		SqlSession session = getSqlSession();
		
		int result = projectDAO.deletePosting(session, projectNo);
		
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		} 
		
		session.close();
		
		return result>0? true : false;
	}

	
	
	
	
}
