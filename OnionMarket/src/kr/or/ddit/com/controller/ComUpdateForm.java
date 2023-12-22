package kr.or.ddit.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.com.service.ComServiceImpl;
import kr.or.ddit.com.service.IComService;
import kr.or.ddit.vo.ComJoinVO;

@WebServlet("/com/comUpdateForm.do")
public class ComUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comId = Integer.parseInt(request.getParameter("comId"));
		IComService service = ComServiceImpl.getInstance();
		ComJoinVO comVo = service.getUpdateData(comId);
		String tit = comVo.getTit();
		String cont = comVo.getCont();
		List<ComJoinVO> cateList = service.getCateNm(); // 카테고리명
		
		request.setAttribute("comId", comId);
		request.setAttribute("tit", tit);
		request.setAttribute("cont", cont);
		request.setAttribute("cateList", cateList);
		request.getRequestDispatcher("/WEB-INF/view/com/comUpdate.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
