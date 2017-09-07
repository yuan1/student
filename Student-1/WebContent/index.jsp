<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加学生</title>
</head>
<body>
<form action="AddStudentServlet" method="post">
	学号：<input type="text" name="num"  />
	<br>
	姓名：<input type="text" name="name" />
	<br />
	专业：<input type="text" name="major" />
	<br />
	电话：<input type="text" name="phone" />
	<br />
	<input type="submit" value="添加" />
	
	<br />
	<a href="ListStudentServlet">获取学生信息列表</a>
</form>
</body>
</html>