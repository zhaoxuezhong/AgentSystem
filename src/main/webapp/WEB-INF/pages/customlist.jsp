<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ <a href="javascript:void(0)">代理商客户管理</a>
</div>
<div class="container">
	<form action="agent/customs/customlist" method="post">
		<div>
			<label>客户名称:</label>
			<input type="text" id="cname" name="customName" value="${asCustoms.customName}">
			<input type="submit" value="查询"/>
			
		</div>
	</form>

	<div class="addCustomDiv">
		<input type="button" id="addCustomBtn" value="添加客户">
	</div>

	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>客户名称</th>
				<th>法人代表</th>
				<th>注册时间</th>
				<th>类型</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${customsList.list}" var="customs" varStatus="st">
			<tr>
					<td>${st.index+1}</td>
					<td>${customs.customName}</td>
					<td>${customs.bossName}</td>
					<td>${customs.regDatetime}</td>
					<td>${customs.customTypeName}</td>
					<td>${customs.customStatus==1?'启用':'停用'}</td>					
					<td class="funcli">
						<ul>
							<li><a class="viewCustom" id="${customs.id}">查看 </a> </li>
							<li><a class="modifyCustom" id="${customs.id}"> 修改</a></li>
							<li><a class="mofifyCustomStatus" id="${customs.id}" customName="${customs.customName}" mStatus="${customs.customStatus}">
							${customs.customStatus==0?'<font color=\"green\">启用</font>':'<font color=\"red\">停用</font>'}
							</a> </li>
						</ul>
					
					</td>
				</tr>
		</c:forEach>
			<%-- <s:iterator value="pager.items" status="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${customName}</td>
					<td>${bossName}</td>
					<td><s:date name="regDatetime" format="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${customTypeName}</td>
					<td>${customStatus==1?'启用':'停用'}</td>					
					<td class="funcli">
						<ul>
							<li><a class="viewCustom" id="${id}">查看 </a> </li>
							<li><a class="modifyCustom" id="${id}"> 修改</a></li>
							<li><a class="mofifyCustomStatus" id="${id}" customName="${customName}" mStatus="${customStatus}">
							<s:if test="customStatus==1">
								<font color="red">停用</font></s:if>
							<s:else>
								<font color="green">启用</font>
							</s:else>
							</a> </li>
						</ul>
					
					</td>
				</tr>
			</s:iterator> --%>
		</tbody>
	</table>
	<c:set var="pager" value="${customsList}"></c:set>
	<%@ include file="inc/pagination.jsp" %>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/customlist.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/customlist.js"></script>
</body>
</html>
<s:debug></s:debug>