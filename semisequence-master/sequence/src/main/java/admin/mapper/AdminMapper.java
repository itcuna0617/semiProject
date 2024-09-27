package admin.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import admin.model.dto.ApprovalAndEntInfoDTO;
import admin.model.dto.ApprovalDTO;
import admin.model.dto.QuestionAndAnswerAndFileDTO;
import customerCenter.model.dto.QuestionAndAnswerDTO;
import ent.model.dto.EntDTO;
import user.model.dto.UserInfoDTO;
import user.paging.SelectCriteria;

public interface AdminMapper {

	int selectTotalCount();
	
	List<ApprovalDTO> selectApproval();

	ApprovalAndEntInfoDTO selectApprovalAndEntInfoList(Map<String, Object> map);

	List<UserInfoDTO> selectUserInfo();

	int userStatusUpdate(String userNo);

	int userStatusUpdateY(String userNo);

	List<EntDTO> selectEntInfo();

	int entStatusUpdate(String userNo);

	int entStatusUpdateY(String userNo);
}
