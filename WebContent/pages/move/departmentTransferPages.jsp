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
		<script>
				function toUrl(url){			
			location.href = url;				
		}
	</script>

	</head>

<body>
		<div class="cBody">
			<div class="layui-tab" lay-filter="myPage">
				<ul class="layui-tab-title">
					<li class="layui-this" lay-id="historyList">需求调动列表</li>
					<li lay-id="todayList">已完成调动列表</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<table class="layui-table">
							<thead>
								<tr>
									<th>员工号</th>
									<th>姓名</th>
									<th>性别</th>									
									<th>岗位名称</th>
									<th>现部门名称</th>
									<th>需求调动部门名称</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
							
					<c:forEach items="${requestScope.st }" var = "s">
					<form action="/PersonnelManagementSystem/DepTransServlet">
						<tr>
							<td>
								<input type="text" name="sid" readonly value="${s.s_id }" required 
								autocomplete="off" class="layui-input">
							</td>
							<td>${s.s_name }</td>
							<td>${s.s_sex }</td>
							<td>${s.s_jobId.j_name }</td>
							<td>
								<input type="text" name="prename" readonly value="${s.s_departmentId.d_name }" required 
								autocomplete="off" class="layui-input">
							</td>
							<td>
								<input type="text" name="name" id="name" required autocomplete="off" class="layui-input" ">
							</td>
							<td>
								<button type="submit" class="layui-btn">部门调动</button>
							</td>
							
						</tr>
					</form>
					</c:forEach>
								
							</tbody>
						</table>
						
						<!-- layUI 分页模块 -->
						<div id="pages1"></div>
						<script>
							layui.use(['laypage', 'layer'], function() {
								var laypage = layui.laypage,
									layer = layui.layer;

								//总页数大于页码总数
								laypage.render({
									elem: 'pages1',
									count: 30,
									layout: ['prev', 'page', 'next', 'limit', 'skip'],
									jump: function(obj) {
										console.log(obj)
									}
								});
							});
						</script>
						</div>
						

					<div class="layui-tab-item">
						<table class="layui-table">
							<thead>
								<tr>
									<th>员工号</th>
									<th>姓名</th>
									<th>原部门名称</th>
									<th>现部门名称</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.dt }" var = "d">
						<tr>
							<td>${d.dt_staffID.s_id }</td>
							<td>${d.dt_staffID.s_name }</td>
							<td>${d.dt_preDepartment.d_name }</td>	
							<td>${d.dt_department.d_name }</td>

					</tr>
				</c:forEach>
								
							</tbody>
						</table>
						
				  <form class="layui-form" action="">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="depname" required lay-verify="required" placeholder="输入员工姓名" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn" >搜索</button>
					</div>
				  </form>	

						<!-- layUI 分页模块 -->
						<div id="pages2"></div>
						<script>
							layui.use(['laypage', 'layer'], function() {
								var laypage = layui.laypage,
									layer = layui.layer;

								//总页数大于页码总数
								laypage.render({
									elem: 'pages2',
									count: 100,
									layout: ['prev', 'page', 'next', 'limit', 'skip'],
									jump: function(obj) {
										console.log(obj)
									}
								});
							});
						</script>
					</div>
				</div>
			</div>
			<script>
				layui.use('element', function() {
					var element = layui.element;

					//获取hash来切换选项卡，假设当前地址的hash为lay-id对应的值
					var layid = location.hash.replace(/^#test1=/, '');
					element.tabChange('myPage', layid); //假设当前地址为：http://a.com#test1=222，那么选项卡会自动切换到“发送消息”这一项

					//监听Tab切换，以改变地址hash值
					element.on('tab(myPage)', function() {
						location.hash = 'test1=' + this.getAttribute('lay-id');
						console.log(this.getAttribute('lay-id'));
					});
				});
			</script>
		</div>
	</body>
</html>