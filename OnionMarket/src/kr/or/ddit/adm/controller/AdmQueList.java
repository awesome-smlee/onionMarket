package kr.or.ddit.adm.controller;

 import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.que.service.IQueService;
import kr.or.ddit.que.service.QueServiceImpl;
import kr.or.ddit.vo.QueVO;

@WebServlet("/adm/AdmQueList")
public class AdmQueList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		int queId = 0;


		IQueService service = QueServiceImpl.getInstance();
		List<QueVO> admQueList = service.getAllQue();
		int queCount = service.getListCount(queId);

		request.setAttribute("admQueList", admQueList);
		request.setAttribute("queCount", queCount);

		request.getRequestDispatcher("/WEB-INF/view/adm/admQueList.jsp").forward(request, response);
 
	}
 
}

