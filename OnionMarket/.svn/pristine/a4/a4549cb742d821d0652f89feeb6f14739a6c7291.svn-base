package kr.or.ddit.pro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.ddit.pro.service.IProService;
import kr.or.ddit.pro.service.ProServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.UsersVO;
/**
 * @author 이소망
 * 물품 거래 - 등록화면 폼 전송 처리하는 서블릿
 */
@WebServlet("/pro/proInsertForm.do")
@MultipartConfig
public class ProInsertForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		// 세션 id
		HttpSession session = request.getSession();
		UsersVO uservo = (UsersVO) session.getAttribute("loginUser");
		String user_id = uservo.getUser_id();
	
		// 등록정보
		String cateId = request.getParameter("cate_id");
		String tit = request.getParameter("tit");
		String cont = request.getParameter("cont");
		String price = request.getParameter("price");
		String lat = request.getParameter("lat"); // 위도
		String lng = request.getParameter("lng"); // 경도
		String gu = request.getParameter("pro_gu");
		String dong = request.getParameter("pro_dong");
		
		// 받아온 물품 정보 VO에 저장
		ProAndCateVO proVo = new ProAndCateVO();
		proVo.setIns_id(user_id); //등록자 id
		proVo.setTit(tit);
		proVo.setCont(cont);
		proVo.setPrice(Integer.parseInt(price));
		proVo.setCate_id(cateId);
		proVo.setLat(Double.parseDouble(lat)); // 위도
		proVo.setLng(Double.parseDouble(lng)); // 경도
		proVo.setPro_gu(gu);
		proVo.setPro_dong(dong);
		
		// 물품 서비스 객체
		IProService service = ProServiceImpl.getInstance();
		
		
		
		// 수정 여부
		String prod_id = request.getParameter("prod_id");
		boolean isUpdate = !"".equals(prod_id);
		
		int cnt = 0;
		/* 수정 일 경우 */
		if(isUpdate) {
			proVo.setProd_id(Integer.parseInt(prod_id));
			// 기존 물품 정보를 UPDATE
			cnt = service.updatePro(proVo, request);
		}
		/* 등록 일 경우 */
		else {
			// 물품 정보를 DB에 INSERT
			cnt = service.insertPro(proVo, request);
		}
		
		
		
		if(cnt > 0) {
			// 작업이 완료되면 목록화면으로 이동 
			//response.sendRedirect(request.getContextPath() + "/pro/proList.do");
			response.sendRedirect(request.getContextPath() + "/pro/proDetail.do" 
					+ "?prod_id=" + proVo.getProd_id() + "&isInsert=true");
		}
		
		
	}
}
