package kr.or.ddit.que.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;

import kr.or.ddit.que.service.IQueService;
import kr.or.ddit.que.service.QueServiceImpl;
import kr.or.ddit.vo.QueVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/que/QueIns.do")
public class QueIns extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/que/queIns.jsp")
		.forward(request, response);
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
 
		IQueService service = QueServiceImpl.getInstance();
 		
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("loginUser");
		
		// 회원 정보를 받는다.
 				String queTit = request.getParameter("que_tit");
				String  cont = request.getParameter("cont");
				
				// 받아온 회원 정보를 VO에 저장한다.
				QueVO queVo = new QueVO();
				
 				queVo.setTit(queTit);
				queVo.setCont(cont);
 				queVo.setIns_id(vo.getUser_id());
		
				service.queIns(queVo);
		
		        response.sendRedirect(request.getContextPath() + "/que/QueList.do");
		        
	}

}

