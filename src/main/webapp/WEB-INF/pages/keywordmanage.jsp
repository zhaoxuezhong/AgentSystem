<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ <a href="javascript:void(0)">关键词申请管理</a>
</div>
<div class="container">
	<!-- 搜索 -->
	<div>
		<ul>
			<li>
				<form action="agent/keyword/keywordmanage" method="post">
					关键词:<input type="text" name="keywords"
						value="${asKeywords.keywords}"> <input type="submit"
						value="查询">
						<input  type="hidden" name="pageIndex" value="1"/>
				</form>
			</li>
		</ul>
	</div>

	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>关键词</th>
				<th>客户名称</th>
				<th>代理商</th>
				<th>申请年限</th>
				<th>申请日期</th>
				<th>到期日期</th>
				<th>申请到期状态</th>
				<th>审核状态</th>
				<th>使用状态</th>
				<th>APP开通状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${keywordsList.list}" varStatus="st" var="keyword">
				<tr>
					<td>${st.index+1}</td>
					<td>${keyword.keywords}</td>
					<td>${keyword.customName }</td>
					<td>${keyword.agentName }</td>
					<td>${keyword.serviceYears}</td>
					<td>${keyword.regDatetime}</td>
					<td>${keyword.regPassDatetime}</td>
					<td>${keyword.isPass==null?'':keyword.isPass==0?'不过期':keyword.isPass==1?'预注册过期':'正式注册过期'}
					</td>
					<td>
						${keyword.checkStatus==0?'已申请':keyword.checkStatus==1?'审核中':keyword.checkStatus==2?'已通过':'未通过'}
					</td>
					<td>${keyword.isUse==1?'已使用':'未使用'}</td>
					<td>${keyword.openApp==0?'<font color="red">未开通</font>':'开通'}
					</td>
					<td><c:choose>
							<c:when test="${keyword.isUse==1}">
								<c:choose>
									<c:when test="${keyword.checkStatus==2}">
										<c:if test="${keyword.openApp==0}">
											<a class="openapp" kid="${keyword.id}"
												keyword="${keyword.keywords}">开通APP</a>
										</c:if>
										<a class="xufei" kid="${keyword.id}"
											keyword="${keyword.keywords}">续费</a>
									</c:when>
									<c:when test="${keyword.isPass==2}">
										<a class="xufei" kid="${keyword.id}"
											keyword="${keyword.keywords}">续费</a>
										<a class="deletekeyword" kid="${keyword.id}"
											keyword="${keyword.keywords}">删除</a>
									</c:when>
									<c:when test="${keyword.checkStatus==3}">
										<a class="deletekeyword" kid="${keyword.id}"
											keyword="${keyword.keywords}">删除</a>
									</c:when>
									<c:otherwise>
										无操作
										</c:otherwise>
								</c:choose>
							</c:when>
							<c:otherwise>
							无操作
							</c:otherwise>
						</c:choose></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set value="${keywordsList}" var="pager"></c:set>
	<%@ include file="inc/pagination.jsp"%>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/keywordmanage.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/keywordmanage.js"></script>
</body>
</html>