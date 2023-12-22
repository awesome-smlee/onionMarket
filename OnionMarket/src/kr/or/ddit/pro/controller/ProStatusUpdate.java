package kr.or.ddit.pro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.pro.service.IProService;
import kr.or.ddit.pro.service.ProServiceImpl;
import kr.or.ddit.vo.ProAndCateVO;

/**
 * @author 이소망
 * 물품 거래 - 거래상태 데이터 처리하는 서블릿
 */
@WebServlet("/pro/proStatusUpdate.do")
public class ProStatusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IProService service = ProServiceImpl.getInstance();
		
		String prodId = request.getParameter("prod_id");
		String status = request.getParameter("status");
		
		ProAndCateVO proVo = new ProAndCateVO();
		proVo.setProd_id(Integer.parseInt(prodId));
		proVo.setStatus(Integer.parseInt(status));
		
		service.updateProStatus(proVo);
		
	}

}
