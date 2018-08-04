<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ 关键词申请
</div>
<div class="container">
	<div class="searchuserdiv">
		<div>
			搜索账户 :<input type="text" id="searchusertext"> 输入后自动搜索
			 <font color="red">[当前账户余额:￥<span id="accountspan" data-money='<fmt:formatNumber value="${account.money}" pattern="#00.0#"/>'>
			 <fmt:formatNumber value="${account.money}" pattern="#,#00.0#"/></span>]</font>
			<div id="serachresult" class="searchresult"></div>
		</div>
	</div>
	<div class="formdiv">
		<ul>
			<li>客户名称: <input type="text" id="customname" class="customname"
				readonly="readonly"></li>
			<li>关键词: <input type="text" id="keyword" class="keyword">
				<span id="keywordtip" class="keywordtip"></span></li>
			<li>服务类别: 
				<select id="servicetype">
					<c:forEach items="${serviceTypeList}" var="service">
						<option value="${service.configTypeValue}" data-price="${service.configValue}">${service.configTypeName}</option>
					</c:forEach>
				</select>
			</li>
			<li>服务年限: <select id="serviceyear">
					<option value="" selected="selected">--请选择--</option>
					<c:forEach items="${youhuiTypeList}" var="youhui">
						<option value="${youhui.configValue}" data-youhui="true">
							${youhui.configTypeName}
						</option>
					</c:forEach>
					<c:forEach var="i" step="1" begin="1" end="${maxServiceYears}">
						<option value="${i}">
								${i}年
							</option>
					</c:forEach>
			</select></li>
			<li>价格: <input class="price" id="price" type="text"
				readonly="readonly"></li>
			<li><input type="button" id="submitkeyword" value="提交申请">
			</li>
		</ul>
	</div>

</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/keyword.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/keywords.js"></script>
</body>
</html>