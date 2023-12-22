package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.my.service.IProdMyService;
import kr.or.ddit.my.service.ProdMyServiceImpl;
import kr.or.ddit.vo.ProdMyAllVO;


@WebServlet("/my/sellEndMy.do")
public class SellEndMy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IProdMyService service = ProdMyServiceImpl.getInstance();
		
		//로그인한 데이터값을 가져오는것
//		HttpSession session = request.getSession();
//		UsersVO usersVo = (UsersVO) session.getAttribute("vvv");
	
//		usersVo.getUser_id()
		List<ProdMyAllVO> myList1 = service.sellEndMy("");
		
		request.setAttribute("myList1", myList1);
		request.getRequestDispatcher("/WEB-INF/view/my/my_sellList.jsp")
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
