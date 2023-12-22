package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/my/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
			
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 아이디 비밀번호 받기
		String userId = request.getParameter("user_id");
		String userPass = request.getParameter("pw");

		// 서비스 객체 얻기
		IUsersMyService service = UsersMyServiceImpl.getInstance();

		// 서비스 메소드 호출 - 결과값 받기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", userId);
		map.put("pw", userPass);

		UsersVO vo = service.getLoginUsers(map);

		// 세션 생성!
		HttpSession session = request.getSession();
				
		// 로그인 성공
		if (vo != null) {
			
			// 일반회원, 관리자 일 경우 세션 유저정보 추가
			if(vo.getUser_tp() == 0 || vo.getUser_tp() == 4) {
				session.setAttribute("loginUser", vo);
			}
			
			switch(vo.getUser_tp()) {
				// 일반 회원 
				case 0: 
					response.sendRedirect(request.getContextPath()+"/main/main.do");
					break;
				// 휴면, 정지, 탈퇴 회원
				case 1: case 2: case 3:
					// 로그인화면 메시지 처리용
					request.setAttribute("errorCode", vo.getUser_tp());
					request.getRequestDispatcher("/WEB-INF/view/my/login.jsp").forward(request, response);
					break;
				// 관리자
				case 4: 
					response.sendRedirect(request.getContextPath()+"/adm/admMain");
					break;
			}
		}
		// 로그인 실패
		else {
			// 로그인화면 메시지 처리용
			request.setAttribute("errorCode", 0);
			request.getRequestDispatcher("/WEB-INF/view/my/login2.jsp").forward(request, response);
		}
		
	}	
}