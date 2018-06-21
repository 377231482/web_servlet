package com.zhiyou.timer.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurnOffServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//调用系统指令 作用同在命令提示符下输入一样
		Runtime.getRuntime().exec("shutdown -a");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//time的值为String类型 
		String time = req.getParameter("time");
		//将time转为long类型
		long s = Long.valueOf(time);
		
		//调用系统指令 作用同在命令提示符下输入一样
		Runtime.getRuntime().exec("shutdown -s -t "+s);
		
		resp.sendRedirect("index.jsp");
		//在浏览器显示设置的关机秒数
		resp.getWriter().println("电脑将在："+s+"秒后关机");
	}
	
}
