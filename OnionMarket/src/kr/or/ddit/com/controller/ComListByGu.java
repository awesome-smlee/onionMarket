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

@WebServlet("/com/comListByGu.do")
public class ComListByGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		
		IComService service = ComServiceImpl.getInstance();
		
		String gukind = request.getParameter("gukind");
		String gu = "";
		List<ComJoinVO> comListByGu = null;
		
		switch(gukind) {
			case "대덕구": 
				gu = "대덕구"; 
				comListByGu = service.getByGu(gu);
				break;
			case "유성구": 
				gu = "유성구"; 
				comListByGu = service.getByGu(gu); 
				break;
			case "중구": 
				gu = "중구"; 
				comListByGu = service.getByGu(gu); 
				break;
			case "서구": 
				gu = "서구"; 
				comListByGu = service.getByGu(gu); 
				break;
			case "동구": 
				gu = "동구"; 
				comListByGu = service.getByGu(gu); 
				break;
		}
		
		request.setAttribute("comListByGu", comListByGu);
		request.getRequestDispatcher("/WEB-INF/view/com/comListByGu.jsp")
		.forward(request, response);
	}

}
