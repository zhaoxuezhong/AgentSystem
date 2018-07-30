<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	系统管理\ <a href="javascript:void(0)">财务管理</a>
</div>
<div class="container">
	<div class="serachuserdiv">
		<div>
			搜索用户:<input id="searchUserText" type="text">输入后自动搜索
		</div>
		<div class="searchresult" id="searchresult"></div>
	</div>
	<div class="searchuserdiv ope">
		<ul>
			<li>操作类型: <!-- <s:select id="zijintype" list="accountConfigList"
					headerKey="" headerValue="--请选择--"
					listKey="configTypeValue" listValue="configTypeName"></s:select> -->
					<select id="zijintype">
						<c:forEach items="${accountConfigList}" var="accountConfig">
							<option value="${accountConfig.configTypeValue}">${accountConfig.configTypeName}</option>
						</c:forEach>
					</select>
			</li>
			<li>操作资金:<input type="text" id="zijin"> <br>重要提示:输入的资金数,<b>正数(1000)</b>向账户输入1000元,<b>负数(-1000)</b>向账户减少1000元,精确到小数点两位数
			</li>
			<li>操作备注: <textarea id="memo"></textarea></li>
			<li><input type="button" id="caiwuok" value="确定">
			</li>
			<li class="tip">操作提示: <span id="systemtip">输入的资金数,<b>正数(1000)</b>向账户输入1000元,<b>负数(-1000)</b>向账户减少1000元,精确到小数点两位数</span>
			</li>
		</ul>
	</div>
</div>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/caiwu.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/caiwu.js"></script>
</body>
</html>
