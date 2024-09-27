package user.mapper;

import java.util.List;
import java.util.Map;

import user.model.dto.OfferByPostingByentInfoDTO;

public interface UserOfferMapper {

	int selectTotalCount(int userNo);

	List<OfferByPostingByentInfoDTO> selectUSerApplicationByPosting(Map<String, Object> map);

	int updateConnectYn(int offerNo);

}
