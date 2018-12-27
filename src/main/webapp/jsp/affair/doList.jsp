<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>


<title>Insert title here</title>
</head>
<body>

申请人:${vo.userid.nickname}
<br/>
${vo.affaircontent}
<form method="post" id="form1" action="${pageContext.request.contextPath}/Affair/nextDo.action">
<input id="pizhun" type="button"   value="批准"/>

<input id="bohui" type="button"  value="驳回"/>
<br/>
<input id="operate" type="hidden" name="affairchainstate" />
<input  type="hidden" name="affairchainid" value="${affairchainid}" />
备注:
<input type=text name="affairchainremark"  width="200px"><br/>
</form>

<script type="text/javascript">


$("#pizhun").click(function(){

	document.getElementById("operate").value="2";
	var form = document.getElementById('form1');
	form.submit();  
	});


$("#bohui").click(function(){
	document.getElementById("operate").value="3";
	var form = document.getElementById('form1');
	form.submit();  
	});

</script>

</body>
</html>