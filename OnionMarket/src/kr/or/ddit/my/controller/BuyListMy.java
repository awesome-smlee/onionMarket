package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IProdMyService;
import kr.or.ddit.my.service.ProdMyServiceImpl;
import kr.or.ddit.vo.ProdMyAllVO;
import kr.or.ddit.vo.UsersVO;


@WebServlet("/my/buyListMy.do")
public class BuyListMy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		//로그인 세션
		HttpSession session = request.getSession();
		UsersVO loginUser = (UsersVO) session.getAttribute("loginUser");
		
		
		//로그인 안 되어 있다면?
		 if (loginUser == null) {
	            response.sendRedirect("/WEB-INF/view/my/login.jsp"); // 로그인 페이지로 이동하는 예시         
	            return;
	        }
		 
		 
		//서비스 객체 얻기
		IProdMyService service = ProdMyServiceImpl.getInstance();

		//서비스 메소드 호출 - 결과값 받기
		ProdMyAllVO vo = new ProdMyAllVO();
		
		String userid = loginUser.getUser_id();
	        vo.setUser_id(userid);
		
		//서비스불러
		List<ProdMyAllVO> buyList = service.buyListMy(userid);
		
		 //결과값을 request에 저장 
		request.setAttribute("buyList", buyList);
		
		request.getRequestDispatcher("/WEB-INF/view/my/my_buyList.jsp")
		.forward(request, response);
	
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
