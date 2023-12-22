package kr.or.ddit.my.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IProdMyService;
import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.ProdMyServiceImpl;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.vo.UsersVO;


@WebServlet("/my/updateMy.do")
@MultipartConfig
public class UpdateMy extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		//로그인한 데이터값을 가져오는것
		HttpSession session = request.getSession();
		UsersVO loginUserVo = (UsersVO)session.getAttribute("loginUser");
				
		IUsersMyService service = UsersMyServiceImpl.getInstance();
		UsersVO userVo = service.getUsers(loginUserVo.getUser_id());
			
		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/WEB-INF/view/my/my_update.jsp")
		.forward(request, response);
			
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자가 업로드한 파일이 저장될 서버쪽의 폴더경로 설정
//				String uploadPath = "d:/uploadFiles";
//				
//				//저장될 폴더가 없으면 폴더를 만들어 준다.
//				File uploadDir = new File(uploadPath);
//				if(!uploadDir.exists()) {
//					uploadDir.mkdirs();
//				}
		
		
				//로그인한 데이터값을 가져오는것
				HttpSession session = request.getSession();
				UsersVO loginUserVo = (UsersVO)session.getAttribute("loginUser");
				
				request.setCharacterEncoding("utf-8");
				
				//회원정보를 받는다.
				String nickNm = request.getParameter("nick_nm");
				String pw = request.getParameter("pw");
				String tel = request.getParameter("tel");
				String email = request.getParameter("email");
				
				//받아온 회원 정보를 vo에 저장한다.
				UsersVO usersVo = new UsersVO();
				usersVo.setUser_id(loginUserVo.getUser_id());
				usersVo.setNick_nm(nickNm);
				usersVo.setPw(pw);
				usersVo.setTel(tel);
				usersVo.setEmail(email);
//				usersVo.setFile_id(old_memPhto);// 일단 이전 프로필 사진으로 셋팅한다.
				
				// form의 file입력요소의 name값은 Part객체의 이름역할을 한다.
				// 이 이름을 이용하여 Part객체를 구한다.
//				Part part = request.getPart("mem_photo");
//				
//				if(part!=null) {
//					String fileName = extractFilename(part);
//					
//					if(!"".equals(fileName)) {
//						try {
//							part.write(uploadPath + File.separator + fileName);
//							
//							memVo.setMem_photo(fileName);  // DB에 저장할 파일명을 VO객체에 저장
//						} catch (Exception e) {
//							//memVo.setMem_photo(null);  // 프로필 사진이 오류가 생기면...
//						}
//					}
//				}
				
				IUsersMyService service = UsersMyServiceImpl.getInstance();
				int cnt = service.updateUsers(usersVo);
				
				if(cnt>0) {
					System.out.println("업데이트 성공");		
					UsersVO sessionUserVo = service.getUsers(usersVo.getUser_id());
					session.setAttribute("loginUser", sessionUserVo);
				}
				
				//작업이 완료되면 List 페이지로 이동
				response.sendRedirect(request.getContextPath()+"/main/main.do");
						
						
				
				
				
			}
			
//			// Part구조 안에서 파일명을 찾는 메서드
//			private String extractFilename(Part part) {
//				String fileName = "";
//				
//				String contentDisposition = part.getHeader("content-disposition");
//				String[] items = contentDisposition.split(";");
//				for(String item : items) {
//					if(item.trim().startsWith("filename")) {  
//						// filename="test1.txt"
//						fileName = item.substring(item.indexOf("=")+2, item.length()-1);
//					}
//				}
//				
//				return fileName;
//			}
				
				
				
				
	

}
