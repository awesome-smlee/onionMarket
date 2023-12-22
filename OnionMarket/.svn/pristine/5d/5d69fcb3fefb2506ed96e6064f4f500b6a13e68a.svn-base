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
import kr.or.ddit.vo.UsersVO;

/**
 * Servlet implementation class ChangePw
 */
@WebServlet("/my/changePw.do")
public class ChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		//세션
		HttpSession idvalue = request.getSession();
		UsersVO idVO = (UsersVO)idvalue.getAttribute("id");
		
		String userPw1 = request.getParameter("userPw1");
		String userPw2 = request.getParameter("userPw2");
		
		String userid = idVO.getUser_id();
		String username = idVO.getUser_nm();
		
		System.out.println("아이디!!!!!!!!!!!!!!!!" + userid  + "\n이름!!!!!!!!!!!!!!!!!!!!!!" + username);
		
		IUsersMyService service = UsersMyServiceImpl.getInstance();
		
		
		if(userPw1.equals(userPw2)) {
			System.out.println("일치");
			
			//받은거 vo에 저장
			UsersVO vo = new UsersVO();
			vo.setPw(userPw1);
			vo.setUser_id(userid);
			vo.setUser_nm(username);
			
			service.updateUserpw(vo);
			
			request.setAttribute("success", "비밀번호가 변경되었습니다. 다시 로그인해 주세요");
			request.getRequestDispatcher("/WEB-INF/view/my/login.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath()+"/WEB-INF/view/my/login.jsp");
			return;
			 
		}else {
			System.out.println("비밀번호 일치하지 않음");
			  // request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다. 다시 입력해 주세요");
		
			  request.getRequestDispatcher("/WEB-INF/view/my/changePw.jsp").forward(request, response);
			    return;
		}
	      
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
