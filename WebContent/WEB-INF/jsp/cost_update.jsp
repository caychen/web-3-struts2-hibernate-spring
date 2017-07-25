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
		<s:form action="update" theme="simple" method="post">
			<div>ID:
			<s:textfield name="cost.id" readonly="true" ></s:textfield></div>
			
			<div>名称:
			<s:textfield name="cost.name"></s:textfield></div>
			
			<div>在线时长:
			<s:textfield name="cost.baseDuration"></s:textfield></div>
			
			<div>月固定费:
			<s:textfield name="cost.baseCost"></s:textfield></div>
		
			<div>单位费用:
			<s:textfield name="cost.unitCost" ></s:textfield></div>
					
			<div>资费信息说明:
			<s:textarea name="cost.descr" rows="5" cols="5"></s:textarea></div>
			<s:hidden name="page"></s:hidden>
			<input type="submit" value="保存"/>
			<input type="button" value="取消" onclick="location.href='list.action?page=${page}'"/>	
		</s:form>
	</div>
	
</body>
</html>