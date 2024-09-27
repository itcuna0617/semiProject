package ent;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import ent.model.dto.EntDTO;
import ent.model.dto.EntPhotoDTO;
import ent.model.dto.EntProfileDTO;
import ent.model.dto.PaymentHistoryDTO;
import ent.model.dto.RatePlanByEntDTO;
import ent.model.dto.RatePlanDTO;

public interface EntInfoMapper {

	String selectEncryptedPwd(EntDTO requestMember);

	int entInfoDelete(EntDTO requestMember);

	int entInfoPasswordUpdate(EntDTO entInfo);

	int entInfoUpdate(EntDTO entDTO);

	List<PaymentHistoryDTO> selectPaymentHistory(int entNo);

	int entInsertProfile(EntProfileDTO entProfileDTO);

	int entSelectProfNo(int entNo);

	int entInsertPhoto(EntPhotoDTO entPhotoDTO);

	EntProfileDTO selectProfYn(int entNo);

	int entUpdateProfile(EntProfileDTO entProfileDTO);

	int entUpdatePhoto(EntPhotoDTO entPhotoDTO);

	String selectProfileImg(int entNo);

	RatePlanByEntDTO selectRatePlanByEntInfo(int entNo);

	int insertPaymentHistory(PaymentHistoryDTO paymentHistoryDTO);

	int selectPaymentNo(int entNo);

	RatePlanDTO selectRatePlanInfo(String planName);

	int UpdateRatePlanByEnt(RatePlanByEntDTO ratePlanByEntDTO);

	String entSelectPasword(int entNo);

}
