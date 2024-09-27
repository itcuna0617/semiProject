package customerCenter.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;

import customerCenter.model.dto.QuestionAndQuestionFileDTO;
import customerCenter.model.service.QuestionService;
import fileIO.UUIDFileRenamePolicy;


@WebServlet("/newQuestionInsert")
public class NewQuestionInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String path = "/WEB-INF/views/customerCenter/newQuestionInsert.jsp";
		
		request.getRequestDispatcher(path).forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			/* post 방식 인코딩 설정 */
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();

			 ServletContext context = request.getServletContext();
			 int maxFileSize = 1024 * 1024 * 10;
			 String encodingType = "UTF-8";
			 
			 System.out.println("최대 업로드 파일 용량 : " + maxFileSize);
			 System.out.println("인코딩 방식 : " + encodingType);
			 
			 /* 파일 경로 설정 */
			 
			 String rootLocation = getServletContext().getRealPath("/");

			 String queFileSavedPath = rootLocation + "question";
			 
			 System.out.println(queFileSavedPath);
			 
			 /* 파일이 포함된 form은 multipart로 받는다. */
			 MultipartRequest multiRequest = new MultipartRequest(request, queFileSavedPath, maxFileSize, encodingType, new UUIDFileRenamePolicy());
			
			 /* 기업 개인회원을 비교해줄 유저타입을 받아온다. */
			String userType = (String)session.getAttribute("userType");
			 
			 /* 입력받은 값들 변수로 받는다. */
			 String queTitle = multiRequest.getParameter(("queTitle"));
			 int categoryNo = Integer.parseInt(multiRequest.getParameter(("categoryNo")));
			 String queContent = multiRequest.getParameter("queContent");
			 String queFileName = multiRequest.getFilesystemName("queFile");
			 Integer userNo = (Integer)session.getAttribute("userNo");
			 Integer entNo = (Integer)session.getAttribute("entNo");

			 
			 System.out.println("문의하기에서 userType : " + userType);
			 
			 QuestionService questionService = new QuestionService();
			 
			 /* 입력받은 정보들을 DTO에 받는다. */
			 if(userType.equals("user")) {
			 
				 QuestionAndQuestionFileDTO newQuestion = new QuestionAndQuestionFileDTO();
				 newQuestion.setCategoryNo(categoryNo);
				 newQuestion.setQueTitle(queTitle);
				 newQuestion.setQueContent(queContent);
				 newQuestion.setUserNo(userNo);
				 
				 System.out.println("newQuestion 입력 확인 : " + newQuestion);

				 int newQuestionResult = questionService.insertNewQuestion(newQuestion);	
					
				 System.out.println("newQuestion result: " + newQuestionResult);
				 
				 /* 시퀀스로 생성한 문의번호를 파일에 insert하기 위해 select해 온다. */
			
				 int queNo = (int)questionService.selectUserQueNo(userNo);
				 
				 /* 문의번호 확인 */
				 System.out.println(queNo);
				 
				 
				 /* select 해온 문의번호와 함께 insert한다 */
				 QuestionAndQuestionFileDTO newQuestionFile = new QuestionAndQuestionFileDTO();
				 newQuestionFile.setQueFileName(queFileName);
				 newQuestionFile.setQueFileSavedPath(queFileSavedPath);
				 newQuestionFile.setQueNo(queNo);
				
				 
				 /* 파일 DTO에 담겼는지 확인 */
				 System.out.println(newQuestionFile);
				 
				 int newQuestionFileResult = new QuestionService().insertNewQuestionFile(newQuestionFile);	
				
				 System.out.println("newQuestionFile result: " + newQuestionFileResult);
				 
				  String path = "";
			      
			      if(newQuestionResult > 0) {
			         path = "/WEB-INF/views/customerCenter/success.jsp";
			         request.setAttribute("successCode", "insertQuestion");
			      } else {
			         path = "/WEB-INF/views/error/500error.jsp";
			         request.setAttribute("message", "문의 작성이 실패하였습니다.");
			      }
				 
				request.getRequestDispatcher(path).forward(request, response);
				 
		
			}else if("ent".equals(userType)) {
				QuestionAndQuestionFileDTO newQuestion = new QuestionAndQuestionFileDTO();
				newQuestion.setCategoryNo(categoryNo);
				newQuestion.setQueTitle(queTitle);
				newQuestion.setQueContent(queContent);
				newQuestion.setEntNo(entNo);
				
				 /* DTO 담겼는지 확인 */
				 System.out.println("newQuestion입력 확인 : " + newQuestion);
				 
				 int newQuestionResult = new QuestionService().insertNewQuestion(newQuestion);	
					
				 System.out.println("newQuestion result: " + newQuestionResult);
				
				 /* 시퀀스로 생성한 문의번호를 파일에 insert하기 위해 select해 온다. */
				 int queNo = (int)questionService.selectEntQueNo(entNo);
				 
				 /* 문의번호 확인 */
				 System.out.println(queNo);
				 
				 /* select 해온 문의번호와 함께 insert한다 */
				 QuestionAndQuestionFileDTO newQuestionFile = new QuestionAndQuestionFileDTO();
				 newQuestionFile.setQueFileName(queFileName);
				 newQuestionFile.setQueFileSavedPath(queFileSavedPath);
				 newQuestionFile.setQueNo(queNo);
				
				 
				 /* 파일 DTO에 담겼는지 확인 */
				 System.out.println(newQuestionFile);
				 
				 int newQuestionFileResult = new QuestionService().insertNewQuestionFile(newQuestionFile);	
				
				 System.out.println("newQuestionFile result: " + newQuestionFileResult);
				 
				  String path = "";
			      
			      if(newQuestionResult > 0) {
			         path = "/WEB-INF/views/customerCenter/success.jsp";
			         request.setAttribute("successCode", "insertQuestion");
			      } else {
			         path = "/WEB-INF/views/error/500error.jsp";
			         request.setAttribute("message", "문의 작성이 실패하였습니다.");
			      }
				 
				request.getRequestDispatcher(path).forward(request, response);
				}
			}
		}
	}