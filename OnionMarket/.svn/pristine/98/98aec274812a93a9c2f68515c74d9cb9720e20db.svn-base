package kr.or.ddit.comrep.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comrep.service.ComRepServiceImpl;
import kr.or.ddit.comrep.service.IComRepService;

@WebServlet("/comRep/comRepDelete.do")
public class ComRepDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String repId = request.getParameter("repId");
		IComRepService service = ComRepServiceImpl.getInstance();
		service.comRepDelete(Integer.parseInt(repId));
	}

}
