<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	系统管理\ <a href="javascript:void(0)">关键词审核</a>
</div>
<div class="container">
	<!-- 搜索 -->
	<div class="serachuserdiv ope">
		<ul>
			<li>
				<form action="agent/keyword/checkkeyword" method="post">
				<input  type="hidden" name="pageIndex" value="1"/>
					关键词:<input type="text" name="keywords"
						value="${asKeywords.keywords}"> <input type="submit"
						value="查询"> <span class="okflow">审核流程:已申请(代理商申请)>审核中>通过>续费</span>
					<span class="noflow">审核流程:已申请(代理商申请)>审核中>不通过</span>
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
			<c:forEach items="${keywordsList.list}" var="keyword" varStatus="st">
				<tr>
					<td>${st.index+1}</td>
					<td>${keyword.keywords}</td>
					<td>${keyword.customName }</td>
					<td>${keyword.agentName }</td>
					<td>${keyword.serviceYears }</td>
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
					<td><select class="checkselect" kid="${keyword.id}"
						keyword="${keyword.keywords}">
							<option value="">--请选择--</option>
							<!-- 如果已申请 -->
							<c:choose>
								<c:when test="${keyword.checkStatus==0 and keyword.isUse==1 }">
									<option value="1">审核中</option>
								</c:when>
								<c:when test="${keyword.checkStatus==1 and keyword.isUse==1 }">
									<option value="2" data-year="${keyword.serviceYears}">审核通过</option>
									<option value="3">审核不通过</option>
								</c:when>
								<c:when test="${keyword.checkStatus==2 and keyword.isUse==1 }">
									<option value="4">续费</option>
								</c:when>
							</c:choose>

							<c:choose>
								<c:when test="${keyword.isUse==1 }">
									<option value="5">不使用</option>
								</c:when>
								<c:otherwise>
									<option value="6">使用</option>
								</c:otherwise>
							</c:choose>
					</select></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set value="${keywordsList}" var="pager"></c:set>
	<%@ include file="inc/pagination.jsp"%>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/checkkeyword.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/checkkeyword.js"></script>
</body>
</html>