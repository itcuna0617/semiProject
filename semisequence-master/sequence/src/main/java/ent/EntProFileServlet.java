package ent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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

import ent.model.dto.EntDTO;
import ent.model.dto.EntPhotoDTO;
import ent.model.dto.EntProfileDTO;
import ent.model.service.EntService;
import net.coobird.thumbnailator.Thumbnails;

/**
 * Servlet implementation class EntProFileServlet
 */
@WebServlet("/ent/profile")
public class EntProFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		EntService entService = new EntService();
		
		String path = "";
		
		/* request요청이 encType="multipart/form-data" 라면 */
		if(ServletFileUpload.isMultipartContent(request)) {
			
			/* 최상위 경로, 최대 파일크기, 인코딩 타입을 변수로 저장해둔다.(밑에서 쓸거임) */
			String rootLocation = getServletContext().getRealPath("/");
			int maxFileSize = 1024 * 1024 * 10;
			String encodingType = "UTF-8";
			
			/* 위에서 설정한 변수가 제대로 가져와지는지 확인함 */
			System.out.println("rootLoacation: " + rootLocation);
			System.out.println("maxFileSize: " + maxFileSize);
			System.out.println("encodingType: " + encodingType);
			
			/* 원본 사진과 리사이징된 이미지를 각각 저장하기 위해 경로를 따로 만들었다. */
			String fileUploadDirectory = rootLocation + "/entProfile/upload/original/";
			String thumbnailDirectory = rootLocation + "/entProfile/upload/thumbnail/";
			
			File directory = new File(fileUploadDirectory);
			File directory2 = new File(thumbnailDirectory);
			
			/* 위 두 파일 경로가 존재하지 않는다면 생성한다. */
			if(!directory.exists() || !directory2.exists()) {
				System.out.println(directory.mkdirs());
				System.out.println(directory2.mkdirs());
			}
			
			Map<String, String> fileMap = new HashMap<>();
			
			/* 파일은 리스트로, 외의 정보는 Map에 담을것이다. */
			Map<String, String> parameter = new HashMap<>();
			List<Map<String, String>> fileList = new ArrayList<>();
			
			/* 파일 업로드시 최대 파일 크기 및 임시저장 경로를 포함하기 위한 인스턴스를 만듬 */
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			fileItemFactory.setRepository(new File(fileUploadDirectory));
			fileItemFactory.setSizeThreshold(maxFileSize);
			
			/* commons fileupload 라이브러리에 있는것으로 import 할것*/
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
			
			try {
				List<FileItem> fileItems = fileUpload.parseRequest(request);
				
				for(FileItem item : fileItems) {
					/* 파일의 isFormField 속성은 false이다. */
					System.out.println(item);
				}
				
				/* 위에서 출력해본 item을 전부 처리할것이다. */
				for(int i = 0; i < fileItems.size(); i++) {
					FileItem item = fileItems.get(i);
					
					/* item이 파일인 경우에 대한 처리 */
					if(!item.isFormField()) {
						
						/*
						 * 데이터의 크기는 0 이상일때만 저장할 가치가 있음
						 * (0인 경우에는 가볍게 무시되게 하자)
						 */
						if(item.getSize() > 0) {
							
							/* 파일의 이름과 원본파일의 이름을 변수에 저장 */
							String filedName = item.getFieldName();
							String originFileName = item.getName();
							
							/* 
							 * 확장자명으로 자르기 위해 .의 인덱스를 저장하고
							 * 잘라내버리자
							 */
							int dot = originFileName.lastIndexOf(".");
							String ext = originFileName.substring(dot);
							
							/*
							 * 파일명 겹치지 않도록 UUID를 랜덤으로 생성해서 파일명으로 사용할것이기 때문에
							 * UUID 생성시 생기는 랜덤수의 중간의 "-" 를 없애고 위에서 잘라낸 ext를 붙인다.  
							 */
							String randomFileName = UUID.randomUUID().toString().replace("-", "") + ext;
							
							/* 저장할 파일 정보를 담은 인스턴스 생성 */
							File storeFile = new File(fileUploadDirectory + "/" + randomFileName);
							
							/* 저.장. */
							item.write(storeFile);
							
							/* 필요한 정보를 Map에 담는다. */
							fileMap.put("filedName", filedName);
							fileMap.put("originFileName", originFileName);
							fileMap.put("savedFileName", randomFileName);
							fileMap.put("savePath", fileUploadDirectory);
							
							int width = 0;
							int height = 0;
							if("thumbnailImg1".equals(filedName)) {
								fileMap.put("fileType", "TITLE");
								
								width = 240;
								height = 160;
							} 
							
							/* 썸네일로 변환 후 저장한다. */
							Thumbnails.of(fileUploadDirectory + randomFileName)
							.size(width, height)
							.toFile(thumbnailDirectory + "thumbnail_" + randomFileName);
							
							/* 나중에 웹서버에서 접근 가능한 경로 형태로 썸네일의 저장 경로도 함께 저장한다. */
							fileMap.put("thumbnailPath", "/entProfile/upload/thumbnail/thumbnail_" + randomFileName);
							
							fileList.add(fileMap);
							
						}
					} else {	// 폼 데이터인 경우
						/* fieldname의 value를 받아와 utf-8로 변경 */
						parameter.put(item.getFieldName(), new String(item.getString().getBytes("ISO-8859-1"), "UTF-8"));
					}
				}
				
				EntDTO entDTO = (EntDTO)session.getAttribute("loginMember");
				
				EntProfileDTO entProfileDTO = new EntProfileDTO();
				entProfileDTO.setEntPhoto(fileMap.get("thumbnailPath"));
				entProfileDTO.setEntIntro(parameter.get("entIntroduce"));
				entProfileDTO.setEntResume(parameter.get("entHistory"));
				entProfileDTO.setEntNo(entDTO.getEntNo());
				
				int result = entService.entInsertProfile(entProfileDTO);
				
				System.out.println(result);
				
				int profNo = entService.entSelectProfNo((int)session.getAttribute("entNo"));
				
				System.out.println(profNo);
				
				/* 서비스에 요청할 수 있도록 EntPhotoDTO에 담는다(파일(이미지)의 저장 정보) */
				EntPhotoDTO entPhotoDTO = new EntPhotoDTO();
				entPhotoDTO.setEntProfNo(profNo);
				entPhotoDTO.setPhotoOriginalSavedPath(fileUploadDirectory);
				entPhotoDTO.setPhotoSavedName(fileMap.get("savedFileName"));
				entPhotoDTO.setPhotoSavedPath(fileMap.get("thumbnailPath"));
				
				int result2 = entService.entInsertPhoto(entPhotoDTO);
				
				if(result > 0 && result2 > 0) {
					path = "/WEB-INF/views/ent/entProFileDetail.jsp";
					request.setAttribute("entProfile", entProfileDTO);
					session.setAttribute("entProfileImg", fileMap.get("thumbnailPath"));
					System.out.println("프로필 등록 완료");
				} else {
					path = "/WEB-INF/views/ent/entProfile.jsp";
					System.out.println("프로필 등록 실패");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
}
