<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\当前账户信息\ <a href="/accountdetail.action">查看账户明细</a>
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
			<s:iterator value="pager.items" status="st">
				
				<tr>
					<td><s:property value="#st.index+1" /></td>
					<td><s:property value="detailTypeName" /></td>
					<td>￥<s:property value="money" /></td>
					<td>￥<s:property value="accountMoney" /></td>
					<td><s:property value="memo" /></td>
					<td><s:date name="detailDateTime" format="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
	
	<div class="pagination pagination-centered">
				<ul>
					<li><a
						href="/accountdetail.action?pager.page=1&uname=<s:property value="uname" />">首页</a>
					</li>
					<s:if test="pager.prevPages!=null">
						<s:iterator value="pager.prevPages"  var="num">
							<li><a href="/accountdetail?pager.page=<s:property value="#num"/>"><s:property value="#num"/></a></li>
						</s:iterator>
					</s:if>
					<li class="active">
						<a href="#"><s:property value="pager.page"/></a>
					</li>
					<s:if test="pager.nextPages!=null">
						<s:iterator value="pager.nextPages" var="num">
							<li><a href="/accountdetail?pager.page=<s:property value="#num"/>"><s:property value="#num"/></a></li>
						
						</s:iterator>
					</s:if>
					<li><a 					
					href="/accountdetail?pager.page=<s:property value="pager.pageCount"/>">尾页</a>
					</li>
				</ul>
			</div>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/accountdetail.css">

</body>
</html>
