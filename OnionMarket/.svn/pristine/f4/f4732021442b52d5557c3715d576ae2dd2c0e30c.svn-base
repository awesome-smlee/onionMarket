package kr.or.ddit.com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.com.service.ComServiceImpl;
import kr.or.ddit.com.service.IComService;
import kr.or.ddit.comrep.service.ComRepServiceImpl;
import kr.or.ddit.comrep.service.IComRepService;
import kr.or.ddit.vo.ComJoinVO;
import kr.or.ddit.vo.ComRepVO;
import kr.or.ddit.vo.UsersVO;

@WebServlet("/com/comDetail.do")
public class ComDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IComService service = ComServiceImpl.getInstance();

		List<ComJoinVO> cateList = service.getCateNm(); // 카테고리
		request.setAttribute("cateList", cateList);
		
		int comId = Integer.parseInt(request.getParameter("com_id")); // 클릭한 게시글 번호 
		request.setAttribute("comId", comId);
		service.incrementVwCnt(comId);
		String insId = service.getInsId(comId);
		
		ComJoinVO comVo = service.getComDetail(comId); // 게시글
		request.setAttribute("comVo", comVo);
		
		IComRepService repService = ComRepServiceImpl.getInstance(); 
		List<ComRepVO> repList = repService.getReply(comId);	// 댓글 목록
		request.setAttribute("repList", repList);
		
		int count = repService.getRepCount(comId);				// 댓글 수
		request.setAttribute("count", count);
		
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("loginUser");
		
		request.setAttribute("insId", insId);
		request.setAttribute("loginUser", vo);
		request.getRequestDispatcher("/WEB-INF/view/com/comDetail.jsp")
		.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
