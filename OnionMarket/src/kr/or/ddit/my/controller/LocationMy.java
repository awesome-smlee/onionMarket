package kr.or.ddit.my.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.LocVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/my/locationMy.do")
public class LocationMy extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession();
		 UsersVO uservo = (UsersVO) session.getAttribute("loginUser");
		
		String user_id = uservo.getUser_id();
		String dong = request.getParameter("dong");
		
		System.out.println("!!!!!!!!!!!!!" +dong);
		System.out.println("!!!!!!!!!!!" + user_id);
		//받은거 vo에 저장하기 
       ComJoinVO vo = new ComJoinVO();
       vo.setUser_id(user_id);
       vo.setDong(dong);
       
       IUsersMyService service = UsersMyServiceImpl.getInstance();
		
		int cnt = service.locationMy(vo);
		if(cnt>0) {
			System.out.println("지역 변경 업데이트 성공");		
			UsersVO sessionUserVo = service.getUsers(user_id);
			session.setAttribute("loginUser", sessionUserVo);
			
			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/my/my_main.jsp");
			
//			request.getRequestDispatcher("/WEB-INF/view/my/my_main.jsp")
//			.forward(request, response);
		}
		//
		
		
	
		
	}

}
