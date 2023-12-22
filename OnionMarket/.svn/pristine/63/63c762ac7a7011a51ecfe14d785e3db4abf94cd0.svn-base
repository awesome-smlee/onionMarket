package kr.or.ddit.adm.controller;

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


@WebServlet("/adm/admPolice.do")
public class admPolice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IPoliceService service = PoliceServiceImpl.getInstance();
		List<PoliceVO> policeList = service.getAllPol();
	
		request.setAttribute("policeList", policeList);
		
		request.getRequestDispatcher("/WEB-INF/view/adm/admPolice.jsp")
		.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
