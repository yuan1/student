<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>学生信息修改</title>
<!-- Bootstrap -->
<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">学生信息修改</h3>
			</div>
			<div class="panel-body">
				<form action="UpdateStudentDoServlet" method="post">
					<div class="form-group">
						<label>学号</label> <input type="text" class="form-control"
							name="num" placeholder="请输入学号" value="${stu.num }"> <input type="hidden"
							name="id" value="${stu.id }" />
					</div>
					<div class="form-group">
						<label>姓名</label> <input type="text" class="form-control"
							name="name" placeholder="请输入姓名"  value="${stu.name }">
					</div>
					<div class="form-group">
						<label>专业</label> <input type="text" class="form-control"
							name="major" placeholder="请输入专业" value="${stu.major }">
					</div>
					<div class="form-group">
						<label>电话</label> <input type="text" class="form-control"
							name="phone" placeholder="请输入电话" value="${stu.phone }">
					</div>
					<button type="submit" class="btn btn-default">修改</button>
				</form>
			</div>
			<div class="panel-footer">
				<a href="StudentListServlet" class="btn btn-primary">查看信息列表</a>
			<a href="index.jsp" class="btn btn-primary">添加学生信息</a>
			</div>
		</div>
	</div>
</body>
</html>