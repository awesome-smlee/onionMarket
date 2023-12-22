package kr.or.ddit.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.com.service.ComServiceImpl;
import kr.or.ddit.com.service.IComService;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.UsersVO;

@MultipartConfig
@WebServlet("/com/comInsert.do")
public class ComInsert extends HttpServlet { // GET: UPDATE, POST: INSERT
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		IComService service = ComServiceImpl.getInstance();
		List<ComJoinVO> comList = service.getAllCom();
		List<ComJoinVO> cateList = service.getCateNm();
		
		// ------------------------------- COMMUNITY UPDATE -------------------------------
		String comId = request.getParameter("comId"); 
		String tit = request.getParameter("title");
		String cont = request.getParameter("content");
		String cate_nm = request.getParameter("cate");
		
		ComJoinVO comVo = new ComJoinVO();
		comVo.setCom_id(Integer.parseInt(comId));
		comVo.setTit(tit);
		comVo.setCont(cont);
		comVo.setCate_nm(cate_nm);
		
		service.comUpdate(comVo);
		// ---------------------------------------------------------------------------------
		
		request.setAttribute("comList", comList);
		request.setAttribute("cateList", cateList);
		request.getRequestDispatcher(request.getContextPath() + "/com/comList.do")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("loginUser");
		
		IComService service = ComServiceImpl.getInstance();
		List<ComJoinVO> comList = service.getAllCom();
		List<ComJoinVO> cateList = service.getCateNm();
		
		// ------------------------------- COMMUNITY INSERT -------------------------------
		String tit = request.getParameter("title");
		String cont = request.getParameter("content");
		String cate_nm = request.getParameter("cate");
		
		ComJoinVO comVo = new ComJoinVO();
		comVo.setTit(tit);
		comVo.setCont(cont);
		comVo.setIns_id(vo.getUser_id());
		comVo.setCate_nm(cate_nm);
		
		service.comInsert(comVo);
		// ---------------------------------------------------------------------------------
		
		request.setAttribute("comList", comList);
		request.setAttribute("cateList", cateList);
		request.getRequestDispatcher(request.getContextPath() + "/com/comList.do")
		.forward(request, response);
	}
	
}
