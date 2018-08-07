<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="inc/head.jsp"></jsp:include><div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ <a href="agent/customs/customlist">代理商客户管理</a>\ 修改客户信息
</div>
<div class="container">
	<form id="cform" action="agent/customs/modifysavecustom" method="post">
		<input type="hidden" name="id" value="${custom.id}">
		<div class="subtitle">基本信息</div>
		<div class="info1">
			<ul>
				<li>企业名称:<input type="text" name="customName" id="customname"
					value="${custom.customName}">
				</li>
				<li>企业类型: <select id="customtype" name="customType">
						<option value="">--请选择--</option>
						<c:forEach items="${customTypeList}" var="cuatom">
							<option value="${cuatom.configTypeValue}"
								${custom.customType==cuatom.configTypeValue?'selected':'' }>
								${cuatom.configTypeName}</option>
						</c:forEach>
				</select> <input type="hidden" id="customtypename"
					value="${custom.customTypeName}" name="customTypeName">
				</li>
				<li>企业主页:<input type="text" name="siteUrl"
					value="${custom.siteUrl}">
				</li>
				<li>状态: <select name="customStatus">
						<option value="">--请选择--</option>
						<option value="1" ${custom.customStatus==1?'selected':''}>启用</option>
						<option value="0" ${custom.customStatus==0?'selected':''}>停用</option>
				</select>
				</li>
			</ul>
		</div>

		<div class="subtitle">门户信息</div>
		<div class="info2">
			<ul>
				<li>法人代表:<input type="text" name="bossName"
					value="${custom.bossName}">
				</li>
				<li>注册日期:<input type="text" name="regDatetime"
					value='<fmt:formatDate value="${custom.regDatetime}" pattern="yyyy-MM-dd" />'
					class="Wdate" onclick="WdatePicker()">
				</li>
				<li>证件类型: <input type="hidden" name="cardTypeName"
					value="${custom.cardTypeName}" id="customcardtypename"> <select
					id="customcardtype" name="cardType">
						<option value="">--请选择--</option>
						<c:forEach items="${cardTypeList}" var="card">
							<option value="${card.configTypeValue}"
								${custom.cardType==card.configTypeValue?'selected':'' }>${card.configTypeName}</option>
						</c:forEach>
				</select>
				</li>
				<li>证件号码:<input type="text" name="cardNum" id="cardnum"
					value="${custom.cardNum}">
				</li>
				<li>国家:<input type="text" name="country"
					value="${custom.country}">
				</li>
				<li>省份: <select id="customprovince" name="province">
						<option value="">--请选择--</option>
						<c:forEach items="${provinceList}" var="pro">
							<option value="${pro.provinceId}"
								${custom.province==pro.provinceId?'selected':'' }>${pro.province}</option>
						</c:forEach>
				</select>
				</li>
				<li>公司传真:<input type="text" name="companyFax"
					value="${custom.companyFax}">
				</li>
				<li>城市: <input type="hidden" id="city" value="${custom.city}" />
					<select name="city" id="customcity">
						<option value="">--请选择--</option>
				</select></li>
				<li>公司电话:<input type="text" name="companyTel"
					value="${custom.companyTel}">
				</li>
				<li>区: <input type="hidden" id="area" value="${custom.area}" />
					<select name="area" id="customarea">
						<option value="">--请选择--</option>
				</select></li>
				<li>公司地址:<input type="text" name="companyAddress"
					value="${custom.companyAddress}">
				</li>
			</ul>
			<div class="clear"></div>
			<div>
				备注:
				<textarea name="memo" rows="2" cols="50">${custom.memo}</textarea>
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
					<c:forEach items="${custom.contactList}" var="contact"
						varStatus="st">
						<tr>
							<td><input type="hidden" name="contactList[${st.index}].id"
								value="${contact.id}" /> <input type='text'
								name='contactList[${st.index}].contactName'
								value="${contact.contactName }"></td>
							<td><input type='text'
								name='contactList[${st.index}].contactTel'
								value="${contact.contactTel}"></td>
							<td><input type='text'
								name='contactList[${st.index}].contactFax'
								value="${contact.contactFax}"></td>
							<td><input type='text'
								name='contactList[${st.index}].contactEmail'
								value="${contact.contactEmail}"></td>
							<td><input type='text'
								name='contactList[${st.index}].contactRole'
								value="${contact.contactRole}"></td>
							<td onclick='delTr(this)' style="cursor:hand">删除</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<input type="hidden" id="contactcount" value="${contactList.size()}" />
		</div>

		<div class="goback">
			<input type="button" value="保存" onclick="checksave();"> <input
				type="button" value="返回" onclick="history.go(-1);">
		</div>
	</form>

</div>
<script>
	var error="${error}";
</script>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/modifycustom.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/modifycustom.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/medire/WdatePicker.js"></script>
</body>
</html>