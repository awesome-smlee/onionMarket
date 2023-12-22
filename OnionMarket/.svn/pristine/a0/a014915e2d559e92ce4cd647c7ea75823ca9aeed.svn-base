package kr.or.ddit.not.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.not.service.INotService;
import kr.or.ddit.not.service.NotServiceImpl;
import kr.or.ddit.vo.NotVO;

@WebServlet("/not/NotList")
public class NotList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int notiId = 0;
		INotService service = NotServiceImpl.getInstance();
		List<NotVO> notList = service.getAllNot();
		int count = service.getListCount(notiId);
		
		request.setAttribute("notList", notList);
		request.setAttribute("count", count);
		
		request.getRequestDispatcher("/WEB-INF/view/not/notList.jsp")
				.forward(request, response);

	}

}
