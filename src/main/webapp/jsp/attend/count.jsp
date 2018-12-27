<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">



<%-- <link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/WdatePicker.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/skin_/form.css" />
<link
	href="${pageContext.request.contextPath}/umeditor/themes/default/_css/umeditor.css"
	type="text/css" rel="stylesheet"> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<style type="text/css">
</style>
</head>

<body>







	<div style="border: 15px solid white">
		<form method="post"
			action="${pageContext.request.contextPath}/Attend/count.action">
			<div class="kv-item ue-clear time">
				<label style="width: 100px">${Affairmodelitem.modelitemname}</label>
				<div class="kv-item-content">
					<input  value="${date}"
						name="date" type="text" readonly="readonly"
						onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /> <i
						class="time-icon"></i><input type="submit" />
				</div>
				
			</div>

		</form>

		<div class="table-responsive">
			<table
				class="table table-condensed table-striped table-bordered table-hover">
				<tr class="success">
					<td>员工姓名</td>
					<td>应出勤天数(天)</td>
					<td>实际出勤天数(天)</td>
					<td>旷工(天)</td>
					<td>迟到(次)</td>
					<td>早退(次)</td>
					<td>上班未登记(次)</td>
					<td>下班未登记(次)</td>

				</tr>
				<c:forEach items="${list}" var="attendcount">
					<tr class="active">
						<td>${attendcount.nickname}</td>
						<td>${attendcount.daycount}</td>
						<td>${attendcount.attendday}</td>
						<td>${attendcount.nevercount}</td>
						<td>${attendcount.latecount}</td>
						<td>${attendcount.earlycount}</td>
						<td>${attendcount.comesign}</td>
						<td>${attendcount.backsign}</td>
					</tr>
				</c:forEach>
			</table>

		</div>


	</div>
</body>

</html>