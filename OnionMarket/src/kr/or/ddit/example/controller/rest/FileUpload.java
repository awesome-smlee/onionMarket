package kr.or.ddit.example.controller.rest;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.example.service.FileServiceImpl;
import kr.or.ddit.util.FileUtil;
import kr.or.ddit.vo.FileInfoVO;

@WebServlet("/fileUpload")
@MultipartConfig
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		FileServiceImpl service = FileServiceImpl.getInstance();
		int cnt = service.insertFile(request);
		
		response.sendRedirect("/fileImageView");
	}
}
