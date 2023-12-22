package kr.or.ddit.police.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.police.service.IPoliceService;
import kr.or.ddit.police.service.PoliceServiceImpl;
import kr.or.ddit.vo.PoliceVO;

@WebServlet("/police/policeList.do")
public class PoliceList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPoliceService service = PoliceServiceImpl.getInstance();
		List<PoliceVO> polList = service.getAllPol();
		
		request.setAttribute("polList", polList);
		request.getRequestDispatcher("/WEB-INF/view/police/policeList.jsp")
		.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
