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

@WebServlet("/com/comListByCate.do")
public class ComListByCate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		IComService service = ComServiceImpl.getInstance();
		
		String catekind = request.getParameter("catekind");
		String cateNm = "";
		List<ComJoinVO> comListByCate = null;
		
		switch(catekind) {
			case "모임": 
				cateNm = "모임"; 
				comListByCate = service.getByCate(cateNm); 
				break;
			case "분실": 
				cateNm = "분실"; 
				comListByCate = service.getByCate(cateNm); 
				break;
			case "정보": 
				cateNm = "정보"; 
				comListByCate = service.getByCate(cateNm); 
				break;
			case "잡담": 
				cateNm = "잡담"; 
				comListByCate = service.getByCate(cateNm); 
				break;
			case "기타": 
				cateNm = "기타"; 
				comListByCate = service.getByCate(cateNm); 
				break;
		}
		request.setAttribute("comListByCate", comListByCate);
		request.getRequestDispatcher("/WEB-INF/view/com/comListByCate.jsp")
		.forward(request, response);
	}

}
