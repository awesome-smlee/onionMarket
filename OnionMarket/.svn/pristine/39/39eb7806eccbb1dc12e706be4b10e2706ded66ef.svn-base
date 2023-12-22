package kr.or.ddit.que.controller;

import java.io.IOException;
import java.util.List;

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
 
@WebServlet("/que/QueList.do")
public class QueList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("loginUser");
 		
	    IQueService service = QueServiceImpl.getInstance();
		List<QueVO> queList = service.getAllQue();

		request.setAttribute("queList", queList);
		request.setAttribute("loginUser", vo.getUser_id());
 
		request.getRequestDispatcher("/WEB-INF/view/que/queList.jsp").forward(request, response);

	}
 
}
