<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="addAppTitle">
	<h2>
	<font size="2"> 为${keywords.keywords }续费</font>
	<font color="red">
		【当前账户余额：￥<span id="accountspan" data-money='<fmt:formatNumber value="${account.money}" pattern="#00.0#"/>'>${account.money}</span>】
	</font>
	</h2>
</div>
<div class="formdiv">
	<ul>
			<li>客户名称: <input type="text" id="customname" class="customname"
				readonly="readonly" value="${keywords.customName}"></li>
			<li>关键词: <input type="text" id="keyword" class="keyword" value="${keywords.keywords}" readonly="readonly">
				</li>
			<li>服务类别:
				<select id="servicetype">
					<c:forEach items="${serviceTypeList}" var="service">
						<option value="${service.configTypeValue}" data-price="${service.configValue}">${service.configTypeName }</option>
					</c:forEach>
				</select>
			</li>
			<li>服务年限: <select id="serviceyear">
					<option value="" selected="selected">--请选择--</option>
					<option value="1">1年</option>
					<option value="2">2年</option>
					<option value="3">3年</option>
					<option value="4">4年</option>
					<option value="5">5年</option>
					<option value="6">6年</option>
					<option value="7">7年</option>
					<option value="8">8年</option>
					<option value="9">9年</option>
					<option value="10">10年</option>
			</select></li>
			<li>价格: <input class="price" id="price" type="text"
				readonly="readonly"></li>
			<li><input type="button" id="submitkeyword" value="续费提交">
			<input type="hidden" id="kid" value="${keywords.id}">
			</li>
		</ul>
</div>
<script type="text/javascript">
	var path="${pageContext.request.contextPath}/";
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/public.css">
<!-- humane提醒库 -->
<link id='theme' rel='stylesheet' href='${pageContext.request.contextPath}/statics/humane/themes/original.css' />
<script src='${pageContext.request.contextPath}/statics/humane/humane.js'></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/xufei.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/xufei.js"></script>
</body>
</html>
