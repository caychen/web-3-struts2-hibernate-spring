<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	input{
		color: red;
	}
</style>
</head>
<body>
	<div id="main">
		<s:form action="" theme="simple">
			<div>ID:
			<s:textfield name="cost.id"  readonly="true"></s:textfield></div>
			
			<div>名称:
			<s:textfield name="cost.name" readonly="true"></s:textfield></div>
			
			<div>在线时长:
			<s:textfield name="cost.baseDuration" readonly="true"></s:textfield></div>
			
			<div>月固定费:
			<s:textfield name="cost.baseCost" readonly="true"></s:textfield></div>
		
			<div>单位费用:
			<s:textfield name="cost.unitCost" readonly="true"></s:textfield></div>
			
			<div>状态:
			<s:select list="statusOptions" name="cost.status" disabled="true"></s:select> </div>
			
			<div>资费信息说明:
			<s:textarea name="cost.descr" readonly="true" rows="5" cols="5" ></s:textarea></div>
			
			<div>
			创建日期:
			<s:textfield name="cost.createTime" readonly="true"></s:textfield></div>
			
			<div>启用日期:
			<s:textfield name="cost.startTime" readonly="true"></s:textfield></div>
		</s:form>
	</div>
	<input type="button" value="返回" onclick="location.href='list.action?page=${page}'"/>
</body>
</html>