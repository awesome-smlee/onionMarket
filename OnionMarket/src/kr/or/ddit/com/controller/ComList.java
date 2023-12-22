package kr.or.ddit.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.com.service.ComServiceImpl;
import kr.or.ddit.com.service.IComService;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/com/comList.do")
public class ComList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IComService service = ComServiceImpl.getInstance();
		
		List<ComJoinVO> comList = service.getAllCom(); // 목록 조회
		List<ComJoinVO> cateList = service.getCateNm(); // 카테고리명
		
		request.setAttribute("comList", comList);
		request.setAttribute("cateList", cateList);
		request.getRequestDispatcher("/WEB-INF/view/com/comList.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
