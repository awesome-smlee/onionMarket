package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.LocVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/my/locationStart.do")
public class LocationStart extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/my/my_location.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("asdf apfhdapfhdapfhdapfha멩롬엘몽ㄹ");
//		IUsersMyService service = UsersMyServiceImpl.getInstance();
//		
//		  HttpSession session = request.getSession();
//		  UsersVO uservo = (UsersVO) session.getAttribute("loginUser");
//		
//		  String user_id = uservo.getUser_id();
//		
//		//회원 정보 받기
////		String user_id = (String) request.getSession().getAttribute("user_id");
//		//String user_id = "test01";
//
//		System.out.println("아이디~~~~~~~~~~~~~~~~~~" + user_id);
////		
//	    if (user_id == null) {
//	        // 사용자 아이디가 없으면 로그인 페이지로 리다이렉트 또는 에러 처리를 수행하세요.
//	        response.sendRedirect("/my/login.do"); // 예시: 로그인 페이지로 리다이렉트
//	        return;
//	    }
//		
//		//동 정보 받기
//		String dong = request.getParameter("dong");
//		System.out.println("아이디 ==> " + user_id);
//		System.out.println("동 ==> " + dong);
//		
//		ComJoinVO vo = new ComJoinVO();
//		vo.setUser_id(user_id);
//		vo.setDong(dong);
//		
//		 int location = service.locationMy(vo);
//		 
//		 request.setAttribute("location", location);
//		
//		
//		
//		request.getRequestDispatcher("/WEB-INF/view/my/my_location.jsp")
//		.forward(request, response);
	}

}
