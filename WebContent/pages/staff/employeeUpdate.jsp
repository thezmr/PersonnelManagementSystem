<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
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

	
	<form action="/PersonnelManagement/EmployeeUpdateServlet" method="post"
		name="form1">
			<div class="layui-form-item">
			<label class="layui-form-label">员工编号：</label>
			<div class="layui-input-inline shortInput">
			<input name="employeeid" id="employeeid" value="${requestScope.employee.employeeid }" readonly   class="layui-input"/>
			</div>
				</div>
	
		<div class="layui-form-item">
			<label class="layui-form-label">员工名称：</label>
			<div class="layui-input-inline shortInput">
			<input name="employeename" id="employeename" value="${requestScope.employee.employeename }" class="layui-input" />
			</div>
				</div>
	
			
		<div class="layui-form-item">
		<label class="layui-form-label">员工性别：</label>
		<div class="layui-input-inline shortInput">
		<input type="text" name="employeesex" value="${requestScope.employee.employeesex }"   class="layui-input"/>
		</div>
		</div>

		
		<div class="layui-form-item">
		<label class="layui-form-label">员工生日：</label>
		<div class="layui-input-inline shortInput">
		<input  name="employeebirthday" value="${requestScope.employee.employeebirthday}" class="layui-input" />
		</div>
		</div> 

		<div class="layui-form-item">
		<label class="layui-form-label">员工部门：</label>
		<div class="layui-input-inline">
		<select name="department" id="id1" >
				
				<c:forEach items="${requestScope.departmentname}" var="ed" >
					<c:if test="${ed.departmentid == requestScope.employee.employeedepartment.departmentid}">
						<option value="${ed.departmentid }" selected>${ed.departmentname }</option>
					</c:if>
					<c:if test="${ed.departmentid != requestScope.employee.employeedepartment.departmentid}">
						<option value="${ed.departmentid }" >${ed.departmentname }</option>
					</c:if>
					
				</c:forEach>
		</select> 
		</div>
		</div> 
	<div class="layui-form-item">
		<label class="layui-form-label">员工岗位：</label>
		<div class="layui-input-inline">
		<select name="job" id="id2">
				
				<c:forEach items="${requestScope.jobname}" var="ej" >
					<c:if test="${ej.jobid == requestScope.employee.employeejob.jobid}">
						<option value="${ej.jobid }" selected>${ej.jobname }</option>
					</c:if>
					<c:if test="${ej.jobid != requestScope.employee.employeejob.jobid}">
						<option value="${ej.jobid }" >${ej.jobname }</option>
					</c:if>
					
				</c:forEach>
		</select> 
		</div>
		</div>
		入职日期：<input  name="employeedate" value="${requestScope.employee.employeedate}"/> <br />
		参加工作日期：<input  name="enployeejsdate" value="${requestScope.employee.enployeejsdate}"/> <br />  
		用工形式：<input name="employeeinformation" value="${requestScope.employee.employeeinformation}"/> <br /> 
		人员来源：<input name="employeesource" value="${requestScope.employee.employeesource}"/> <br /> 
		联系方式：<input name="employeetel" value="${requestScope.employee.employeetel}"/> <br /> 
		电子邮件：<input name="employeemali" value="${requestScope.employee.employeemali}"/> <br /> 
		最高学历：<input name="employeeeducation" value="${requestScope.employee.employeeeducation}"/> <br /> 
		工作经历：<input name="employeeexperience" value="${requestScope.employee.employeeexperience}"/> <br /> 
		该经历起始年月：<input  name="employeeesdate" value="${requestScope.employee.employeeesdate}"/> <br />
		该经历截止年月：<input  name="employeeeedate" value="${requestScope.employee.employeeeedate}"/> <br />
		外国语种：<input name="employeeflanguage" value="${requestScope.employee.employeeflanguage}"/> <br /> 
		员工亲属姓名：<input name="employeefname" value="${requestScope.employee.employeefname}"/> <br /> 
		员工亲属关系：<input name="employeefrelation" value="${requestScope.employee.employeefrelation}"/> <br /> 
		是否离职：<input name="employeedismission" value="${requestScope.employee.employeedismission}"/> <br /> 
		身份证号：<input name="employeeidnum" value="${requestScope.employee.employeeidnum}"/> <br /> 
		
		<input class="layui-btn" lay-submit lay-filter="submitBut" type="submit" value="更新" />

</form>

</body>
</html>