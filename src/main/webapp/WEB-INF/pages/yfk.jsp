<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	<a href="agent/main">代理商管理</a>\ <a href="javascript:void(0)">代理商预付款</a>
</div>
<div class="container">
	<!-- search box -->
	<div class="searchuserdiv ope">
		<ul>
			<li>
				<form action="agent/account/yfk" method="post" onsubmit="return searchyfklistFunc()">
					操作类型:<select name="detailType">
					<option value="">--请选择--</option>
					<option <c:if test="${accountCondition.detailType==9999}">selected</c:if>	
					 value="9999">系统自动-关键词申请扣款</option>
					<option <c:if test="${accountCondition.detailType==9998}">selected</c:if>	
					value="9998">系统自动-返回预注册冻结资金</option>
					<option  <c:if test="${accountCondition.detailType==9997}">selected</c:if>	
					value="9997">系统自动-扣除申请关键词的所有资金</option>
					<option <c:if test="${accountCondition.detailType==9996}">selected</c:if>	
					value="9996">系统自动-扣除关键词续费资金</option>
					<c:forEach items="${accountConfigList}" var="ac">
						<option ${ac.id==accountCondition.detailType?'selected':''}						
						 	value="${ac.id }">${ac.configTypeName}</option>
					</c:forEach>
					</select> 
					
					操作时间: <input type="text" class="Wdate" 
						size="15" onClick="WdatePicker()" id="starttime" readonly="readonly"
						name="startTime" value="<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>"> 至 <input type="text" class="Wdate"
						size="15" onClick="WdatePicker()" id="endtime"  readonly="readonly"
						name="endTime" value="<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>"> 
						<input type="submit" value="查询" />
<input  type="hidden" name="pageIndex" value="1"/>
				</form></li>
		</ul>
	</div>
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
			<c:forEach items="${accountdetailList.list}" var="ad" varStatus="status">
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
			<c:if test="${empty accountdetailList.list}">
				<tr>
					<td colspan="6">查无数据</td>
				</tr>
			</c:if>
		</tbody>
	</table>
	<c:set value="${accountdetailList}" var="pager"/>
	<%@ include file="inc/pagination.jsp" %>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/yfk.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/yfk.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/medire/WdatePicker.js"></script>
</body>
</html>