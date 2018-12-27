<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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

				<div class="table">

					<div class="grid"></div>

					<%-- <div class="pagination2">
						<nav aria-label="Page navigation">
						<ul class="pagination">
							<li><a href="${pageContext.request.contextPath}/user/list.action?pageNum=${pageBean.pageNum-1}&department.departmentid=${queryVo.department.departmentid}" aria-label="Previous"> <span
									aria-hidden="true">上一页</span>
							</a></li>
							
							<c:forEach begin="1" end="${pageBean.totalPage}" varStatus="i">
							<li><a href="${pageContext.request.contextPath}/user/list.action?pageNum=${i.count}&department.departmentid=${queryVo.department.departmentid}">${i.count}</a></li>
							</c:forEach>
							
							
							<li><a href="${pageContext.request.contextPath}/user/list.action?pageNum=${pageBean.pageNum>=pageBean.totalPage?pageBean.pageNum:pageBean.pageNum+1}&department.departmentid=${queryVo.department.departmentid}" aria-label="Next"> 
							<span aria-hidden="true">下一页</span>
							</a></li>
						</ul>
						</nav>
					</div>
					 --%>
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
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.grid.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<script type="text/javascript">
	$('select').select();
	var head = [ {
		label : '姓名',
		width : 150,
		sortable : 'default',
		name : 'name'
	}, {
		label : '日期',
		width : 200,
		sortable : 'default',
		name : 'date'
	}, {
		label : '班次',
		width : 150
	}, {
		label : '上班时间',
		width : 150
	}, {
		label : '下班时间',
		Width : 150
	}, {
		label : '上班时间',
		width : 150
	}, {
		label : '下班时间',
		width : 150
	} ];

	/* var oper = [{
		label:'打卡',onclick:function(){
			alert('上班打卡');
		}
	},{
		label:'打卡',onclick: function(){
			alert('下班打卡')	
		}
	}] */

	var tbody = [
			<c:forEach items="${config}" var="acv">["${user.nickname}",
					"${acv.date}", "${acv.dutyname}", "${acv.dutytime1}","${acv.dutytime2}",
					 <c:if test="${acv.dutytype==2}"> "${acv.dutytime3}", "${acv.dutytime4}"</c:if> <c:if test="${acv.dutytype==1}">"", ""</c:if> 	], </c:forEach> ]

	
	
	
	$('.grid').Grid({
		thead : head,
		tbody : null,
		height : 400,
		checkbox : {
			single : true
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
