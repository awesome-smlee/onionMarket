package kr.or.ddit.que.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import kr.or.ddit.que.service.IQueService;
import kr.or.ddit.que.service.QueServiceImpl;
import kr.or.ddit.vo.QueVO;

@WebServlet("/que/queDetail.do")
public class QueDetail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        
        String queId = request.getParameter("que_id");
        IQueService service = QueServiceImpl.getInstance();

        // 읽은 질문을 가져오는 로직
        List<QueVO> queList = service.getAllQue();
        request.setAttribute("queList", queList);
        
        request.getRequestDispatcher("/WEB-INF/view/que/queDetail.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String queId = request.getParameter("que_id");
        IQueService service = QueServiceImpl.getInstance();
        
        // 선택한 질문을 삭제하는 로직 추가
        service.queDel(queId);
        
        // 삭제 후 목록 페이지로 이동
        response.sendRedirect(request.getContextPath() + "/que/QueList.do");
    }
}
