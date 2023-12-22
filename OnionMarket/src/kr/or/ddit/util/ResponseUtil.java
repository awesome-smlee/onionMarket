package kr.or.ddit.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class ResponseUtil {
	
	private static Gson gson = new Gson();
	
	public static void jsonOut(HttpServletResponse res, Object data) throws IOException {
		res.setCharacterEncoding("utf-8");
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(gson.toJson(data));
		out.flush();
		res.flushBuffer();
	}
	
	public static String viewOut(String jspPath, HttpServletRequest request) {
		return "/WEB-INF/view" + jspPath + ".jsp";
	}
}
