<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.js"></script>
<script type="text/javascript" src="../js/functions.js"></script>
<script type="text/javascript">
	$(function(){
		function validateCostForm(){
			var b1 = $('#costname').require("资费名称必须填写",$('#costname_errmsg'));
			
			var b2 = false;
			if(b1)
				b2 = $('#costname').range(3,20,"资费名称长度不符",$('#costname_errmsg'));
			var b3 = false;
			if(b2)
				b3 = $('#costname').remote('validateCostName.action','资费名称被占用',$('#costname_errmsg'));
			
			var b4 = $('#costbaseduration').intRange(1,600,"必须是1~600之间的整数", $("#costbaseduration_errmsg"))
			return b3 && b4;
		}
		
		$('#save').click(function(){
			var bFlag = validateCostForm();
			if(bFlag)
				$('#costform').submit();
		});
	});
</script>
</head>
<body>
	<div id="main">
		<s:form method="post" theme="simple" id="costform" action="add">
			<div>名称:
				<s:textfield id="costname" name="cost.name"></s:textfield>
				<div id="costname_errmsg" style="color:red;">50长度的字母，数字和下划线的组合</div>
			</div>
			
			<div>在线时长:
				<s:textfield id="costbaseduration" name="cost.baseDuration"></s:textfield>
				<div id="costbaseduration_errmsg"></div>
			</div>
			
			<div>月固定费:
			<s:textfield name="cost.baseCost"></s:textfield></div>
		
			<div>单位费用:
			<s:textfield name="cost.unitCost"></s:textfield></div>
			 
			<div>资费信息说明:
			<s:textarea rows="5" cols="20" name="cost.descr"></s:textarea></div>
		
			<input type="button"  id="save" value="保存"/>
			<input type="button" value="返回"/>
		</s:form>
	</div>
</body>
</html>