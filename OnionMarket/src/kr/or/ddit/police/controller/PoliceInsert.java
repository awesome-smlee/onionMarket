package kr.or.ddit.police.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.police.service.IPoliceService;
import kr.or.ddit.police.service.PoliceServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.PoliceVO;

@WebServlet("/police/policeInsert.do")
public class PoliceInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String tit = request.getParameter("tit");
		String cont = request.getParameter("cont");
		String insId = "ohoh55";
		
		PoliceVO polVo = new PoliceVO();
		polVo.setTit(tit);
		polVo.setCont(cont);
		polVo.setIns_id(insId);
		
		IPoliceService service = PoliceServiceImpl.getInstance();
		service.polInsert(polVo);
		
		request.getRequestDispatcher(request.getContextPath() + "/police/policeList.do")
		.forward(request, response);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

}
