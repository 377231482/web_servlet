package com.zhiyou.timer.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TurnOffServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//����ϵͳָ�� ����ͬ��������ʾ��������һ��
		Runtime.getRuntime().exec("shutdown -a");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		
		//time��ֵΪString���� 
		String time = req.getParameter("time");
		//��timeתΪlong����
		long s = Long.valueOf(time);
		
		//����ϵͳָ�� ����ͬ��������ʾ��������һ��
		Runtime.getRuntime().exec("shutdown -s -t "+s);
		
		resp.sendRedirect("index.jsp");
		//���������ʾ���õĹػ�����
		resp.getWriter().println("���Խ��ڣ�"+s+"���ػ�");
	}
	
}
