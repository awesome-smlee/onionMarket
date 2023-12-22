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


@WebServlet("/my/sellListMy.do")
public class SellListMy extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProdMyService service = ProdMyServiceImpl.getInstance();
	
		//로그인한 데이터값을 가져오는것
		HttpSession session = request.getSession();
		UsersVO loginUserVo = (UsersVO)session.getAttribute("loginUser");
	
		
		List<ProdMyAllVO> myList = service.sellListMy(loginUserVo.getUser_id());
		List<ProdMyAllVO> myList1 = service.sellEndMy(loginUserVo.getUser_id());
		
		request.setAttribute("myList", myList);
		request.setAttribute("myList2", myList1);
		request.getRequestDispatcher("/WEB-INF/view/my/my_sellList.jsp")
		.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
