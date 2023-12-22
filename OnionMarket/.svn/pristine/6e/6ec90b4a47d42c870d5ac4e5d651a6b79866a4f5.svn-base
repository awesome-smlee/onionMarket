package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.my.dao.UsersMyDaoImpl;
import kr.or.ddit.my.service.IUsersMyService;
import kr.or.ddit.my.service.UsersMyServiceImpl;
import kr.or.ddit.users.dao.IUsersDao;
import kr.or.ddit.vo.UsersVO;

/**
 * Servlet implementation class FindUserId
 */
@WebServlet("/my/FindUserId.do")
public class FindUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IUsersMyService service = UsersMyServiceImpl.getInstance();
		//------------------------------------------
		//받기
		 String username = request.getParameter("userName");
		 String usertel = request.getParameter("userPhone");
		 
		// 서비스 호출
		    UsersVO vo = new UsersVO();
		    vo.setUser_nm(username);
		    vo.setTel(usertel);
		    List<UsersVO> list = service.findIdUsers(vo);
		
			request.setAttribute("list", list);
			
			 if (list != null && !list.isEmpty()) {
			        UsersVO resultVo = list.get(0);
			        System.out.println("아이디: " + resultVo.getUser_id());
			        System.out.println("가입일: " + resultVo.getIns_dt());
			    } else {
			        System.out.println("일치하는 사용자가 없습니다.");
			    }
			//------------------------------------------
			 
			//------------------------------------------
			 
			 
	      request.getRequestDispatcher("/WEB-INF/view/my/findUser.jsp").forward(request, response);

	}

}
