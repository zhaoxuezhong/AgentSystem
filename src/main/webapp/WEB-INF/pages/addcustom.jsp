<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ <a href="agent/customs/customlist">代理商客户管理</a>\ 添加客户信息
</div>
<div class="container">
	<form id="cform" action="agent/customs/addsavecustom" method="post">
		<div class="subtitle">基本信息</div>
		<div class="info1">
			<ul>
				<li>企业名称:<input type="text" name="customName"
					id="customname">
				</li>
				<li>企业类型: 
					<select id="customtype" name="customType">
						<option value="">--请选择--</option>
						<c:forEach items="${customTypeList}" var="cuatom">
							<option value="${cuatom.configTypeValue}">${cuatom.configTypeName}</option>
						</c:forEach>
					</select>
					<input type="hidden" id="customtypename"
					name="customTypeName">
				</li>
				<li>企业主页:<input type="text" name="siteUrl">
				</li>
				<li>状态:
				<select name="customStatus">
					<option value="">--请选择--</option>
					<option value="1">启用</option>
					<option value="0">停用</option>
				</select></li>
			</ul>
		</div>

		<div class="subtitle">门户信息</div>
		<div class="info2">
			<ul>
				<li>法人代表:<input type="text" name="bossName">
				</li>
				<li>注册日期:<input type="text" name="regDatetime"
					class="Wdate" onclick="WdatePicker()" id="regdate">
				</li>
				<li>证件类型: <input type="hidden" name="cardTypeName"
					id="customcardtypename">
					<select id="customcardtype" name="cardType">
						<option value="">--请选择--</option>
						<c:forEach items="${cardTypeList}" var="card">
							<option value="${card.configTypeValue}">${card.configTypeName}</option>
						</c:forEach>
					</select>
				<li>证件号码:<input type="text" name="cardNum" id="cardnum">
				</li>
				<li>国家:<input type="text" name="country">
				</li>
				<li>省份:
					<select  id="customprovince" name="province" >
						<option value="">--请选择--</option>
						<c:forEach items="${provinceList}" var="pro">
							<option value="${pro.provinceId}">${pro.province}</option>
						</c:forEach>
					</select>
				</li>
				<li>公司传真:<input type="text" name="companyFax">
				</li>
				<li>城市: <select name="city" id="customcity">
						<option value="">--请选择--</option>
				</select></li>
				<li>公司电话:<input type="text" name="companyTel">
				</li>
				<li>区: <select name="area" id="customarea">
						<option value="">--请选择--</option>
				</select></li>
				<li>公司地址:<input type="text" name="companyAddress">
				</li>
			</ul>
			<div class="clear"></div>
			<div>
				备注:
				<textarea name="memo" rows="2" cols="50"></textarea>
			</div>
		</div>
		<div class="clear"></div>
		<div class="subtitle">
			<a href="javascript:void(0);" id="addcontact">添加一个联系人</a>
		</div>
		<div class="info3">
			<table>
				<thead>
					<tr>
						<th>姓名</th>
						<th>电话</th>
						<th>传真</th>
						<th>邮箱</th>
						<th>职务</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="addtr">
				</tbody>
			</table>
		</div>
		<div class="goback">
			<input type="button" value="保存" onclick="checksave();"> <input
				type="button" value="返回" onclick="history.go(-1);">
		</div>
	</form>

</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/addcustom.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/addcustom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/medire/WdatePicker.js"></script>
</body>
</html>