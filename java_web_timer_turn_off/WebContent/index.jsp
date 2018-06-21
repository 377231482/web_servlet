<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="turnOff" method="post">
		关机时间：<input type="text"  name="time"> 单位/s<br>
		<input type="submit" value="自动关机">
	</form>
	
	<form action="turnOff" method="get">
		<input type="submit" value="取消关机">
	</form>
</body>
</html>