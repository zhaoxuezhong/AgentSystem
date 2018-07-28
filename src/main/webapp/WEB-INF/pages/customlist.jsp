<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ <a href="/accounthetail.action">代理商客户管理</a>
</div>
<div class="container">
	<form action="/customlist.action" method="post">
		<div>
			<label>客户名称:</label>
			<input type="text" id="cname" name="custom.customName" value="${custom.customName}">
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
			<s:iterator value="pager.items" status="st">
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
			</s:iterator>
		</tbody>
	</table>
	<div class="pagination pagination-centered">
				<ul>
					<li><a
						href="/customlist.action?pager.page=1&custom.customName=<s:property value="custom.customName" />">首页</a>
					</li>
					<s:if test="pager.prevPages!=null">
						<s:iterator value="pager.prevPages"  var="num">
							<li><a href="/customlist.action?pager.page=<s:property value="#num"/>&custom.customName=<s:property value="custom.customName" />"><s:property value="#num"/></a></li>
						</s:iterator>
					</s:if>
					<li class="active">
						<a href="#"><s:property value="pager.page"/></a>
					</li>
					<s:if test="pager.nextPages!=null">
						<s:iterator value="pager.nextPages" var="num">
							<li><a href="/customlist.action?pager.page=<s:property value="#num"/>&custom.customName=<s:property value="custom.customName" />"><s:property value="#num"/></a></li>
						
						</s:iterator>
					</s:if>
					<li><a 					
					href="/customlist.action?pager.page=<s:property value="pager.pageCount"/>&custom.customName=<s:property value="custom.customName" />">尾页</a>
					</li>
				</ul>
			</div>
	
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/css/customlist.css">
<script type="text/javascript" src="/js/customlist.js"></script>
</body>
</html>
<s:debug></s:debug>