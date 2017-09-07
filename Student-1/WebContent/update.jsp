<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生信息</title>
</head>
<body>
<form action="UpdateStudentDo" method="post">
	<input type="hidden" name="id" value="${student.id }" />
	学号：<input type="text" name="num"  value="${student.num }"/>
	<br>
	姓名：<input type="text" name="name" value="${student.name }" />
	<br />
	专业：<input type="text" name="major" value="${student.major }" />
	<br />
	电话：<input type="text" name="phone" value="${student.phone }"/>
	<br />
	<input type="submit" value="修改" />
	
	<br />
	<a href="ListStudentServlet">获取学生信息列表</a>
</form>
</body>
</html>