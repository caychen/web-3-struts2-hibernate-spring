<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link style="text/css" href="../css/style.css" rel="stylesheet" />
</head>
<body>
	<s:form>
			<table>
				<thead>
					<tr>
						<td>资费ID</td>
						<td>资费名称</td>
						<td>包在线时长</td>
						<td>月固定费</td>
						<td>单位费用</td>
						<td>状态</td>
						<td>资费信息说明</td>
						<td>创建日期</td>
						<td>启用日期</td>
						<td colspan="3">操作</td>
					</tr>
				</thead>
				<tbody>
					<!-- 
					value是一个OGNL表达式，通过这个表达式在ValueStack中取出一个可迭代的对象
					然后在迭代的过程中，从集合中依次取出对象放到ValueStack的栈顶，
					迭代完成之后，栈顶恢复为Action
				-->
					<s:iterator value="costList">
						<tr>
							<td><s:property value="id" /></td>
							<td><s:property value="name" /></td>
							<td><s:property value="baseDuration" /></td>
							<td><s:property value="baseCost" /></td>
							<td><s:property value="unitCost" /></td>
							<td>
								<!-- <s:if test="status == 1">开通</s:if>
							<s:else>暂停</s:else> --> <s:property value="statusOptions[status]" />
							</td>
							<td><s:property value="descr" /></td>
							<td><s:property value="createTime" /></td>
							<td><s:property value="startTime" /></td>
							<td><input type="button" value="编辑"
								onclick="location.href='showform.action?cost.id=${id}}'" /> <s:if
									test="status == 1">
									<input type="button" value="暂停"
										onclick="location.href='endcost.action?cost.id=${id}'" />
								</s:if> <s:else>
									<input type="button" value="启用"
										onclick="location.href='startcost.action?cost.id=${id}'" />
								</s:else> <input type="button" value="删除"
								onclick="location.href='delete.action?id=${id}'" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</s:form>
</body>
</html>