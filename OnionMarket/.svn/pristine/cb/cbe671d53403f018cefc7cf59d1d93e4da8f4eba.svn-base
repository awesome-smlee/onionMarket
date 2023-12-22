package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/my/findUser.do")
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		IUsersMyService service = UsersMyServiceImpl.getInstance();
		
			//아이디 찾을때 이름, 전화번호 받기
	      String username = request.getParameter("userName");
	      String usertel = request.getParameter("userPhone");
	      
	      System.out.println("유저이름" + username);
	      
	      UsersVO vo = new UsersVO();
	      vo.setUser_nm(username);
	      vo.setTel(usertel);
	      
	      
	        List<UsersVO> list = service.findIdUsers(vo);

	        // 결과값을 request에 저장
	        request.setAttribute("list", list);
	        
		
	
	    	request.getRequestDispatcher("/WEB-INF/view/my/findUser.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
