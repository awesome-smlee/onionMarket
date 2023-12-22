package kr.or.ddit.pro.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.pro.dao.ProDaoImpl;
import kr.or.ddit.pro.service.IProService;
import kr.or.ddit.pro.service.ProServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/pro/proUpdateViewCnt.do")
public class ProUpdateViewCnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodId = request.getParameter("prod_id");
		//UsersVO usersVo = (UsersVO)request.getSession().getAttribute("loginUser");
		
		ProAndCateVO proVo = new ProAndCateVO();
		proVo.setProd_id(Integer.parseInt(prodId));
		
		IProService service = ProServiceImpl.getInstance();
		int result = service.updateViewCnt(proVo);
		
		System.out.println("결과 : " + result);
		
		ResponseUtil.jsonOut(response, result);
		
	}


}
