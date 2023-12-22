package kr.or.ddit.my.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.webresources.ExtractingRoot;

import kr.or.ddit.my.service.IProdMyService;
import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.ProdMyServiceImpl;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.vo.ProdMyAllVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/my/join.do")
@MultipartConfig
public class Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET방식으로 요청할 때는 회원 입력 폼이 나타나도록 구현한다.
				request.getRequestDispatcher("/WEB-INF/view/my/join.jsp")
				.forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<String, Integer> locationMap = new HashMap();
//		locationMap.put("오류동", 210);
		IProdMyService service = ProdMyServiceImpl.getInstance();
		ProdMyAllVO prodMyAllVo = new ProdMyAllVO();
		
		
		
		
		
	
		//사용자가 업로드한 파일이 저장될 서버쪽의 폴더경로 설정
		String uploadPath = "d:/uploadFiles";
		
		//저장될 폴더가 없으면 폴더를 만들어 준다.
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		}
		
		request.setCharacterEncoding("utf-8");
		
		//회원정보를 받는다.
		String userId = request.getParameter("user_id");
		String userNm = request.getParameter("user_nm");
		String nickNm = request.getParameter("nick_nm");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String dong = request.getParameter("extraAddress");
		
		System.out.println("[join.java] locationName : "+ dong);
		
		
		int dongNum = service.Location(dong);
		
		
		//받아온 회원 정보를 vo에 저장한다.
		UsersVO usersVo = new UsersVO();
		usersVo.setUser_id(userId);
		usersVo.setUser_nm(userNm);
		usersVo.setNick_nm(nickNm);
		usersVo.setPw(pw);
		usersVo.setTel(tel);
		usersVo.setEmail(email);
		usersVo.setLoc_id(dongNum);
		
		
		
		// form의 file입력요소의 name값은 Part객체의 이름역할을 한다.
		// 이 이름을 이용하여 Part객체를 구한다.
		Part part = request.getPart("file_id");
		
		if(part!=null) {
			String fileName = extractFilename(part);
			
			if(!"".equals(fileName)) {
				try {
					part.write(uploadPath + File.separator + fileName);
					prodMyAllVo.setUpload_nm(fileName);
//					usersVo.setFile_id(fileName);
//					memVo.setMem_photo(fileName);  // DB에 저장할 파일명을 VO객체에 저장
				} catch (Exception e) {
					usersVo.setFile_id(null);  // 프로필 사진이 오류가 생기면...
				}
			}
		}
		
		//회원 정보를 db에 insert한다.
		IUsersMyService service2 = UsersMyServiceImpl.getInstance();
		System.out.println(usersVo);
		int count = service2.insertUsers(usersVo);
		System.out.println(count);
		//작업이 완료되면 List 페이지로 이동
		response.sendRedirect(request.getContextPath()+"/main/main.do");
		
		
		
		
		
		
		
	}


	private String extractFilename(Part part) {
		String fileName = "";
		
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) { 
				// filename="test1.txt"
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		return fileName;
	}

}
