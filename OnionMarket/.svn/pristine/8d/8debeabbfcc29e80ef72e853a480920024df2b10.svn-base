package kr.or.ddit.pro.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.pro.service.IProService;
import kr.or.ddit.pro.service.ProServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.ProAndCateVO;

/**
 * @author 이소망
 * 물품 거래 - 상세화면 좋아요 처리하는 서블릿
 */
@WebServlet("/pro/proDetailStatus.do")
public class ProDetailStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String prodId = request.getParameter("prod_id");
		String prodStatus = request.getParameter("prod_status");
		
		ProAndCateVO vo = new ProAndCateVO();
		vo.setProd_id(Integer.parseInt(prodId));
		vo.setStatus(Integer.parseInt(prodStatus));
		
		// 물품 서비스 객체
		IProService service = ProServiceImpl.getInstance();
		
		// 상태 업데이트
		int cnt = service.updateProStatus(vo);
		
		Map result = new HashMap();
		result.put("result", cnt);
		
		ResponseUtil.jsonOut(response, result);
	}

}
