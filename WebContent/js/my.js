function loadSource(typeCode, selectName, positionId, selectedId) {
	// 1.发送ajax请求
	$.post("/my1112ssm/basedict/list.action", {
		"typeCode" : typeCode
	}, function(data) {
		
		// 生成一个select
		var $select = $("<select name='" + selectName + "'></select>");
		// 生成第一个选项
		var $op1 = $("<option value=''>---请选择---</option>");
		
		$select.append($op1);
		
		// 循环data这个json数组
		$.each(data, function(i, obj){
			
			var $op = $("<option value='"+ obj.dictId  +"'>" + obj.dictItemName + "</option>")
			
			if(obj.dictId == selectedId){
//				$op.prop("selected", true);
				$op.attr("selected", "selected");
			}
			
			
			$select.append($op);
			
		});
		
		// 把生成的select放入指定的id的元素内部
		$("#" + positionId).append($select);
		
	}, "json");

}