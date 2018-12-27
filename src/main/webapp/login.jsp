<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/skin_/login.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gVerify.js"></script>
<title>蓝色企业数字办公后台管理模板_用户登录</title>
</head>

<body>
<div id="container">
    <div id="bd">
    	<div id="main">
        	<div class="login-box">
                <div id="logo"></div>
                <h1></h1>
                <form action="${pageContext.request.contextPath}/User/login.action" method="post">
                <div class="input username" id="username">
                    <label for="userName">用户名</label>
                    <span></span>
                    <input type="text" id="userName" name="user.uname" value="${queryVo.user.uname}"/>
                </div>
                <div class="input psw" id="psw">
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <span></span>
                    <input type="password" id="password" name="user.upwd" value="${queryVo.user.upwd}"/>
                </div>
                <div class="input validate" id="validate">
                    <label for="valiDate">验证码</label>
                    <input type="text" id="valiDate"  name="code"/>
                    <div id="code_value" class="value"></div>
                    
                    <p style="margin-left: 150px; margin-top: 10px; color: red;">${errorMeg}</p>
                </div>
                <div class="styleArea">
                    <div class="styleWrap">
                        <select name="style" id="duoxuan">
                            <option value="default">默认风格</option>
                            <option value="red">红色风格</option>
                            <option value="green">绿色风格</option>
                        </select>
                    </div>
                </div>
                <div id="btn" class="loginButton">
                    <input type="submit" class="button" value="登录"  />
                </div>
            	</form>
            </div>
        </div>
        <div id="ft">CopyRight&nbsp;2014&nbsp;&nbsp;版权所有&nbsp;&nbsp;More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> &nbsp;&nbsp;</div>
    </div>
   
</div>

</body>
<script type="text/javascript">

window.onload = function(){
	// 判断当前窗口是不是最大的父窗口
	if(window != window.parent){
		// 不是的话把父窗口的地址栏改掉
		window.parent.location = "${pageContext.request.contextPath}/User/login.action";
	}
	
}

	$(function(){
		$.get("/oa_maven_ssm/User/checkCode.action",function(data){
			$("#code_value").text(data);
		});
		
		$("#code_value").click(function(){
			$.get("/oa_maven_ssm/User/checkCode.action",function(data){
				$("#code_value").text(data);
			});
		})
		
		$("#duoxuan").change(function(){
			//选中的值
			if($('#duoxuan option:selected').val()=="default"){
				$("#container").css("background-color", "#0170a4");
			}
			if($('#duoxuan option:selected').val()=="red"){
				$("#container").css("background-color", "red");
			}
			if($('#duoxuan option:selected').val()=="green"){
				$("#container").css("background-color", "green");
			}
			
		});
		
	})

	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
        var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
    });
	$('select').select();
	/* 
	$('.loginButton').click(function(e) {
        document.location.href = "main.html";
    }); */
</script>

</html>
