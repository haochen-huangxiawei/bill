package com.hxw.springboot.uitl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseOutUtil {

	private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

	public static PrintWriter getPrintWriter(HttpServletResponse response) {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}

	public static void alert(HttpServletResponse response, Integer result, String msg1, String msg2, String url1,
			String url2) {
		PrintWriter out = getPrintWriter(response);
		out.print("<script>");
		if (result > 0) {
			out.print("alert('" + msg1 + "');");
			out.print("location.href='" + url1 + "';");
		} else {
			out.print("alert('" + msg2 + "');");
			out.print("location.href='" + url2 + "'");
		}
		out.print("</script>");
	}

	public static void diyAlert(HttpServletResponse response, Integer result, String msg1, String msg2, String url1,
			String diyUrl) {
		PrintWriter out = getPrintWriter(response);
		out.print("<script>");
		if (result > 0) {
			out.print("alert('" + msg1 + "');");
			out.print("location.href='" + url1 + "';");
		} else {
			out.print("alert('" + msg2 + "');");
			out.print(diyUrl + ";");
		}
		out.print("</script>");
	}

	public static void saveAlert(HttpServletResponse response, Integer result, String url1, String diyUrl) {
		PrintWriter out = getPrintWriter(response);
		out.print("<script>");
		if (result > 0) {
			out.print("alert('保存成功');");
			out.print("location.href='" + url1 + "';");
		} else {
			out.print("alert('保存失败');");
			out.print(diyUrl + ";");
		}
		out.print("</script>");
	}

	/**
	 * 跳转加提示一次
	 * 
	 * @param response
	 * @param msg
	 * @param url
	 */
	public static void alert(HttpServletResponse response, String msg, String url) {
		PrintWriter out = getPrintWriter(response);
		out.print("<script>");
		out.print("alert('" + msg + "');");
		out.print("location.href='" + url + "';");
		out.print("</script>");
	}

	/**
	 * 只提示不跳转
	 * 
	 * @param response
	 * @param msg
	 */
	public static void alert(HttpServletResponse response, String msg) {
		PrintWriter out = getPrintWriter(response);
		out.print("<script>");
		out.print("alert('" + msg + "');");
		out.print("</script>");
	}

	public static void diyAlert(HttpServletResponse response, String msg, String diyUrl) {
		PrintWriter out = getPrintWriter(response);
		out.print("<script>");
		out.print("alert('" + msg + "');");
		out.print(diyUrl + ";");
		out.print("</script>");
	}

}
