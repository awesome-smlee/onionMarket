package kr.or.ddit.example.controller.rest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.example.service.FileServiceImpl;
import kr.or.ddit.util.ResponseUtil;
import kr.or.ddit.vo.FileInfoVO;

@WebServlet("/fileList")
@MultipartConfig
public class FileList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		FileServiceImpl service = FileServiceImpl.getInstance();
		List<FileInfoVO> vo = service.getFileList(null);
		ResponseUtil.jsonOut(response, vo);
	}
}
