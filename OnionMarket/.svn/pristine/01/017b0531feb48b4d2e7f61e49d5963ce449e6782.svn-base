package kr.or.ddit.adm.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import kr.or.ddit.adm.service.INoticeService;
import kr.or.ddit.adm.service.NoticeServiceImpl;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.UsersVO;


@WebServlet("/adm/admNoticeInsert.do")
@MultipartConfig	
public class admNoticeInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/adm/admNoticeInsert.jsp")
		.forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uploadPath = "d:/d_other/uploadFiles";
		HttpSession session = request.getSession();
		UsersVO vo = (UsersVO)session.getAttribute("loginUser");
		
		
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdirs();
		
		
	}
		request.setCharacterEncoding("utf-8");
		
//		String notiIns_id = request.getParameter("nottiIns_id");
		//String notiIns_id = "test";
		
		
		
		String notiTit = request.getParameter("tit");
		String notiCont = request.getParameter("cont");
		//int notiId = request.getParameter("noti_id");
		
		NoticeVO notiVo = new NoticeVO();
		notiVo.setIns_id (vo. getUser_id());
		notiVo.setTit(notiTit);
		notiVo.setCont(notiCont);
		//notiVo.setNoti_id(notiId);
	
		
		Part part = request.getPart("photo");
		
		if(part!=null) {
			String fileName = extractFilename(part);
			
			if(!"".equals(fileName)) {
				try {
					part.write(uploadPath+ File.separator + fileName);
				
					notiVo.setphoto(fileName);
				} catch (Exception e) {
					notiVo.setphoto(null);
				}
			}
			
		}
		
		INoticeService service = NoticeServiceImpl.getInstance();
		service.insertNotice(notiVo);
		
		response.sendRedirect(request.getContextPath()+"/adm/admNotice.do");
	}
	
	private String extractFilename(Part part) {
		String fileName="";
		
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items) {
			if(item.trim().startsWith("filename")) {  		
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		return fileName;
	}
	
}