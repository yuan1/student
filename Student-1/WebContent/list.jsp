<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息列表</title>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>学号</th>
			<th>专业</th>
			<th>电话</th>
			<th>操作</th>
		</tr>

		<c:forEach items="${stuList}" var="stu">
		<tr>
			<th>${stu.id }</th>
			<th>${stu.name }</th>
			<th>${stu.num }</th>
			<th>${stu.major }</th>
			<th>${stu.phone }</th>
			<th>
				<a href="UpdateStudent?id=${stu.id }">修改</a>
				<a href="DeleteStudent?id=${stu.id }">删除</a>
			</th>
		</tr>
		</c:forEach>
	</table>


</body>
</html>