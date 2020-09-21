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
		<meta name="author" content="穷在闹市" />
		<!-- 作者 -->
		<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
		<!-- 定义页面的最新版本 -->
		<meta name="description" content="网站简介" />
		<!-- 网站简介 -->
		<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
		<title></title>

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
		
		<style>
			.layui-form{
				margin-right: 30%;
			}
		</style>
<script>
					layui.use('form', function() {
						var form = layui.form;
				
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
				</script>
	</head>

<body>
<div class="cBody">
<form class="layui-form" action="/PersonnelManagement/EmployeeQueryServlet" method ="post">
<div class="layui-form-item">
	<label class="layui-form-label">员工名称：</label>
	<div class="layui-input-inline shortInput">
	<input type="text" name="employeename" autocomplete="off" placeholder="输入员工姓名，空白则为搜索全部"  class="layui-input"/>
	</div>
	<i class="iconfont icon-huaban bt"></i>
	</div>
	<br/>
	<input type="submit" value="搜索"class="layui-btn" lay-submit lay-filter="submitBut" />
</form>

<table  class="layui-table" border = "1">
<thead>
	<tr>
		<th>员工编号</th><th>员工姓名</th><th>员工性别</th><th>员工电话</th><th>员工部门</th><th>员工岗位</th>		
	</tr>
	</thead>
	<c:forEach items="${requestScope.es }" var = "e">
		<tr>
			<td>${e.employeeid }</td>
			<td>${e.employeename }</td>
			<td>${e.employeesex }</td>
			<td>${e.employeetel }</td>
			<td>${e.employeedepartment.departmentname }</td>
			<td>${e.employeejob.jobname}</td>
			<td>
				<a href="/PersonnelManagement/EmployeeQueryByIdServlet?eid=${e.employeeid }">详细信息及修改</a>
			</td>
		</tr>
	</c:forEach>
	
</table>
</div>
</body>
</html>