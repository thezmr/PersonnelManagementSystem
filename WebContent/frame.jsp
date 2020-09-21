<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<title>人事管理系统</title>

		<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<link rel="bookmark" href="images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	    <!--[if lt IE 9]>
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="css/frameStyle.css">
		<script type="text/javascript" src="framework/frame.js" ></script>
		
	</head>

	<body>
		<!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
		    <div class="logo">
		        <img src="images/logo.png"/>
		        <div class="logoText">
		            <h1>人事管理系统</h1>
		            <p>System</p>
		        </div>
		    </div>
		    <div class="menu">
		        <ul>
					<li>
					    <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>部门管理<i class="iconfont icon-dajiantouyou right"></i></a>
					    <dl>
					    	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/department/jumpList.html',this)">部门列表</a></dt>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/department/departmentAdd.html',this)">添加部门</a></dt>
							<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/department/jumpDelete.html',this)">修改部门</a></dt>
					    </dl>
					</li>
					<li>
					    <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left"></i>岗位管理<i class="iconfont icon-dajiantouyou right"></i></a>
					    <dl>
					    	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/job/jumpList.html',this)">岗位列表</a></dt>					    	
							<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/job/jobAdd.html',this)">添加岗位</a></dt>
					    	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/job/jumpMaintain.html',this)">修改岗位</a></dt>
					    </dl>	
					</li>
					
                    <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>员工入职管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/staff/jumpInsert.jsp',this)">普通入职</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/move/jumpBaseList.html',this)">从人才库入职</a></dt>
		                </dl>
		           	</li>

		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>试用期管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/move/jumpToSearchTrailServlet.html',this)">试用期员工列表</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/move/jumpToSearchFormalServlet.html',this)">已转正员工查询</a></dt>
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>部门调动管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/move/jumpToStaffListServletForDep.html',this)">部门异动员工</a></dt>
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>岗位调动管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/move/jumpToStaffListServlet.html',this)">岗位异动员工</a></dt>
		                </dl>
		            </li>

		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>离职管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/move/jumpToDismission2.html',this)">离职列表</a></dt>
		                </dl>
		            </li>
		            		            
		            <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left"></i>员工信息中心<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('pages/staff/staffMaintain.jsp',this)">员工信息维护</a></dt>

		                </dl>
		            </li>
		            
  					<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-icon left"></i>统计报表<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('maintain.html',this)">报表导出</a></dt>
		                </dl>
		           	</li>
		        </ul>
		    </div>
		</div>
		<!-- 左侧菜单 - 结束 -->
		
		<div class="main">
			<!-- 头部栏 - 开始 -->
			<div class="frameTop">
				<img class="jt" src="images/top_jt.png"/>
				<div class="topMenu">
					<ul>
						<li><a href="javascript:void(0)" onclick="menuCAClick('maintain.html',this)"><i class="iconfont icon-yonghu1"></i>管理员</a></li>
						<li><a href="javascript:void(0)" onclick="menuCAClick('maintain.html',this)"><i class="iconfont icon-xiugaimima"></i>修改密码</a></li>
						<li><a href="thanks.html"><i class="iconfont icon-084tuichu"></i>注销</a></li>
					</ul>
				</div>
			</div>
			<!-- 头部栏 - 结束 -->
			
			<!-- 核心区域 - 开始 -->
			<div class="frameMain">
				<div class="title" id="frameMainTitle">
					<span><i class="iconfont icon-xianshiqi"></i>后台首页</span>
				</div>
				<div class="con">
					<iframe id="mainIframe" src="Welcome.html" scrolling="no"></iframe>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
	</body>

</html>