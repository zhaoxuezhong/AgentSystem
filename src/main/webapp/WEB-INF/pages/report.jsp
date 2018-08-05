<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	<a href="javascript:void(0)">报表管理</a>
</div>
<div class="container">
	<!-- search box -->
	<div class="searchuserdiv ope">
		<ul>
			<li>
				<form action="agent/report/report" method="post" onsubmit="return searchReportFunc();">
					操作类型:<select name="reportType" id="reporttype">					
					<option value="">财务报表</option>
					<option value="1" ${reportType==1?"selected":""}>&nbsp;&nbsp;&nbsp;&nbsp;代理商账户余额报表</option>
					<option value="2" ${reportType==2?"selected":""}>&nbsp;&nbsp;&nbsp;&nbsp;预付款流水报表</option>
					<option value="3" ${reportType==3?"selected":""}>&nbsp;&nbsp;&nbsp;&nbsp;代理商流水报表</option>					
					<option value="">产品报表</option>
					<option value="4" ${reportType==4?"selected":""}>&nbsp;&nbsp;&nbsp;&nbsp;产品分类数量/金额汇总</option>
					</select> 
						<div id="opertime" style="margin-left: 250px;margin-top: -20px;${reportType!=1?'display:block':'display:none'}">
					
					操作时间: <input type="text" class="Wdate" 
						size="15" onClick="WdatePicker()" id="starttime" readonly="readonly"
						name="startTime" value="<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>"> 至 <input type="text" class="Wdate"
						size="15" onClick="WdatePicker()" id="endtime"  readonly="readonly"
						name="endTime" value="<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>"> 
					</div>
					<div style="margin-left: 580px;margin-top: -20px">
						<input type="submit" value="查询" />
					</div>

				</form></li>
		</ul>
	</div>
	<!-- 查询结果列表 -->
	<c:if test="${reportType==1}">
		<!-- 代理商余额报表 -->
		<div class="downloadfile">
			<ul>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/pdf.png"><a href="agent/report/reportaccount">PDF下载</a></li>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/excel.png"><a href="agent/report/reportaccounte">Excel下载</a></li>
			</ul>
		</div>
		<h1>代理商余额报表</h1>
		<table>
			<thead>
				<tr>
					<th>序号</th><th>代理商名称</th><th>账户余额</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${accountList}" var="account" varStatus="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${account.userName}</td>
					<td>${account.money}</td>
				</tr>
			</c:forEach>
			</tbody>
		
		</table>
	</c:if>
	<c:if test="${reportType==2}">
	
		<!-- 预付款流水报表 -->	
		<div class="downloadfile">
			<ul>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/pdf.png">
				<a href="agent/report/reportyfkpdf?startTime=<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>
				&endTime=<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>">PDF下载</a></li>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/excel.png">
				<a href="agent/report/reportyfkxls?startTime=<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>
				&endTime=<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>">Excel下载</a></li>
			</ul>
		</div>
		<h1>预付款流水报表</h1>
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>代理商名称</th>
					<th>预付款</th>
					<th>账户余额</th>
					<th>备注信息</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${accountDetailList}" var="ad" varStatus="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${ad.userName}</td>
					<td>${ad.money}</td>
					<td>${ad.accountMoney}</td>
					<td>${ad.memo}</td>
					<td><fmt:formatDate value="${ad.detailDateTime}" pattern="yyyy-MM-dd"/> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${reportType==3}">
		<!-- 代理商流水报表 -->	
		<div class="downloadfile">
			<ul>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/pdf.png">
				<a href="agent/report/reportdlspdf?startTime=<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>
				&endTime=<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>">PDF下载</a></li>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/excel.png">
				<a href="agent/report/reportdlsxls?startTime=<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>
				&endTime=<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>">Excel下载</a></li>
			</ul>
		</div>
		<h1>代理商流水报表</h1>
		<table>
			<thead>
				<tr>
					<th>序号</th>
					<th>代理商名称</th>
					<!-- <th>预付款</th> --><th>操作资金</th>
					<th>账户余额</th>
					<th>备注信息</th>
					<th>时间</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${accountDetailList}" var="ad" varStatus="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${ad.userName}</td>
					<td>${ad.money}</td>
					<td>${ad.accountMoney}</td>
					<td>${ad.memo}</td>
					<td><fmt:formatDate value="${ad.detailDateTime}" pattern="yyyy-MM-dd"/> </td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
	<c:if test="${reportType==4}">
	<!-- 产品分类数量/金额汇总 -->
	<div class="downloadfile">
			<ul>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/pdf.png">
				<a href="agent/report/reportproductpdf?startTime=<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>
				&endTime=<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>">PDF下载</a></li>
				<li><img src="${pageContext.request.contextPath}/statics/imgs/excel.png">
				<a href="agent/report/reportproductxls?startTime=<fmt:formatDate value="${accountCondition.startTime}" pattern="yyyy-MM-dd"/>
				&endTime=<fmt:formatDate value="${accountCondition.endTime}" pattern="yyyy-MM-dd"/>">Excel下载</a></li>
			</ul>
		</div>
	<h1>产品分类数量/金额汇总</h1>
		<table>
			<thead>
				<tr>
					<th>序号</th><th>产品分类名称</th><th>数量</th><th>优惠价</th><th>原价</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${reportproductList}" var="product" varStatus="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${product.serviceName}</td>
					<td>${product.serviceYears}</td>
					<td>￥${product.price}</td>
					<td>￥${product.serviceYears*product.preRegFrozenMoney}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
	<%--<table>
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
			<s:iterator value="pager.items" status="st">

				<tr>
					<td><s:property value="#st.index+1" />
					</td>
					<td><s:property value="detailTypeName" />
					</td>
					<td>￥<s:property value="money" />
					</td>
					<td>￥<s:property value="accountMoney" />
					</td>
					<td><s:property value="memo" />
					</td>
					<td><s:date name="detailDateTime" format="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

	
--%></div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/report.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/report.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/medire/WdatePicker.js"></script>
</body>
</html>