package com.woaini.servlet.dispatcher;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class DispatcherServlet  extends  HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取参数
        String  name    =   req.getParameter("name");
        String  pwd      =   req.getParameter("pwd");
        //System.out.println("账号:"+name+ ";密码:"+ pwd);

 try {
     DriverManager.registerDriver(new Driver());
     Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacc", "root", "666666");
     Statement  statement = conn.createStatement();
     ResultSet   resultSet= statement.executeQuery("select * from  user  where name ='"+name+"'" );
         while (resultSet.next()) {
	 	       String  namee = resultSet.getString("name");
  	           int  height = resultSet.getInt("height");
  	           String  sex = resultSet.getString("sex");
  	           int weight = resultSet.getInt("weight");
  	           System.out.println("年龄:"+namee+"身高:"+height+"性别:"+sex+"体重:"+weight);
  	      
  	     if (name.equals(namee)&&pwd.equals(height)) {
  	        		resp.sendRedirect("success.jsp");
  	        	
			}  
	}
    statement.close();
    resultSet.close();
    conn.close();
      
      
} catch (Exception e) {
	// TODO: handle exception
}
		
		//数据库操作
		
		//System.out.println("震震已经开始在对面野区反野  first  blood  已经诞生了");
		
		//如果用户存在的话   则可以进入到success.jsp页面
		
		//重定向daosuccess页面
//		resp.sendRedirect("success.jsp");
		
		
	}
	
}
