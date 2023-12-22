package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IProdMyService;
import kr.or.ddit.my.service.ProdMyServiceImpl;
import kr.or.ddit.vo.ProdMyAllVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/my/communityMy.do")
@MultipartConfig
public class CommunityMy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		IProdMyService service = ProdMyServiceImpl.getInstance();
		
		
		//로그인한 데이터값을 가져오는것
		HttpSession session = request.getSession();
		UsersVO loginUserVo = (UsersVO)session.getAttribute("loginUser");

		
		List<ProdMyAllVO> myList = service.wishlistMy(loginUserVo.getUser_id());
		
		request.setAttribute("myList", myList);
		request.getRequestDispatcher("/WEB-INF/view/my/my_community.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
