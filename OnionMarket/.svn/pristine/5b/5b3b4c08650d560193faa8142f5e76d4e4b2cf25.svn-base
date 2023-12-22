package kr.or.ddit.main.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.main.service.IMainService;
import kr.or.ddit.main.service.MainServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.ProAndCateVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/main/main.do")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		ProAndCateVO proVo = new ProAndCateVO();
		
		
		// 현재 접속자 loc_id 추가 (내동네 물품 조회)
		HttpSession session = request.getSession();
		UsersVO userVo = (UsersVO) session.getAttribute("loginUser");
		if(userVo != null) {
			proVo.setLoc_id(userVo.getLoc_id());
		}
		
		// 서비스 객체
		IMainService service = MainServiceImpl.getInstance();
		
		// 목록 조회
		List<ProAndCateVO> proList = service.getProList(proVo);    // 물품 목록
		List<ProAndCateVO> proPopulList = service.getProListPop(); // 실시간 인기 물품
		List<ProAndCateVO> proNewList = service.getProListNew();   // 방금 등록된 물품
		List<ComJoinVO> comList = service.getComList();            // 커뮤니티 목록
		
		request.setAttribute("proList", proList);
		request.setAttribute("proPopulList", proPopulList);
		request.setAttribute("proNewList", proNewList);
		request.setAttribute("comList", comList);
		
		request.getRequestDispatcher(ResponseUtil.viewOut("/main/main", request)).forward(request, response);
	}

}
