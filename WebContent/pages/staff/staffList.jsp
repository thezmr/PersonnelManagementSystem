<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core_1_1" prefix="c" %>
<!DOCTYPE html>
<html>
		<head>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" +request.getServerName() + ":" +
		request.getServerPort() + path;
	%>
	
	
	<base href="<%=basePath%>">
	
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">		
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title>人事管理系统</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/base.css">
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/iconfont.css">
		<script type="text/javascript" src="<%=basePath%>/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/layui/css/layui.css">
		<script type="text/javascript" src="<%=basePath%>/layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/jquery.mCustomScrollbar.css">
		<script src="<%=basePath%>/framework/jquery-ui-1.10.4.min.js"></script>
		<script src="<%=basePath%>/framework/jquery.mousewheel.min.js"></script>
		<script src="<%=basePath%>/framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="<%=basePath%>/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

	</head>
<body>
				<form class="layui-form" action="/PersonnelManagementSystem/EmployeeQueryServlet">
					<div class="layui-form-item">
						<button class="layui-btn" >搜索全部</button>
					</div>
				</form>

				<form class="layui-form" action="/PersonnelManagementSystem/EmployeeQueryServlet">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="employeename" required lay-verify="required" placeholder="输入员工姓名" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn" >搜索</button>
					</div>
				</form>
			<table class="layui-table">
				<thead>
					<tr>
						<th>员工号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>部门</th>
						<th>岗位</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.es }" var = "s">
						<tr>
							<td>${s.employeeid }</td>
							<td>${s.employeename }</td>
							<td>${s.employeesex }</td>
							<td>${s.employeedepartment.departmentname }</td>
							<td>${s.employeejob.jobname }</td>
							
						</tr>
					</c:forEach>

				</tbody>
			</table>

</body>
</html>