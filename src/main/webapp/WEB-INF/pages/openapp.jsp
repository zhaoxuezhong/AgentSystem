<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="addAppTitle">
	<h2>开通APP</h2>
</div>

<div class="formdiv">
	<form action="modifyapp" method="post">
		<div>
			<input type="hidden" name="id" value="${keywords.id}"/>
			<input type="hidden" name="openApp" value="1"/>
			<ul>
			
				<li>登录账号:<input type="text" name="appUserName" value="${keywords.appUserName}"></li>
				<li>登录密码:<input type="text" name="appPassword" value="${keywords.appPassword}"></li>
				<li>关键词:${keywords.keywords}</li>
				<li>企业名称:${keywords.customName}</li>
				<li>价格: ￥ ${keywords.price}</li>
				<li>服务类型:${keywords.serviceName}</li>
			</ul>
		</div>
		<div class="clear"></div>
		<div class="submitdiv"> <input type="submit" value="开通APP" ></div>
	</form>
</div>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/public.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/openapp.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/openapp.js"></script>
</body>
</html>
