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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 //获取参数
        String  name    =   req.getParameter("username");
        String  pwd     =   req.getParameter("pwd");
        //System.out.println("账号:"+name+ ";密码:"+ pwd);

 try {
	      
	 //注册驱动
        DriverManager.registerDriver(new Driver());
        //获取数据库接口连接
        Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javacc", "root", "666666");
        //创建sql语句连接
        Statement  statement = conn.createStatement();
        ResultSet   resultSet= statement.executeQuery("select * from  user  where name ='"+name+"'" );
        //处理结果集
          while (resultSet.next()) {
		 
	 	   String  names = resultSet.getString("name"); 
  	           int  height = resultSet.getInt("height");
  	           String  sex = resultSet.getString("sex");
  	           int weight = resultSet.getInt("weight");
  	           
		 
		   //登录判断
  	           if (name.equals(names) && pwd.equals(sex)) {
  	           resp.sendRedirect("success.jsp");
  	           System.out.println("年龄:"+names+"身高:"+height+"性别:"+sex+"体重:"+weight);
  		       }else {
  			   resp.sendRedirect("error.jsp");
  		       }
  	           
	          
  	 
	       }
         //关闭资源链接
              statement.close();
              resultSet.close();
              conn.close();
               }
   catch (Exception e) {
 
               }
	       }
	      @Override
	       protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
      
	 
         }
      
                                        

	 	
	
		
		
		//如果用户存在的话   则可以进入到success.jsp页面
		
		//重定向daosuccess页面
//		resp.sendRedirect("success.jsp");
		
		
	  }
	
    
