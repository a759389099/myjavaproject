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
	<div style="border:15px solid  white" >
		<div class="table-responsive">
			<table
				class="table table-condensed table-striped table-bordered table-hover">
				<tr class="success">
					<td>流程编号</td>
					<td>分类</td>
					<td>当前办理人</td>
					<td>状态</td>
					<td>操作</td>

				</tr>
				<c:forEach items="${pageBean.list}" var="affairchainvo">
					<tr class="active">
						<td>${affairchainvo.affairchainid}</td>
						<td>${affairchainvo.affairid.affairmodelname}</td>
						<td>${user.nickname}</td>
						<td><c:if test="${affairchainvo.affairchainstate == 1}">办理中</c:if>
							<c:if test="${affairchainvo.affairchainstate == 2}">批准</c:if>
							<c:if test="${affairchainvo.affairchainstate == 3}">驳回</c:if>
						</td>
						<td><a
							href="${pageContext.request.contextPath}/Affair/doList.action?affairchainid=${affairchainvo.affairchainid}">审核</a></td>
					</tr>
				</c:forEach>
			</table>

		</div>

		<div class="pagination2">
				<ul class="pagination">
					<li><a
						href="${pageContext.request.contextPath}/Affair/needDoList.action?pageNum=${pageBean.pageNum-1}"
						aria-label="Previous"> 上一页
					</a></li>

					<c:forEach begin="1" end="${pageBean.totalPage}" varStatus="i">
						<li><a
							href="${pageContext.request.contextPath}/Affair/needDoList.action?pageNum=${i.count}">${i.count}</a></li>
					</c:forEach>


					<li><a
						href="${pageContext.request.contextPath}/Affair/needDoList.action?pageNum=${pageBean.pageNum>=pageBean.totalPage?pageBean.pageNum:pageBean.pageNum+1}"
						aria-label="Next"> 下一页
					</a></li>
				</ul>
		</div>
	</div>
</body>

</html>