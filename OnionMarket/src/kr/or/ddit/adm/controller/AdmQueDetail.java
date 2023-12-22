package kr.or.ddit.adm.controller;

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

@WebServlet("/adm/admQueDetail.do")
public class AdmQueDetail extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String queId = request.getParameter("que_id");
        String upId = request.getParameter("up_id");
        IQueService service = QueServiceImpl.getInstance();
        List<QueVO> queList = service.getAllQue();
        request.setAttribute("queList", queList);
        request.getRequestDispatcher("/WEB-INF/view/adm/admQueDetail.jsp").forward(request, response);
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        IQueService service = QueServiceImpl.getInstance();
        
        
        String upId = request.getParameter("up_id");
         
        // 선택한 질문을 삭제하는 로직 추가
        service.admQueDel(upId);
        
          
        
        String up_Id = request.getParameter("que_id");
        String queTit = request.getParameter("queAnsTit");
        String cont = request.getParameter("queAnsCont");
        System.out.println("up_Id: " + up_Id);
        System.out.println("queTit: " + queTit);
        System.out.println("cont: " + cont);

        String insId = "test01"; // 세션에서 가져오는 것으로 수정
        int parsedUpId = Integer.parseInt(up_Id);
        
        QueVO queVo = new QueVO();
        queVo.setTit(queTit);
        queVo.setCont(cont);
        queVo.setIns_id(insId);
        queVo.setUp_id(parsedUpId);

        service.qeuAns(queVo);
        
        response.sendRedirect(request.getContextPath() + "/adm/admQueDetail.do?adm_id="+up_Id);
    }
}
