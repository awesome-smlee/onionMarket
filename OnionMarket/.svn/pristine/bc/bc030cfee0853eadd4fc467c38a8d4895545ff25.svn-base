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
/**
 * @author 이소망
 * 물품 거래 - 목록화면 데이터 받아오는 서블릿
 */
@WebServlet("/pro/proListData.do")
public class ProListData extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 물품 서비스 객체
		IProService service = ProServiceImpl.getInstance();
		
		Map<String, Object> param = new HashMap<String, Object>();
		// 페이지네이션 파라미터
		param.put("page", request.getParameter("page"));
		param.put("rowsize", request.getParameter("rowsize"));
		
		// 검색 파라미터
		param.put("search_tit", request.getParameter("search_tit"));
		
		// 정렬 파라미터
		param.put("sort_a", request.getParameter("sort_a"));
		param.put("sort_b", request.getParameter("sort_b"));
		param.put("sort_c", request.getParameter("sort_c"));
		param.put("sort_d", request.getParameter("sort_d"));
		
		param.put("cate_id", request.getParameter("cate_id"));
		
		
		// 모든 물품 및 카테고리 정보를 가져옴
		Map proPage = service.getProPage(param);
		
		ResponseUtil.jsonOut(response, proPage);
	}
}
