package kr.or.ddit.my.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.UsersMyServiceImpl;


@WebServlet("/my/userIdCheck.do")
public class UserIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json; charset=utf-8");
		
		// 검색할 회원ID를 받는다.
		String userId = request.getParameter("user_id");
		
		IUsersMyService service = UsersMyServiceImpl.getInstance();
		int result = service.getUsersCount(userId);

		if(result > 0) {  // 회원ID가 중복
			response.getWriter().write("Fail");
//			result = gson.toJson("Fail");
		}else {		// 회원ID가 중복되지 않음
//			result = gson.toJson("OK");
			response.getWriter().write("OK");
		}
		
//		response.getWriter().write(result);
//		response.flushBuffer();
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
