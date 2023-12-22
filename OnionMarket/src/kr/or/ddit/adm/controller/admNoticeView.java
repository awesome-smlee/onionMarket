package kr.or.ddit.adm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServiceImpl;
import kr.or.ddit.police.service.IPoliceService;
import kr.or.ddit.police.service.PoliceServiceImpl;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PoliceVO;


@WebServlet("/adm/admNoticeView.do")
public class admNoticeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
//		
//		  String tit = request.getParameter("tit");
//		  
//		  
//		  INoticeService service = NoticeServiceImpl.getInstance(); NoticeVO notiVo =
//		  service.getNotice(tit);
//		  
//		  request.setAttribute("noticeVo", notiVo);
		 
		INoticeService service = NoticeServiceImpl.getInstance();
		List<NoticeVO> noticeList = service.getAllNotice();
		
		request.setAttribute("noticeList", noticeList);
		
		
		request.getRequestDispatcher("/WEB-INF/view/adm/admNoticeUpdate.jsp")
		.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
