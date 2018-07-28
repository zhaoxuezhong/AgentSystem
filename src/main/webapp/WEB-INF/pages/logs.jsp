<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	<a href="/main.action">代理商管理</a>\ <a href="/mylogs.action">查看操作日志</a>
</div>
<div class="container">
		

			<table>
				<tr>
					<td>登录账户</td>
					<td>操作信息</td>
					<td>操作时间</td>
				</tr>

				<%--<s:iterator value="logsList">
					<tr>
						<td><s:property value="userName" /></td>
						<td><s:property value="operateInfo" /></td>
						<td><s:date name="operateDatetime"  format="yyyy-MM-dd"/></td>
					</tr>
				</s:iterator>
			--%>
				<s:iterator value="pager.items">
					<tr>
						<td><s:property value="userName" />
						</td>
						<td><s:property value="operateInfo" />
						</td>
						<td><s:date name="operateDatetime" format="yyyy-MM-dd HH:mm:ss" />
						</td>
					</tr>
				</s:iterator>
			</table>

			<div class="pagination pagination-centered">
				<ul>
					<li><a
						href="/mylogs.action?pager.page=1">首页</a>
					</li>
					<s:if test="pager.prevPages!=null">
						<s:iterator value="pager.prevPages"  var="num">
							<li><a href="/mylogs.action?pager.page=<s:property value="#num"/>"><s:property value="#num"/></a></li>
						</s:iterator>
					</s:if>
					<li class="active">
						<a href="#"><s:property value="pager.page"/></a>
					</li>
					<s:if test="pager.nextPages!=null">
						<s:iterator value="pager.nextPages" var="num">
							<li><a href="/mylogs.action?pager.page=<s:property value="#num"/>"><s:property value="#num"/></a></li>
						
						</s:iterator>
					</s:if>
					<li><a 					
					href="/mylogs.action?pager.page=<s:property value="pager.pageCount"/>">尾页</a>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<link rel="stylesheet" href="/css/logs.css" />
	<script type="text/javascript" src="/js/logs.js"></script>
</body>
</html>
<s:debug></s:debug>