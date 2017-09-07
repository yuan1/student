<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>提示信息</title>
<!-- Bootstrap -->
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">提示信息</h3>
			</div>
			<div class="panel-body">
				${info }
			</div>
			<div class="panel-footer">
				<a href="StudentListServlet" class="btn btn-primary">查看信息列表</a>
				<a href="index.jsp" class="btn btn-primary">添加学生信息</a>
			</div>
		</div>
	</div>
</body>
</html>