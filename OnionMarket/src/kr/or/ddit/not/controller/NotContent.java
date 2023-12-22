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

@WebServlet("/not/notContent.do")
public class NotContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
 		    INotService service = NotServiceImpl.getInstance();
		    
		    List<NotVO> notList = service.getAllNot();

		    String notNum = request.getParameter("noti_id");
		    
 		    int noti_id = Integer.parseInt(notNum); // 문자열을 정수로 변환합니다.
 
  			service.updateNot(noti_id);

		    request.setAttribute("notList", notList);

		    request.getRequestDispatcher("/WEB-INF/view/not/notContent.jsp").forward(request, response);
		}
}