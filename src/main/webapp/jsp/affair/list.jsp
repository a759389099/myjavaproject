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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/WdatePicker.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/skin_/table.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/jquery.grid.css" />

<title>表格</title>
</head>

<body>
	<div id="container">
		<div id="hd"></div>
		<div id="bd">
			<div id="main">

					<div class="grid"></div>

					<div class="pagination2">
						<ul class="pagination">
							<li><a href="${pageContext.request.contextPath}/Affair/list.action?pageNum=${pageBean.pageNum-1}" aria-label="Previous"> 上一页
							</a></li>
							
							<c:forEach begin="1" end="${pageBean.totalPage}" varStatus="i">
								<li><a href="${pageContext.request.contextPath}/Affair/list.action?pageNum=${i.count}">${i.count}</a></li>
							</c:forEach>
							
							
							<li><a href="${pageContext.request.contextPath}/Affair/list.action?pageNum=${pageBean.pageNum>=pageBean.totalPage?pageBean.pageNum:pageBean.pageNum+1}" aria-label="Next"> 
							下一页
							</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/global.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/core.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.pagination.js"></script>
 --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.grid.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<script type="text/javascript">
	


	$('select').select();
	var head = [ {
		label : 'ID',
		width : 100,
		sortable : 'default',
		name : 'id'
	}, {
		label : '公文模版名',
		width : 250,
		sortable : 'default',
		name : 'name'
	}, {
		label : '设计模版者',
		width : 200
	}, {
		label : '审批人（流程）',
		width : 300
	} ];

	var oper = [ {
		label : '删除',
		onclick : function() {
			alert('删除');
		}
	}, {
		label : '编辑',
		onclick : function() {
			alert('编辑')
		}
	} ]
	var tbody = [
			<c:forEach items="${pageBean.list}" var="affairmodelvo"  >

			[
					"${affairmodelvo.affairmodelid}",
					"<a href='${pageContext.request.contextPath}/Affair/toEdit.action?affairmodelid=${affairmodelvo.affairmodelid}'>${affairmodelvo.affairmodelname}</a>--(点击填写)",
					"${affairmodelvo.userid.nickname}",
					"${affairmodelvo.affairchain}",
					 oper], </c:forEach> ]

	$('.grid').Grid({
		thead : head,
		tbody : null,
		height : 400,
		checkbox : {
			single : true
		},
		operator : {
			type : "normal",
			width : 100
		},
		sortCallBack : function(name, index, type) {
			alert(name + "," + index + ',' + type);
		}

	});

	$('.grid').Grid('addLoading');

	/// 模拟异步
	setTimeout(function() {
		$('.grid').Grid('setData', tbody, head);
	}, 500)

	$('.pagination').pagination(100, {
		callback : function(page) {
			alert(page);
		},
		display_msg : false
	});

	$('.search-box input[type=radio]').click(function(e) {
		if ($(this).prop('checked')) {
			if ($(this).attr('data-define') === 'define') {
				$('.define-input').show();
			} else {
				$('.define-input').hide();
			}
		}
	});
</script>
</html>
