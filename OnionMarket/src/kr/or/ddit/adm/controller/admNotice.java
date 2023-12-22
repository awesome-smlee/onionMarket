package kr.or.ddit.adm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.adm.service.INoticeService;
import kr.or.ddit.adm.service.NoticeServiceImpl;
import kr.or.ddit.not.service.INotService;
import kr.or.ddit.not.service.NotServiceImpl;
import kr.or.ddit.vo.NotVO;
import kr.or.ddit.vo.NoticeVO;


@WebServlet("/adm/admNotice.do")
public class admNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		INoticeService service = NoticeServiceImpl.getInstance();
//		List<NoticeVO> noticeList = service.getAllNotice();
//		request.setAttribute("noticeList", noticeList);
		
		
		INotService service = NotServiceImpl.getInstance();
		List<NotVO> notList = service.getAllNot();
 		
		request.setAttribute("notList", notList);
		
		request.getRequestDispatcher("/WEB-INF/view/adm/admNotice.jsp")
		.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
