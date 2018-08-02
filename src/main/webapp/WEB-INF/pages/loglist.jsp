<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <jsp:include page="inc/head.jsp"></jsp:include> --%>
<html>
<head>

<title></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/public.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/main.css">
<!-- humane提醒库 -->
<link id='theme' rel='stylesheet' href='${pageContext.request.contextPath}/statics/humane/themes/original.css' />
<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/loglist.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/medire/WdatePicker.js"></script>
<script src='${pageContext.request.contextPath}/statics/humane/humane.js'></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/public.js"></script>
</head>
<body>
	<div class="mbxnav">
		账号:[
		${asLogs.userName}
		] LOG操作日志
	</div>

	<div class="container">
		<div class="seracheruserdiv ope">
			<ul>
				<li>
					<form action="loglist" method="post">
						<input type="hidden" id="userCode" name="userCode" value="${asLogs.userName}" /> 
						<input type="hidden" id="userId" name="userId" value="${asLogs.userId}" /> 
						操作时间: <input class="Wdate" onClick="WdatePicker()" size="15" readonly type="text" name="operateDatetime"
						value='<fmt:formatDate value="${asLogs.operateDatetime}" pattern="yyyy-MM-dd"/>'>
						<input type="submit" value="查询">
					</form>
				</li>
			</ul>
			<table>
				<tr>
					<td>登录账户</td>
					<td>操作信息</td>
					<td>操作时间</td>
				</tr>
				<c:forEach items="${logsList.list}" var="log">
					<tr>
						<td>${log.userName}
						</td>
						<td>${log.operateInfo}
						</td>
						<td>${log.operateDatetime}
						</td>
					</tr>
				</c:forEach>
			</table>

		<c:set value="${logsList}" var="pager"></c:set>
		<%@ include file="inc/pagination.jsp" %>
		</div>
	</div>
</body>
</html>