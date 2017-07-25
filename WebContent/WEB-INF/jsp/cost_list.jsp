<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link style="text/css" href="../css/style.css" rel="stylesheet"/>
</head>
<body>
	<div>
		<table cellpadding="0" cellspacing="0" border="1">
			<thead>
				<tr>
					<td>资费ID</td>
					<td>资费名称</td>
					<td>包在线时长</td>
					<td>月固定费</td>
					<td>单位费用</td>
					<td>状态</td>
					<td>资费信息说明</td>
					<td>启用日期</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${costList }" var="cost" varStatus="v">
					<tr class="s${v.index % 2 + 1 }">
						<td>${cost.ID }</td>
						<td>${cost.name }</td>
						<td>${cost.baseDuration }</td>
						<td>${cost.baseCost }</td>
						<td>${cost.unitCost }</td>
						<td>
							<c:if test="${cost.status == '0' }" var="close">暂停</c:if>
							<c:if test="${!close }">开通</c:if>
						</td>
						<td>${cost.descr }</td>
						<td>${cost.startTime }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div id="pages">
		<a href="#" class="nextpre">上一页</a>
		
		<c:forEach begin="1" end="${totalPages }" var="p">
			<c:choose>
				<c:when test="${p == page }">
					<a href="#" class="page">${p }</a>
				</c:when>
				<c:otherwise>
					<a href="list.action?page=${p }">${p }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
		<a href="#" class="nextpre">下一页</a>
	</div>
</body>
</html>