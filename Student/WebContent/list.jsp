<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>学生信息列表</title>
<!-- Bootstrap -->
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">学生信息列表</h3>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>姓名</th>
							<th>学号</th>
							<th>专业</th>
							<th>电话</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stuList}" var="s">
							<tr>
								<td>${s.id}</td>
								<td>${s.name}</td>
								<td>${s.num}</td>
								<td>${s.major}</td>
								<td>${s.phone}</td>
								<td><a href="UpdateStudentShowServlet?id=${s.id}" class="btn btn-info">修改</a>
									<a href="DeleteStudentServlet?id=${s.id}"class="btn btn-danger">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="panel-footer">
				<a href="index.jsp" class="btn btn-primary">添加学生信息</a>
			</div>
		</div>
	</div>
</body>
</html>