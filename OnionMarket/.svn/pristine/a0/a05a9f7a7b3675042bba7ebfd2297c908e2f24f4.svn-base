package kr.or.ddit.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonWrite {
	private static Gson gson = new Gson();
	
	public static void out(HttpServletResponse res, Object obj) throws IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		out.print(gson.toJson(obj));
		out.flush();
		res.flushBuffer();
	}
	
}
