package user.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.dto.UserAddFileDTO;
import user.model.dto.UserPhotoDTO;
import user.model.service.UserProfileService;

@WebServlet("/user/profile/delete")
public class UserProfileDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userProfileNo = Integer.parseInt(request.getParameter("no"));
		
		UserProfileService userProfileService = new UserProfileService();
		
		/* 저장되어있는 포트폴리오 파일 삭제 */
		List<UserAddFileDTO> fileNameList = userProfileService.selectUserAddFileSavedName(userProfileNo);
		String fileDirectory = getServletContext().getRealPath("/resources/upload/original/file/");
		
		int fileResult = 0;
		for(int i = 0; i < fileNameList.size();i++) {
			String fileName = fileNameList.get(i).getUserFileSavedName();
			File file = new File(fileDirectory + fileName);
			
			if(file.exists()) {			// 해당 경로에 파일 삭제
				file.delete();
				System.out.println("포트폴리오 파일 삭제 성공");
				fileResult++;
			} else {
				System.out.println("포트폴리오 파일 삭제 실패");
			}
		}
		
		/* 저장되어 있는 프로필사진, 썸네일 파일 삭제 */
		UserPhotoDTO userPhoto = userProfileService.selectUserPhotoByUserProfileNo(userProfileNo);
		String photoDirectory = getServletContext().getRealPath("/resources/upload/original/img/");
		String photoFileName = userPhoto.getUserPhotoSavedName();
		String thumnailDirectory = getServletContext().getRealPath("");
		String thumnailSavedPath = userPhoto.getUserPhotoSavedPath();
		
		int photoResult = 0;
		File photoFile = new File(photoDirectory + photoFileName);
		if(photoFile.exists()) {		
			photoFile.delete();
			System.out.println("프로필 사진 파일 삭제 성공");
			photoResult++;
		} else {
			System.out.println("프로필 사진 "
					+ "파일 삭제 실패");
		}
		File thumnailFile = new File(thumnailDirectory + thumnailSavedPath);
		if(thumnailFile.exists()) {		
			thumnailFile.delete();
			System.out.println("썸네일 파일 삭제 성공");
			photoResult++;
		} else {
			System.out.println("썸네일 파일 삭제 실패");
		}
		
		/* 프로필, 첨부파일, 사진 delete */
		int result = userProfileService.deleteUserProfile(userProfileNo);
		
		System.out.println("result: " + result);
		System.out.println("fileResult: " + fileResult);
		System.out.println("photoResult: " + photoResult);
		
		String path = "";
		if(result >0 && fileResult == fileNameList.size() && photoResult ==2) {														
			path = "/WEB-INF/views/user/userProfileList.jsp";					
			request.setAttribute("successCode", "성공적으로 프로필 삭제에 성공했습니다.");								
		} else {	
			path = "/WEB-INF/views/common/userFailed.jsp";
			request.setAttribute("message", "프로필 삭제에 실패하였습니다.");
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
