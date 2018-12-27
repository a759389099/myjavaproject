<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		label : '班次',
		width : 100,
		sortable : 'default',
		name : 'id'
	}, {
		label : '登记类型',
		width : 100,
		sortable : 'default',
		name : 'name'
	}, {
		label : '规定时间',
		width : 150,
		sortable : 'default',
		name : 'dutytime'
	}, {
		label : '开始登记时间',
		width : 150
	}, {
		label : '结束登记时间',
		width : 150
	}, {
		label : '登记时间',
		minWidth : 200
	} , {
		label : '备注',
		minWidth : 200
	}];

	var oper = [ {
		label : '打卡',
		onclick : function() {
			
			$.get("${pageContext.request.contextPath}/Attend/sign.action",
					  function(data){
					    alert(data);
					    window.location.href = "${pageContext.request.contextPath}/Attend/list.action";
					  });
			
			
			
		}
	} ]
	
	

	var tbody = 
		
		 <c:if test="${empty (uavo.dutytype.dutytime3)}">
		[["${uavo.dutytype.dutyname}","上班","${uavo.dutytype.dutytime1}",
		  "08:00:00","10:00:00",

	      "<fmt:formatDate value="${uavo.attenddutyList[0].registertime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
	      "${uavo.attenddutyList[0].remark}",<c:if test="${empty uavo.attenddutyList[0].registertime}">oper</c:if>],
	      ["${uavo.dutytype.dutyname}","下班","${uavo.dutytype.dutytime2}", 
	       "17:00:00","22:30:00",
		  "<fmt:formatDate value="${uavo.attenddutyList[1].registertime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
		  "${uavo.attenddutyList[1].remark}",<c:if test="${empty uavo.attenddutyList[1].registertime}">oper</c:if>]
			]	</c:if>
        
		
		 	<c:if test="${!empty (uavo.dutytype.dutytime3)}">
			[["${uavo.dutytype.dutyname}","上班","${uavo.dutytype.dutytime1}",
			"7:00:00",
			"9:00:00", 

		      "<fmt:formatDate value="${uavo.attenddutyList[0].registertime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
		      "${uavo.attenddutyList[0].remark}",<c:if test="${empty uavo.attenddutyList[0].registertime}">oper</c:if>],
		              
		              
	      ["${uavo.dutytype.dutyname}","下班","${uavo.dutytype.dutytime2}", 
	      "11:30:00",
			"12:30:00",
		  "<fmt:formatDate value="${uavo.attenddutyList[1].registertime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
		  "${uavo.attenddutyList[1].remark}",<c:if test="${empty uavo.attenddutyList[1].registertime}">oper</c:if>]
	
	 				
  			,["${uavo.dutytype.dutyname}","上班","${uavo.dutytype.dutytime3}",
  			
  			 "17:00:00",
  			 "18:00:00",
  			  "<fmt:formatDate value="${uavo.attenddutyList[2].registertime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
	              "${uavo.attenddutyList[2].remark}",<c:if test="${empty uavo.attenddutyList[2].registertime}">oper</c:if>],
   			["${uavo.dutytype.dutyname}","下班","${uavo.dutytype.dutytime4}",
   			 "21:00:00",
  			 "23:00:00",
   			"<fmt:formatDate value="${uavo.attenddutyList[3].registertime}" pattern="yyyy-MM-dd HH:mm:ss"/>",
	              "${uavo.attenddutyList[3].remark}",<c:if test="${empty uavo.attenddutyList[3].registertime}">oper</c:if>]
   
			]
	      </c:if>
	
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
