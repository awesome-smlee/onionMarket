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
 * 물품 거래 - 수정화면 데이터 받아오는 서블릿
 */
@WebServlet("/pro/proUpdateData.do")
public class ProUpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 물품 서비스 객체
		IProService service = ProServiceImpl.getInstance();
		
		// 파라미터에서 물품 ID 가져오기
		String prodId = request.getParameter("prod_id");
		
		ProAndCateVO proVo = new ProAndCateVO();
		proVo.setProd_id(Integer.parseInt(prodId));
		
		// 물품 상세 조회
		proVo = service.getProDetail(proVo);
		
		ResponseUtil.jsonOut(response, proVo);
	}
}
