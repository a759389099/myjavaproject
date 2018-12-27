<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/zTreeStyle/zTreeStyle.css"
	type="text/css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/css/skin_/nav.css" />
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/global.js"></script>
	<title>底部内容页</title>
</head>

<body>
	<div id="container">
		<div id="bd">
			<div class="sidebar">
				<div class="sidebar-bg"></div>
				<i class="sidebar-hide"></i>
				<h2>
					<a href="javascript:;"><i class="h2-icon" title="切换到树型结构"></i><span>安全管理</span></a>
				</h2>
				
				<ul class="nav">
					<li class="nav-li current"><a href="javascript:;"
						class="ue-clear"><i class="nav-ivon"></i><span
							class="nav-text">首页</span></a>
						<ul class="subnav">
							<li class="subnav-li current" href="index.html" data-id="1"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">首页</span></a></li>
						</ul></li>
						<c:set var="listcount" value="2"></c:set>
					<c:forEach items="${list}" var="menu" varStatus="i">
						<c:if test="${empty (menu.pid) }">
							<li class="nav-li"><a href="javascript:;" class="ue-clear"><i
									class="nav-ivon"></i><span class="nav-text">${menu.menuname}</span></a>
								<ul class="subnav last-nav-li">
									<c:forEach items="${menu.childList}" var="childMenu" varStatus="j"
										>
										<li href="${pageContext.request.contextPath }/${childMenu.menuurl}/list.action"
											class="subnav-li "
											data-id="${listcount }"><a href="${pageContext.request.contextPath }/${childMenu.menuurl}/list.action"
											class="ue-clear"><i class="subnav-icon"></i><span
												class="subnav-text">${childMenu.menuname }</span></a></li>
									<c:set var="listcount" value="${listcount+1}" />
									
									</c:forEach>
								</ul></li>
						</c:if>
					</c:forEach>
					<li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">组织结构</span></a>
                    <ul id="subnav" class="subnav">
                    	
                    </ul>
                	</li>
                	<li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">考勤管理</span></a>
                    <ul id="subnav" class="subnav">
							<li class="subnav-li current" href="${pageContext.request.contextPath}/Attend/list.action" data-id="70"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">个人考勤</span></a></li>
									<li class="subnav-li current" href="${pageContext.request.contextPath}/Attend/myAttend.action" data-id="71"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">我的排班表</span></a></li>
									<li class="subnav-li current" href="${pageContext.request.contextPath}/Attend/count.action" data-id="72"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">考勤统计</span></a></li>
                    </ul>
                	</li>
                	<!-- 加个流程办理 -->
                	<li class="nav-li last-nav-li">
                	<a href="javascript:;" class="ue-clear"><i class="nav-ivon"></i><span class="nav-text">流程办理</span></a>
                    <ul id="subnav" class="subnav">
							<li class="subnav-li current" href="${pageContext.request.contextPath}/Affair/list.action" data-id="73"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">流程发起</span></a></li>
									<li class="subnav-li current" href="${pageContext.request.contextPath}/Affair/needDoList.action" data-id="74"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">待办流程</span></a></li>
									<li class="subnav-li current" href="${pageContext.request.contextPath}/Affair/doneList.action" data-id="75"><a
								href="javascript:;" class="ue-clear"><i class="subnav-icon"></i><span
									class="subnav-text">已办事项</span></a></li>
                    </ul>
                	</li>
					
					
				</ul>
			

				<div class="tree-list outwindow">
					<div class="tree ztree"></div>
				</div>
			</div>
			<div class="main">
				<div class="title">
					<i class="sidebar-show"></i>
					<ul class="tab ue-clear">

					</ul>
					<i class="tab-more"></i> <i class="tab-close"></i>
				</div>
				<div class="content"></div>
			</div>
		</div>
	</div>

	<div class="more-bab-list">
		<ul></ul>
		<div class="opt-panel-ml"></div>
		<div class="opt-panel-mr"></div>
		<div class="opt-panel-bc"></div>
		<div class="opt-panel-br"></div>
		<div class="opt-panel-bl"></div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/nav.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/Menu.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript">
	//加载此页面后，去请求拿到数据库中所有部门的名字数据
	$(function() {
		$
				.get(

						"/oa_maven_ssm/depttable/getDepartment.action",
						function(data) {
							$
									.each(
											data,
											function(i, n) {
												var str = "<li class=\"subnav-li\"  href=\"${pageContext.request.contextPath}/depttable/list.action?department.departmentid="
														+ n['departmentid']
														+ "\"  data-id=\""
														+ (100 + i)
														+ "\"><a  class=\"ue-clear\"><i class=\"subnav-icon\"></i><span class=\"subnav-text\">"
														+ n['departmentname']
														+ "</span></a></li>"
												$("#subnav").append(str);
											})
						}, "json");
	});

	var menu = new Menu({
		defaultSelect : $('.nav').find('li[data-id="1"]')
	});

	// 左侧树结构加载
	var setting = {};

	var zNodes = [ {
		name : "新闻管理",
		children : [ {
			name : "新闻视频管理",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "新闻频道管理",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "地方新闻管理",
			icon : 'img/skin_/leftlist.png'
		} ]
	}, {
		name : "用户信息设置",
		open : true,
		children : [ {
			name : "首页",
			checked : true,
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "表单",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "表格",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "自定义设置",
			icon : 'img/skin_/leftlist.png'
		} ]
	}, {
		name : "工作安排",
		children : [ {
			name : "工作安排",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "安排管理",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "类型选择",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "自定义设置",
			icon : 'img/skin_/leftlist.png'
		} ]
	}, {
		name : "组织结构",
		children : [ {
			name : "工作安排",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "安排管理",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "类型选择",
			icon : 'img/skin_/leftlist.png'
		}, {
			name : "自定义设置",
			icon : 'img/skin_/leftlist.png'
		} ]
	} ];

	$.fn.zTree.init($(".tree"), setting, zNodes);

	$('.sidebar h2').click(function(e) {
		$('.tree-list').toggleClass('outwindow');
		$('.nav').toggleClass('outwindow');
	});

	$(document).click(function(e) {
		if (!$(e.target).is('.tab-more')) {
			$('.tab-more').removeClass('active');
			$('.more-bab-list').hide();
		}
	});
</script>
</html>
