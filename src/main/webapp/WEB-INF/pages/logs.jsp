<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	<a href="agent/main">代理商管理</a>\ <a href="javaScript:void(0)">查看操作日志</a>
</div>
<div class="container">
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
	<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/logs.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/logs.js"></script>
</body>
</html>