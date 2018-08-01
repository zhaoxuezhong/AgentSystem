<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include><div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ <a href="agent/customs/customlist">代理商客户管理</a>\ <a href="agent/customs/viewcustom/${custom.id}">查看客户信息</a>
</div>
<div class="container">
	<div class="subtitle">基本信息</div>
	<div class="info1">
		<ul>
			<li>企业名称:${custom.customName}</li>
			<li>企业类型:${custom.customTypeName}</li>
			<li>企业主页:${custom.siteUrl}</li>
			<li>状态:${custom.customStatus==1?"启用":"停用"}</li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	
	<div class="subtitle">门户信息</div>
	<div class="info2">
		<ul>
			<li>法人代表: ${custom.bossName }</li>
			<li>注册日期:${custom.regDatetime}
			</li>
			<li>证件类型: ${custom.cardTypeName }</li>
			<li>证件号码:${custom.cardNum}</li>
			<li>国家:${custom.country}</li>
			<li>省份: ${custom.provinceName }</li>
			<li>公司传真:${custom.companyFax}</li>
			<li>城市: ${custom.cityName}</li>
			<li>公司电话:${custom.companyTel}</li>
			<li>区:${custom.areaName}</li>
			<li>公司地址:${custom.companyAddress}</li>
			<li>备注:${custom.memo }</li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="subtitle">联系信息</div>
	<div class="info3">
		<table>
			<thead>
				<tr>
					<th>姓名</th>
					<th>电话</th>
					<th>传真</th>
					<th>邮箱</th>
					<th>职务</th>
				</tr>
			</thead>
			<tbody id="addtr">
				<c:forEach items="${custom.contactList}" var="contact">
					<tr>
						<td>${contact.contactName}</td>
						<td>${contact.contactTel}</td>
						<td>${contact.contactFax}</td>
						<td>${contact.contactEmail}</td>
						<td>${contact.contactRole}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/viewcustom.css">
</body>
</html>