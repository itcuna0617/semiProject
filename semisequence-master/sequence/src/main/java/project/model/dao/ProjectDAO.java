package project.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import project.model.dto.ProjectDTO;

public class ProjectDAO extends ProjectDTO {

	public List<ProjectDTO> selectProjectList(SqlSession session, int entNo) {
		return session.selectList("ProjectDAO.selectProjectList", entNo);
	}

	public ProjectDTO selectProjectDetail(SqlSession session, int projectNo) {
		return session.selectOne("ProjectDAO.selectProject", projectNo);
	}
	
	public int selectGenreNo(SqlSession session, int projectNo) {
		return session.selectOne("ProjectDAO.selectGenreNo", projectNo);
	}

	public int updateProject(SqlSession session, ProjectDTO project) {
		return session.update("ProjectDAO.updateProject", project);
	}

	public int insertProject(SqlSession session, ProjectDTO project) {
		return session.insert("ProjectDAO.insertProject", project);
	}

	//실제로는 active_YN을 바꾸는 과정
	public int deleteProject(SqlSession session, int projectNo) {
		return session.update("ProjectDAO.deleteProject", projectNo);
	}

	public String selectProjectName(SqlSession session, int projectNo) {
		return session.selectOne("ProjectDAO.selectProjectName", projectNo);
	}

	public int deletePosting(SqlSession session, int projectNo) {
		return session.delete("ProjectDAO.deletePosting", projectNo);
	}


}
