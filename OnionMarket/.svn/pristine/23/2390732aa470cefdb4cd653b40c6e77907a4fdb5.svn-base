package kr.or.ddit.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.apache.log4j.Logger;

import kr.or.ddit.vo.FileInfoVO;


public class FileUtil {
	
	private static final Logger logger = Logger.getLogger(FileUtil.class);
	
	
	/* 디렉토리 존재 여부 체크 */
	public static boolean isDirExist(String path) {
		File dir = new File(path);
		return dir.exists() && dir.isDirectory();
	}
	/* 디렉토리 생성 */
	public static boolean makeDir(String path) {
		File dir = new File(path);
		boolean result = true;
		if (!dir.exists()) {
			dir.setExecutable(true);
			dir.setReadable(true);
			dir.setWritable(true);
			result = dir.mkdirs();
		}
		return result;
	}
	
	/* 파일 용량 체크 */
	public static String getStringSizeLengthFile(long size) {

	    DecimalFormat df = new DecimalFormat("0.00");
	    float sizeKb = 1024.0f;
	    float sizeMb = sizeKb * sizeKb;
	    float sizeGb = sizeMb * sizeKb;
	    float sizeTerra = sizeGb * sizeKb;

	    if (size < sizeMb)
	        return df.format(size / sizeKb)+ " KB";
	    else if (size < sizeGb)
	        return df.format(size / sizeMb) + " MB";
	    else if (size < sizeTerra)
	        return df.format(size / sizeGb) + " GB";

	    return "";
	}
	
	/* 업로드 디렉토리 경로 반환 */
	public static String getFileDirRootPath(ServletContext servletContext) {
		/*
		 * # Project ROOT 경로
		 * mac (Local)		: /Users/leesm/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/WindTurbine/
		 * linux (Server) 	: /usr/local/tomcat/webapps/WindTurbine
		 */
		String realPath = servletContext.getRealPath("");
		/*
		 * # Tomcat 경로
		 * : ROOT 경로에서 상위 2단계 디렉토리 위로 이동 (==../../) 
		 */
		File f = new File(realPath);
		String path1 = "";
		if(f.getParentFile() != null && f.getParentFile().getParentFile() != null) {
			path1 = f.getParentFile().getParentFile().getAbsolutePath();
		}
		/*
		 * # 업로드 디렉토리명 
		 * /resources-dev/common.properties : base.uploadDir=Upload 
		 */
		String path2 = "upload";
		/*
		 * # 최종 파일 저장 디렉토리 경로 
		 * mac (Local)		: /Users/leesm/workspace_a2m/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/Upload
		 * linux (Server) 	: /usr/local/tomcat/Upload
		 */
		String finalPath = path1 + File.separator + path2;
		
		/* 윈도우 일 때 */
//		finalPath = "d:/uploadFiles";
		
		File folder = new File(finalPath);
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		return finalPath;
	}
	
	/* 입력 값을 받아 추가 디렉토리 경로 생성 */
	public static String joinDirPartition(List arr) {
		return File.separator + String.join(File.separator, arr);
	}
	public static String joinDirPartition(String[] arr) {
		return File.separator + String.join(File.separator, arr);
	}
	
	/* 고유 저장 파일 명 생성 */
	public static String getUniqueFileName() {
		return String.valueOf(new Date().getTime() + Math.abs(new Random().nextInt(404)));
	}
	/* 파일명과 확장자 분리 */
	public static String[] devideFileName(String filename) {
		return devideFileName(filename, true);
	}
	public static String[] devideFileName(String filename, Boolean includeDotYN) {
		int dotIndex = filename.lastIndexOf(".");
		String name = filename.substring(0, dotIndex);
		String extension = filename.substring(includeDotYN ? dotIndex : dotIndex + 1);
		return new String[]{name, extension};
	}
	
	/* 파일 업로드 */
	public static void uploadFile(Part file, String filePath, String fileName) {
		if(file != null && file.getSize() > 0) {
			
			// filePath의 경로가 존재하는지 확인 + 존재 할 경우 디렉토리 인지 여부 확인
			if (!isDirExist(filePath)) {
				makeDir(filePath);
			}
			// 파일 객체 생성
			File saveFile = new File(filePath + File.separator + fileName);
			// 파일 저장 
			try {
				file.write(filePath + File.separator + fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/* 파일 정보 => VO */
	public static FileInfoVO getFileInfo(Part file) {
		return getFileInfo(file, "");
	}
	public static FileInfoVO getFileInfo(Part file, String uniqueFileNameSeperator) {
		FileInfoVO vo = new FileInfoVO();
		uniqueFileNameSeperator = uniqueFileNameSeperator == null ? "" : uniqueFileNameSeperator;
		if(file != null && file.getSize() > 0) {
			// 오리지널 파일 이름을 이름[0]과 확장자[1]로 나누기 (. 미포함)
			String[] fileNames = FileUtil.devideFileName(file.getSubmittedFileName(), false);
			// 유니크 파일 이름 생성 
			String uniqueFileName = FileUtil.getUniqueFileName() + uniqueFileNameSeperator + "." + fileNames[1];
			
			// 유니크 파일 이름 
			vo.setStored_nm(uniqueFileName);
			// 기존 파일 이름
			vo.setUpload_nm(file.getSubmittedFileName());
			// 파일 확장자 (. 미포함) 
			vo.setExtension(fileNames[1]);
			// 파일 크기 
			vo.setFile_size(file.getSize());
			// DB 저장 시퀀스 
			vo.setFile_id(UUID.randomUUID().toString());
		}
		return vo;
	}
	
	/* 파일 삭제 */
	public static boolean deleteFile(String path, String fileName) {
		if(!path.isEmpty() && !fileName.isEmpty()) {
			// 서버 디렉토리 구분자로 변경 
			path = replaceToServerSeparator(path);
			File file = new File(path + File.separator + fileName);
			System.out.println(file.exists());
			if(file.exists()) {
				synchronized (file) {
					return file.delete();
				}
			}
			return false;
		}
		return false;
	}
	public static boolean deleteFile(String fileName, ServletContext servletContext) {
		return deleteFile(getFileDirRootPath(servletContext), fileName);
	}
	public static boolean deleteFileWithFullPath(String path, String fileName, ServletContext servletContext) {
		path = getFileDirRootPath(servletContext) + path;
		return deleteFile(path, fileName);
	}
	
	public static String replaceToServerSeparator(String path) {
		return path.replace("/", File.separator).replace("\\", File.separator);
	}
	
	public static String getNoImageFilePath(ServletContext servletContext) {
		return servletContext.getRealPath("") + File.separator + "img" + File.separator + "noimage.png";
	}
}
