<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ 关键词申请
</div>
<div class="container">
	<div class="searchuserdiv">
		<div>
			搜索账户 :<input type="text" id="searchusertext"> 输入后自动搜索 <font
				color="red">[当前账户余额:￥<span id="accountspan">${account.money}</span>]</font>

			<div id="serachresult" class="searchresult"></div>
		</div>

	</div>
	<div class="formdiv">

		<ul>
			<li>客户名称: <input type="text" id="customname" class="customname"
				readonly="readonly"></li>
			<li>关键词: <input type="text" id="keyword" class="keyword">
				<span id="keywordtip" class="keywordtip"></span></li>
			<li>服务类别: <s:select id="servicetype" list="serviceType"
					headerKey="" headerValue="--请选择--" listKey="id" listValue="configTypeName"></s:select>

			</li>
			<li>服务年限: <select id="serviceyear">
					<option value="" selected="selected">--请选择--</option>
					<s:bean name="org.apache.struts2.util.Counter">
						<s:param name="first" value="1"></s:param>
						<s:param name="last" value="maxServiceYears.configValue"></s:param>
						<s:iterator>
							<option value="<s:property/>">
								<s:property />
							</option>
						</s:iterator>
					</s:bean>
					<s:iterator value="youhuiType">
						<option value="id_<s:property value="id"/>">
							<s:property value="configTypeName" />
						</option>
					</s:iterator>
			</select></li>
			<li>价格: <input class="price" id="price" type="text"
				readonly="readonly"></li>
			<li><input type="button" id="submitkeyword" value="提交申请">
			</li>
		</ul>
	</div>

</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/css/keyword.css">
<script type="text/javascript" src="/js/keywords.js"></script>

</body>
</html>
<s:debug></s:debug>