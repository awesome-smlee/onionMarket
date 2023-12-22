package kr.or.ddit.my.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.my.service.IProdMyService;
import kr.or.ddit.my.service.ProdMyServiceImpl;
import kr.or.ddit.vo.ProdMyAllVO;
import kr.or.ddit.vo.UsersVO;


@WebServlet("/my/reviewMy.do")
public class ReviewMy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final ProdMyAllVO ProdMyAllVO = null;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 //세션에서 현재 로그인된 사용자 정보 가져오기
		
        HttpSession session = request.getSession();
//		UsersVO loginUser = (UsersVO) session.getAttribute("loginUser");
		
		String sessionValue = (String)session.getAttribute("userid");
		
        if (sessionValue == null) {
            // 로그인되어 있지 않다면 로그인 페이지로 이동하거나, 필요한 처리를 수행
            // 예: response.sendRedirect("/login"); 또는 에러 메시지 설정 후 에러 페이지로 이동
            response.sendRedirect("/WEB-INF/view/my/login.jsp"); // 로그인 페이지로 이동하는 예시         
            return;
        }
		IProdMyService service = ProdMyServiceImpl.getInstance();
		
		List<ProdMyAllVO> review = service.review(ProdMyAllVO);
		
		System.out.println(ProdMyAllVO + "vo!!");
		
		System.out.println(review);

		request.setAttribute("review", review);
		
			System.out.println(review);
		
		request.getRequestDispatcher("/WEB-INF/view/my/my_review.jsp")
		.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
