<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>


<script type="text/javascript">
$(document).ready(function(){
	$("#daka").click(function() {
		  $.ajax({
			type:"post",
			data: {"type": $(this).prev().val()},
		   dataType:"json",
		   url: "${pageContext.request.contextPath}/Attend/sign.action",
		   success: function(data) {
				alert(data);
				window.location.href = "${pageContext.request.contextPath}/Attend/list.action";
			}
		 });  
	})
});
</script>
<style type="text/css">
</style>
</head>

<body>

	<div style="border: 15px solid white">


		<div class="table-responsive">
			<table
				class="table table-condensed table-striped table-bordered table-hover">
				<tr class="success">
					<td>班次类型</td>
					<td>登记类型</td>
					<td>规定时间</td>
					<td>开始登记时间</td>
					<td>结束登记时间</td>
					<td>实际登记时间</td>
					<td>备注</td>
					<td>操作</td>

				</tr>
				<c:if test="${uavo == null}">
					<tr>
						<td>没有该用户的排班!!!</td>
					</tr>
				</c:if>

				<c:if test="${empty (uavo.dutytype.dutytime3)  && uavo != null}">
					<tr>
						<td>${uavo.dutytype.dutyname}</td>
						<td>上班</td>
						<td>${uavo.dutytype.dutytime1}</td>
						<td>08:00:00</td>
						<td>10:00:00</td>
						<td><fmt:formatDate
								value="${uavo.attenddutyList[0].registertime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${uavo.attenddutyList[0].remark}</td>
						<td><c:if
								test="${empty uavo.attenddutyList[0].registertime && fn:length(uavo.attenddutyList)==0}">
								<input type="hidden" name="type" value="1" />
								<input type="button" id="daka" value="打卡" />
							</c:if></td>
						<td></td>
					</tr>
					<tr>
						<td>${uavo.dutytype.dutyname}</td>
						<td>下班</td>
						<td>${uavo.dutytype.dutytime2}</td>
						<td>17:00:00</td>

						<td>22:30:00</td>
						<td><fmt:formatDate
								value="${uavo.attenddutyList[1].registertime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${uavo.attenddutyList[1].remark}</td>
						<td><c:if
								test="${empty uavo.attenddutyList[1].registertime && fn:length(uavo.attenddutyList)==1}">
								<input type="hidden" name="type" value="2" />
								<input type="button" id="daka" value="打卡" />
							</c:if></td>
					</tr>
				</c:if>

				<!-- 两头班 -->
				<c:if test="${!empty (uavo.dutytype.dutytime3)}">
					<tr>
						<td>${uavo.dutytype.dutyname}</td>
						<td>上班</td>
						<td>${uavo.dutytype.dutytime1}</td>
						<td>7:00:00</td>

						<td>9:00:00</td>
						<td><fmt:formatDate
								value="${uavo.attenddutyList[0].registertime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><c:if
								test="${empty uavo.attenddutyList[0].registertime && fn:length(uavo.attenddutyList)==0}">
								<input type="hidden" name="type" value="1" />
								<input type="button" id="daka" value="打卡" />
							</c:if></td>
					<tr>
						<td>${uavo.dutytype.dutyname}</td>
						<td>下班</td>
						<td>${uavo.dutytype.dutytime2}</td>
						<td>11:30:00</td>
						<td>12:30:00</td>
						<td><fmt:formatDate
								value="${uavo.attenddutyList[1].registertime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${uavo.attenddutyList[1].remark}</td>
						<td><c:if
								test="${empty uavo.attenddutyList[1].registertime && fn:length(uavo.attenddutyList)==1}">
								<input type="hidden" name="type" value="2" />
								<input type="button" id="daka" value="打卡" />
							</c:if></td>
					</tr>
					<tr>
						<td>${uavo.dutytype.dutyname}</td>
						<td>上班</td>
						<td>${uavo.dutytype.dutytime3}</td>
						<td>17:00:00</td>

						<td>18:00:00</td>
						<td><fmt:formatDate
								value="${uavo.attenddutyList[2].registertime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${uavo.attenddutyList[2].remark}</td>
						<td><c:if
								test="${empty uavo.attenddutyList[2].registertime && fn:length(uavo.attenddutyList)==2}">
								<input type="hidden" name="type" value="3" />
								<input type="button" id="daka" value="打卡" />
							</c:if></td>

					</tr>
					<tr>
						<td>${uavo.dutytype.dutyname}</td>
						<td>下班</td>
						<td>${uavo.dutytype.dutytime4}</td>
						<td>21:00:00</td>
						<td>23:00:00</td>
						<td><fmt:formatDate
								value="${uavo.attenddutyList[3].registertime}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${uavo.attenddutyList[3].remark}</td>
						<td><c:if
								test="${empty uavo.attenddutyList[3].registertime && fn:length(uavo.attenddutyList)==3}">
								<input type="hidden" name="type" value="4" />
								<input type="button" id="daka" value="打卡" />
							</c:if></td>



					</tr>
				</c:if>
			</table>

		</div>


	</div>

</body>


</html>