package user.mapper;

import java.util.List;
import java.util.Map;

import user.model.dto.UserAppliactionByPostingDTO;
import user.model.dto.UserApplicationHistoryDTO;
import user.model.dto.UserPostingDTO;
import user.paging.SelectCriteria;

public interface UserApplicationMapper {

	int selectTotalCount(int userNo);

	List<UserApplicationHistoryDTO> selectUserApplicationList(Map<String, Object> map);

	UserPostingDTO selectUserPostingByPostingNo(int postingNo);

	List<UserAppliactionByPostingDTO> selectUSerApplicationByPosting(Map<String, Object> map);

}
