package kr.or.ddit.pro.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.IFNULL;

import kr.or.ddit.pro.service.IProService;
import kr.or.ddit.pro.service.ProServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.ProCateVO;

/**
 * @author 이소망
 * 물품 거래 - 목록화면 처리하는 서블릿
 */
@WebServlet("/pro/proList.do")
public class ProList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 물품 서비스 객체
		IProService service = ProServiceImpl.getInstance();
		
		// 물품 카테고리 목록 조회
		List<ProCateVO> cateList = service.getProCateList();
				
		request.setAttribute("cateList", cateList);
		
		request.getRequestDispatcher(ResponseUtil.viewOut("/pro/proList", request)).forward(request, response);
	}
}
