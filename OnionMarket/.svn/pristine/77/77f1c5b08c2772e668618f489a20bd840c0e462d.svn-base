package kr.or.ddit.not.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.not.service.INotService;
import kr.or.ddit.not.service.NotServiceImpl;
import kr.or.ddit.vo.NotVO;

@WebServlet("/not/NotImg.do")
public class NotImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String notNum = request.getParameter("notNum");

		INotService service = NotServiceImpl.getInstance();
		NotVO notVo = service.getNotNum(notNum);
		
		String file_id = notVo.getFile_id();
		
		if (file_id == null || file_id.isEmpty()) {
		    file_id = "noImage.png";
		}
		// 이미지가 저장된 폴더 설정
		String filepath = "d:/uploadFiles";
		File file = new File(filepath, file_id);
		
		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		if (file.exists()) { // 이미지 파일이 있을 때...
			try {
				// 출력용 스트림
				bout = new BufferedOutputStream(response.getOutputStream());

				// 파일 입력용 스트림
				bin = new BufferedInputStream(new FileInputStream(file));

				byte[] temp = new byte[1024];
				int len = 0;

				while ((len = bin.read(temp)) > 0) {
					bout.write(temp, 0, len);
				}
				bout.flush();

			} catch (Exception e) {
				System.out.println("입출력 오류 : " + e.getMessage());
			} finally {
				if(bin!=null) try { bin.close(); }catch(IOException e) {}
				if(bout!=null) try { bout.close(); }catch(IOException e) {}
			}
		}

 	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
