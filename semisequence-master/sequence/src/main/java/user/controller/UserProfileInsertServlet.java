package user.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import member.model.dto.MemberDTO;
import net.coobird.thumbnailator.Thumbnails;
import user.model.dto.JobDTO;
import user.model.dto.UserAddFileDTO;
import user.model.dto.UserPhotoDTO;
import user.model.dto.UserProfileDTO;
import user.model.service.UserProfileService;


@WebServlet("/user/profile/insert")
public class UserProfileInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/views/user/userProfileInsertForm.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			String fileUploadDirectory = rootLocation + "/resources/upload/original/";
			String thumbnailDirectory = rootLocation + "/resources/upload/thumbnail/";
			
			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			if(!directory.exists() || !directory2.exists()) {
				System.out.println("폴더 생성 : " + directory.mkdirs());
				System.out.println("폴더 생성 : " + directory2.mkdirs());
			}
			
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			Map<String, String> imgMap = new HashMap<>();
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
	        fileItemFactory.setRepository(new File(fileUploadDirectory));
	        fileItemFactory.setSizeThreshold(maxFileSize);
	        
	        ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
	        try {
	        	/* request를 파싱하여 데이터 하나 하나를 FileItem 인스턴로 반환한다. */
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					/* 폼 데이터는 isFormField 속성이 true이고, 파일은 isFormField 속성이 false이다. */
					System.out.println("item 입니다." + item);
				}
				
				/* 위에서 출력해본 모든 item들을 다 처리할 것이다. */
				for(int i = 0; i < fileItems.size(); i++) {
					Map<String, String> fileMap = new HashMap<>();
					FileItem item = fileItems.get(i);
					
					if(!item.isFormField()) {
						
						/* 파일 데이터인 경우 */
						if(item.getSize() > 0) {
							
							/* 파일의 사이즈가 0보다 커야 전송된 파일이 있다는 의미이다. 
							 * 전송된 파일이 있는 경우에만 처리하고, 0인 경우에는 무시하도록 로직을 작성한다.
							 */
							String filedName = item.getFieldName();
							String originFileName = item.getName();
							
							System.out.println("fileName" + filedName);
							System.out.println("originFileName" + originFileName);
							
							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);
							
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							/* 저장할 파일 정보를 담은 인스턴스를 생성하고 */
							if("thumbnailImg1".equals(filedName)) {
								File storeFile = new File(fileUploadDirectory + "img/" + randomFileName);
								/* 저장한다 */
								item.write(storeFile);
								
								/* 필요한 정보를 Map에 담는다. */
								imgMap.put("filedName", filedName);
								imgMap.put("originFileName", originFileName);
								imgMap.put("savedFileName", randomFileName);
								imgMap.put("savePath", fileUploadDirectory);
							} else {
								File storeFile = new File(fileUploadDirectory + "file/" + randomFileName);
								
								/* 저장한다 */
								item.write(storeFile);
								
								/* 필요한 정보를 Map에 담는다. */
								fileMap.put("filedName", filedName);
								fileMap.put("originFileName", originFileName);
								fileMap.put("savedFileName", randomFileName);
								fileMap.put("savePath", fileUploadDirectory);
							}
							
							
							/* 제목 사진과 나머지 사진을 구분하고 썸네일도 생성한다. */
							int width = 0;
							int height = 0;
							if("thumbnailImg1".equals(imgMap.get("filedName"))) {
								imgMap.put("fileType", "img");
								
								/* 썸네일로 변환 할 사이즈를 지정한다. */
								width = 350;
								height = 200;
								/* 썸네일로 변환 후 저장한다. */
								Thumbnails.of(fileUploadDirectory + "img/" + randomFileName)
								.size(width, height)
								.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
								
								/* 나중에 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다. */
								imgMap.put("thumbnailPath", "/resources/upload/thumbnail/thumbnail_" + randomFileName);
							} else {
								System.out.println("포트폴리오 파일은 fileList에 저장");
								fileList.add(fileMap);
							}
						}
					} else {
						/* 폼 데이터인 경우 */
						/* 전송된 폼의 name은 getFiledName()으로 받아오고, 해당 필드의 value는 getString()으로 받아온다. 
						 * 하지만 인코딩 설정을 하더라도 전송되는 파라미터는 ISO-8859-1로 처리된다.
						 * 별도로 ISO-8859-1로 해석된 한글을 UTF-8로 변경해주어야 한다.
						 * */
//						parameter.put(item.getFieldName(), item.getString());
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
						
					}
				}
				System.out.println("fileList입니다: " + fileList);
				System.out.println("parameter : " + parameter);
				System.out.println("fileList : " + fileList);
				System.out.println("imgMap : " + imgMap );
				
				/* 프로필 정보 */
				UserProfileDTO userProfile = new UserProfileDTO();
				userProfile.setUserMiniTitle(parameter.get("userMiniTitle"));
				
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				userProfile.setUserBirth(transFormat.parse(parameter.get("userBirth")));
				userProfile.setUserPhoto(imgMap.get("thumbnailPath"));
				userProfile.setUserArea(parameter.get("userArea"));
				userProfile.setUserMainText(parameter.get("userMainText"));
				userProfile.setUserResume(parameter.get("userResume"));
				userProfile.setJobNo(Integer.parseInt(parameter.get("jobNo")));
				
				/* 회원정보 */
				HttpSession session = request.getSession();
				MemberDTO member = (MemberDTO)session.getAttribute("loginMember");
				userProfile.setUserNo(member.getUserNo());
				userProfile.setUserName(member.getUserName());
				
				/* 프로필 사진 정보 */
				UserPhotoDTO userphoto = new UserPhotoDTO();
				userphoto.setUserPhotoOriginalSavedPath(imgMap.get("savePath"));
				userphoto.setUserPhotoSavedName(imgMap.get("savedFileName"));
				userphoto.setUserPhotoSavedPath(imgMap.get("thumbnailPath"));
				System.out.println("userphoto board : " + userphoto);
				
				List<UserAddFileDTO> userAddFileList = new ArrayList<UserAddFileDTO>();
				/* 포트폴리오 파일 정보 */
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					UserAddFileDTO userAddFile = new UserAddFileDTO();
					userAddFile.setUserFileOriginalName(file.get("originFileName"));
					userAddFile.setUserFileSavedName(file.get("savedFileName"));
					
					userAddFileList.add(userAddFile);
				}
				System.out.println(" userProfile" +userProfile );
				System.out.println(" userphoto" + userphoto);
				System.out.println(" userAddFileList" + userAddFileList);
				/* 서비스 메소드를 요청한다. */
				int result = new UserProfileService().insertUserProfile(userProfile, userphoto, userAddFileList);
				
				/* 성공 실패 페이지를 구분하여 연결한다. */
				String path = "";
				if(result > 0) {
					path = "/WEB-INF/views/user/userProfileList.jsp";
					request.setAttribute("successCode", "새 프로필 등록이 성공적으로 완료되었습니다.");
				} else {
					path = "/WEB-INF/views/common/failed.jsp";
					request.setAttribute("message", "썸네일 게시판 등록 실패!");
				}
				
				request.getRequestDispatcher(path).forward(request, response);
				
			} catch (Exception e) {
				//어떤 종류의 Exception이 발생 하더라도실패 시 파일을 삭제해야 한다.
				int cnt = 0;
				for(int i = 0; i < fileList.size(); i++) {
					Map<String, String> file = fileList.get(i);
					
					File deleteFile = new File(fileUploadDirectory + "/" + file.get("savedFileName"));
					boolean isDeleted = deleteFile.delete();
					
					if(isDeleted) {
						cnt++;
					}
				}
				if(cnt == fileList.size()) {
					System.out.println("업로드에실패한 모든 사진 삭제 완료!");
					e.printStackTrace();
				} else {
					e.printStackTrace();
				}
			} 
		}
	}
}
