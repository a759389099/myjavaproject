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
	href="${pageContext.request.contextPath}/css/skin_/form.css" />
<link
	href="${pageContext.request.contextPath}/umeditor/themes/default/_css/umeditor.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.select.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<title>基础信息</title>
</head>

<body>


	<div id="container">
		<div id="hd"></div>
		<div id="bd">
			<div id="main">
				<!-- 这里拼接你点进来的是什么申请表 -->
				<h2 class="subfild" ><!-- style="width:120px" -->
					<span style="width:100px">${affairmodel.affairmodelname}</span>
				</h2>

				<!-- 这里开始拼接表单 -->
				<div class="subfild-content base-info">

					<c:forEach items="${list}" var="Affairmodelitem">

						<!-- 拼接type为1-text类型 -->
						<c:if test="${Affairmodelitem.modelitemtype == 1}">
							<div class="kv-item ue-clear">
								<label style="width:100px">${Affairmodelitem.modelitemname}</label>
								<div class="kv-item-content">
									<input id="${Affairmodelitem.modelitemid}" name="${Affairmodelitem.modelitemname}" type="text" />
								</div>
							</div>
						</c:if>

						<!-- 拼接type为2-textArea类型 -->
						<c:if test="${Affairmodelitem.modelitemtype == 2}">
							<div class="subfild-content remarkes-info">
								<div class="kv-item ue-clear">
									<label style="width:100px"><span class="impInfo">*</span>${Affairmodelitem.modelitemname}</label>
									<div class="kv-item-content">
										<textarea id="${Affairmodelitem.modelitemid}" name="${Affairmodelitem.modelitemname}" placeholder="${Affairmodelitem.modelitemname}"
											 style="width: 800px; height: 240px;"></textarea>
									</div>
								</div>
							</div>
						</c:if>

						<!-- 拼接type为3-file类型 -->
						<c:if test="${Affairmodelitem.modelitemtype == 3}">
							<div class="kv-item ue-clear">
								<label style="width:100px">${Affairmodelitem.modelitemname}</label>
								<div class="kv-item-content file">
									<span class="text"></span> <input id="${Affairmodelitem.modelitemid}" name="${Affairmodelitem.modelitemname}" type="file" /> <input
										type="button" class="button normal long2" value="浏览.." />
								</div>
							</div>
						</c:if>

						<!-- 拼接type为5-date类型 -->
						<c:if test="${Affairmodelitem.modelitemtype == 5}">
							<div class="kv-item ue-clear time">
								<label style="width:100px">${Affairmodelitem.modelitemname}</label>
								<div class="kv-item-content">
									<input id="${Affairmodelitem.modelitemid}" name="${Affairmodelitem.modelitemname}" type="text"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" /> <i
										class="time-icon"></i>
								</div>
							</div>
						</c:if>

						<!-- 拼接type为7-radio类型 -->
						<c:if test="${Affairmodelitem.modelitemtype == 7}">
							<div class="kv-item ue-clear">
								<label style="width:100px">${Affairmodelitem.modelitemname}</label>
								<div class="kv-item-content">
									<c:forEach items="${Affairmodelitem.modelitemoption}"
										var="option">
										<span class="choose"> <span class="checkboxouter" >
										<input id="${Affairmodelitem.modelitemid}" name="${Affairmodelitem.modelitemname}" type="radio" name="need" value="${option}" /> <span class="radio"></span>
										</span> <span class="text">${option}</span>
										</span>
									</c:forEach>
									<!-- <span class="choose"> <span class="checkboxouter">
											<input type="radio" name="need" /> <span class="radio"></span>
									</span> <span class="text">否</span>
									</span> -->
								</div>
							</div>
						</c:if>

						<!-- 拼接type为8-select类型 -->
						<c:if test="${Affairmodelitem.modelitemtype == 8}">
							<div class="kv-item ue-clear">
								<label style="width:100px">${Affairmodelitem.modelitemname}</label>
								<div class="kv-item-content">
									<select id="${Affairmodelitem.modelitemid}" name="${Affairmodelitem.modelitemname}">
										<c:forEach items="${Affairmodelitem.modelitemoption}"
											var="option">
											<option value="${option}">${option}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</c:if>

					</c:forEach>

				</div>

				<div class="buttons">
					<input class="button" type="button" value="提交申请" />
				</div>
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">

	$(function(){
		$(".button").click(function(){
			//拿到表单信息，拼接成需要的样子
		var str = "<table class=\"table table-responsive table-bordered\">";

		<c:forEach items="${list}" var="Affairmodelitem">
			var idstr = ${Affairmodelitem.modelitemid};
			var valueStr = document.getElementById(idstr);
			var type =  ${Affairmodelitem.modelitemtype};
			var $element = $(valueStr);
			if(type == 7){
				$element = $("input[id="+idstr+"]:checked");
			}
			//alert($element.val());
			str += "<tr><td width='20%' align='right'>${Affairmodelitem.modelitemname}</td><td>"+$element.val()+"</td></tr>";
		</c:forEach>
				
		str +="</table>";
		//alert(str);
		//这里拿到表单的数据.ajax提交
		var modelid = ${affairmodel.affairmodelid};
		alert(modelid);
		$.post("${pageContext.request.contextPath}/Affair/edit.action", 
			{affaircontent: str, affairmodelid: modelid},
			function(data){
				window.location.href = "${pageContext.request.contextPath}/Affair/list.action";
			},"JSON");
		})
	})
	
</script>

</html>
