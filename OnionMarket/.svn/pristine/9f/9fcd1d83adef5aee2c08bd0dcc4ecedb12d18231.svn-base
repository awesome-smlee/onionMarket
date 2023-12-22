package kr.or.ddit.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.com.service.ComServiceImpl;
import kr.or.ddit.com.service.IComService;
import kr.or.ddit.vo.ComJoinVO;

@WebServlet("/com/comListBySearch.do")
public class ComListBySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String keyword = request.getParameter("searchText");
		System.out.println("keyword: " + keyword);
		
		IComService service = ComServiceImpl.getInstance();
		
		List<ComJoinVO> cateList = service.getCateNm();
		List<ComJoinVO> comSearchList = service.getSearchCom(keyword);
		
		request.setAttribute("cateList", cateList);
		request.setAttribute("comSearchList", comSearchList);
		request.getRequestDispatcher("/WEB-INF/view/com/comListBySearch.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
