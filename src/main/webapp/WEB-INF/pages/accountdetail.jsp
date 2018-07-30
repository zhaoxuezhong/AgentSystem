<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/accountdetail.css">
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\当前账户信息\ <a href="javascript:void(0)">查看账户明细</a>
</div>
<div class="container">

	<!-- accountdetail列表 -->
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>账务类型</th>
				<th>账务资金</th>
				<th>账户余额</th>
				<th>备注信息</th>
				<th>明细时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${accountDetailList.list}" var="ad" varStatus="status">
				<tr>
					<td>${status.index+1}</td>
					<td>${ad.detailTypeName}</td>
					<td>￥${ad.money}</td>
					<td>￥${ad.accountMoney}</td>
					<td>${ad.memo}</td>
					<td><fmt:formatDate value="${ad.detailDateTime}" pattern="yyyy-MM-dd"/>
					</td>
				</tr>
			</c:forEach>
			<c:if test="${empty accountDetailList.list}">
				<tr>
					<td colspan="6">查无数据</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<c:set value="${accountDetailList}" var="pager"/>
	<%@ include file="inc/pagination.jsp" %>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
