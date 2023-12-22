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
import kr.or.ddit.vo.UsersVO;
import kr.or.ddit.vo.WishVO;

/**
 * @author 이소망
 * 물품 거래 - 상세화면 좋아요 처리하는 서블릿
 */
@WebServlet("/pro/proDetailLike.do")
public class ProDetailLike extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 파라미터에서 좋아요 처리 코드 가져오기 
		String process = request.getParameter("process");
		// 파라미터에서 물품 ID 가져오기
		String prodId = request.getParameter("prod_id");
		// 세션에서 접속자 ID 가져오기 (좋아요 누른 사람)
		UsersVO usersVo = (UsersVO) request.getSession().getAttribute("loginUser");
		
		
		// 객체 저장
		WishVO wsVo = new WishVO();
		wsVo.setProd_id(Integer.parseInt(prodId));
		wsVo.setIns_id(usersVo.getUser_id());
		
		// 물품 서비스 객체
		IProService service = ProServiceImpl.getInstance();
		
		int cnt = 0;
		if("0".equals(process)) {
			// 1: 좋아요 성공, 2: 좋아요 실패
			cnt = service.insertLike(wsVo) > 0 ? 1 : 2;
		} else {
			// 3: 좋아요 취소 성공, 4: 좋아요 취소 실패
			cnt = service.deleteLike(wsVo) > 0 ? 3 : 4;
		}
		
		Map result = new HashMap();
		result.put("result", cnt);
		
		ResponseUtil.jsonOut(response, result);
	}

}
