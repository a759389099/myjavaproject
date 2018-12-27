<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/skin_/form.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.select.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/WdatePicker.js"></script>
<style type="text/css">
	.lan{padding:10px;}
	.lan>label{margin-left:10px;}
	.chain{font-size:15px; margin-bottom:10px;}
	.chain>label{display:inline-block;width:150px;}
	#peo{display:inline-block;cursor:pointer;padding:2px 10px 2px 10px; background:#cccccc;margin-right:20px;}
	#peo:hover{ background:#ff9966;}
	#chainMap{margin:30px;clear:both;font-size:30px;}
</style>
<title>基础信息</title>
</head>

<body>
<div id="container">
    <div id="bd">
    	<div id="main">
            
            <form name="f1" action="${pageContext.request.contextPath}/AffairModule/AffairModuleAdd.action" method="post">
            
            	<h2 class="subfild"><span>流程名称</span></h2>
            	<div class="kv-item ue-clear">  
            		<label>流程名称：</label>
                	<div class="kv-item-content"><input name="affairmodel.affairmodelname" type="text" /></div>
                </div>
            	<div class="kv-item ue-clear">  
            		<label>流程类型：</label>
                	<div class="kv-item-content">
                		<select name="modelItemType1">
                            <option value="1">行政类</option>
							<option value="2">人事类</option>
							<option value="3">人力资源</option>
							<option value="4">财务类</option>
                        </select>
                	</div>
                </div>
            	
            	          	
            	
            	
            	
            	<h2 class="subfild"><span>流程栏位</span></h2>
            	<div style="margin:20px 0 20px 0px;">
	            	<div class="lan">            		
	                	<label>栏目：</label>
	                	<input name="affairmodelitemList[0].modelitemname" type="text" />	                               	
	                	<label>类型：</label>
	                    	<select name="affairmodelitemList[0].modelitemtype">
	                            <option value="1">文本框</option>
								<option value="2">日期</option>
								<option value="3">下拉列表</option>
								<option value="4">单选</option>
								<option value="5">多选</option>
								<option value="6">上传</option>
								<option value="7">多行文本</option>
	                        </select>	                           		
	                	<label>参数：</label>
	                	<input name="affairmodelitemList[0].modelitemoption" type="text" />                   
	                </div>	              
	           		<input id="btnadd" type="button" value="添加栏位" /> 
	           		<!-- 隐藏框：记录栏目数量，默认为1 -->
	            	<input name="cols" type="text" value="1" />           	
            	</div>
            		
            	
                <h2 class="subfild"><span>流程链</span></h2>
                <div class="chain">
                	<label>总经理办公室：</label>
                	<span id="peo" data="1">李波</span>
                </div>
                <div class="chain">
                	<label>测试部门：</label>
                	<span id="peo" data="2">马雪梅</span>
                	<span id="peo" data="3">倪笑宇</span>
                	<span id="peo" data="4">张明</span>
                	<span id="peo" data="5">霍芳</span>
                </div>
                
                
                                          审批流程：
                <div id="chainMap">
					<label data="-1">提交流程→</label>
				</div>
                <!-- 隐藏框：记录栏目数量，默认为-1,表示自己 -->
	            <input name="affairmodel.affairchain" type="text" value="-1" />
            
            <div class="buttons" style="margin-top:30px;">
                <input class="button" type="submit" value="确认添加" />                
            </div>            	            	
            </form>
            
            
        </div>
    </div>
</div>
<script type="text/javascript">

//添加栏目按钮功能
$("#btnadd").click(function(){
	
	//获取隐藏栏目数量文本框的值
	var cols = $("input[name='cols']").val();
	
	//点击了添加，这个值 ++
	cols++;
	
	//更新隐藏框中栏目的数量
	$("input[name='cols']").val(cols);
	
	//创建html内容	
	$(this).before("<div class=\"lan\"><label>栏目：</label><input name=\"affairmodelitemList["+(cols-1)+"].modelitemname\" type=\"text\" /><label> 类型：</label><select name=\"affairmodelitemList["+(cols-1)+"].modelitemtype\"><option value=\"1\">文本框</option><option value=\"2\">日期</option><option value=\"3\">下拉列表</option><option value=\"4\">单选</option><option value=\"5\">多选</option><option value=\"6\">上传</option><option value=\"7\">多行文本</option></select><label> 参数：</label><input name=\"affairmodelitemList["+(cols-1)+"].modelitemoption \" type=\"text\" /></div></div>");
	
});
	

//流程链
$(".chain>span").click(function(){
	
	var obj=$(this);
	
	//组合提交内容
	var str = $("input[name='affairmodel.affairchain']").val();
	arr = str.split(",");
	var flag=true;
	$("input[name='affairmodel.affairchain']").val("-1");
	for(var i=1; i<arr.length; i++){
		if(arr[i]!=""){
			if($(this).attr("data")!=arr[i]){
				$("input[name='affairmodel.affairchain']").val($("input[name='affairmodel.affairchain']").val()+","+arr[i]);
			}
			else{
				flag=false;
				$(this).css({"background":"#cccccc"});
				$("#chainMap>label").each(function(index,dom){
					if($(dom).attr("data")==obj.attr("data")){
						$(dom).remove();
					}
				});
			}
		}
	}
	if(flag){
		$(this).css({"background":"#ff9966"});
		$("input[name='affairmodel.affairchain']").val($("input[name='affairmodel.affairchain']").val()+","+$(this).attr("data"));
		$("#chainMap").html($("#chainMap").html()+"<label data=\""+$(this).attr("data")+"\">"+$(this).html()+"→</label>");
	}
	
});
</script>
</body>
</html>
