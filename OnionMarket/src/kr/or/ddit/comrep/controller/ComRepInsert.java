package kr.or.ddit.comrep.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.comrep.service.ComRepServiceImpl;
import kr.or.ddit.comrep.service.IComRepService;
import kr.or.ddit.vo.ComRepVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/comRep/comRepInsert.do")
public class ComRepInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("loginUser");
		
		String replyCont = request.getParameter("replyCont");
		String comId = request.getParameter("comId"); 
		
		IComRepService service = ComRepServiceImpl.getInstance();
		ComRepVO comRepVo = new ComRepVO();
		comRepVo.setCont(replyCont);
		comRepVo.setIns_id(vo.getUser_id());
		comRepVo.setCom_id(Integer.parseInt(comId));
		
		service.comRepInsert(comRepVo);
	}

}
