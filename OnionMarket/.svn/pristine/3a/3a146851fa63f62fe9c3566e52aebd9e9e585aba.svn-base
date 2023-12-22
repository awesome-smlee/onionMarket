package kr.or.ddit.my.controller;

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
import kr.or.ddit.vo.ProdMyAllVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/my/deleteMy.do")
@MultipartConfig
public class DeleteMy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("utf-8");
		
		
		//로그인한 데이터값을 가져오는것
		HttpSession session = request.getSession();
		UsersVO loginUserVo = (UsersVO)session.getAttribute("loginUser");

		IUsersMyService service = UsersMyServiceImpl.getInstance();
		
		
		UsersVO userVo = service.getUsers(loginUserVo.getUser_id());
			
		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/WEB-INF/view/my/my_delete.jsp")
		.forward(request, response);
			
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//회원정보를 받는다.
		String userId = request.getParameter("user_id");
		String reason = request.getParameter("reason");
		String pw = request.getParameter("pw");
		
		
		//받아온 회원 정보를 vo에 저장한다.
		UsersVO usersVo = new UsersVO();
		usersVo.setUser_id(userId);
		usersVo.setReason(reason);
		usersVo.setPw(pw);
		
		
		IUsersMyService service = UsersMyServiceImpl.getInstance();
		int cnt = service.deleteUsers(usersVo);
		
		if(cnt>0) {
			//세션삭제
			HttpSession session = request.getSession();
			session.invalidate();
			//작업이 완료되면 List 페이지로 이동
			response.sendRedirect(request.getContextPath()+"/main/main.do");
		}else {
			response.sendRedirect(request.getContextPath()+"/my/deleteMy.do");
		}
		
	}

}
