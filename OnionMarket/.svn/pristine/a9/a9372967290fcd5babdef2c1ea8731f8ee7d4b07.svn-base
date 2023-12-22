package kr.or.ddit.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/imageView")
public class ImageViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일 저장소 디렉토리 경로
		String rootPath = FileUtil.getFileDirRootPath(request.getServletContext());
		
		// 저장 파일명
		String filename = request.getParameter("stored_nm");
		
		BufferedInputStream bin = null;
	    BufferedOutputStream bout = null;
	    try {
	    	
	    	File file = new File(rootPath + File.separator + filename);
	    	
	    	// 존재하지 않은 파일 일 경우 
	    	if (!file.exists() || !file.isFile()) {
	    		file = new File(FileUtil.getNoImageFilePath(request.getServletContext()));
	    	}
	    	 
	    	// 출력용 스트림
            bout = new BufferedOutputStream(response.getOutputStream());
            
            // 파일 입력용 스트림
            bin = new BufferedInputStream(new FileInputStream(file));
            
            byte[] temp = new byte[1024];
            int len = 0;
            
            while( (len = bin.read(temp)) > 0) {
               bout.write(temp, 0, len);
            }
            bout.flush();

	    } catch (IOException e) {
			System.out.println("입출력 오류 : " + e.getMessage());
	    } finally {
	    	if(bin!=null) try { bin.close(); }catch(IOException e) {}
	    	if(bout!=null) try { bout.close(); }catch(IOException e) {}
	    }
	}
}
