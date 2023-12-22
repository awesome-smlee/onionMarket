package kr.or.ddit.pro.controller;

import java.io.IOException;
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

/**
 * @author 이소망
 * 물품 거래 - 상세화면 처리하는 서블릿
 */
@WebServlet("/pro/proDetail.do")
public class ProDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 물품 서비스 객체
		IProService service = ProServiceImpl.getInstance();
		
		// 파라미터에서 물품 ID 가져오기
		String prodId = request.getParameter("prod_id");
		
		UsersVO vo = (UsersVO) request.getSession().getAttribute("loginUser");
		
		ProAndCateVO proVo = new ProAndCateVO();
		proVo.setProd_id(Integer.parseInt(prodId));
		proVo.setLike_ins_id(vo.getUser_id());
		
		// 물품 상세 조회
		proVo = service.getProDetail(proVo);
		
		// 첨부파일 조회 
		
		// request객체에 상세 정보 속성 설정
		request.setAttribute("proVo", proVo);
		
		// view로 포워드
		request.getRequestDispatcher(ResponseUtil.viewOut("/pro/proDetail", request)).forward(request, response);
	}

}
