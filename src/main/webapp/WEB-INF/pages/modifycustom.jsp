<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include><div class="mbxnav">
	<!-- 导航 -->
	代理商管理\ <a href="/customlist.action">代理商客户管理</a>\ 修改客户信息
</div>
<div class="container">
	<form id="cform" action="/modifysavecustom.action" method="post">
		<input type="hidden" name="custom.id" value="${custom.id}">
		<div class="subtitle">基本信息</div>
		<div class="info1">
			<ul>
				<li>企业名称:<input type="text" name="custom.customName"
					id="customname" value="${custom.customName}">
				</li>
				<li>企业类型: <s:select  value="custom.customType"
						list="customTypeList" id="customtype"
						name="custom.customType" listKey="configTypeValue"
						listValue="configTypeName" headerKey="" headerValue="--请选择--"></s:select>

					<input type="hidden" id="customtypename" value="${custom.customTypeName}"
					name="custom.customTypeName">
				</li>
				<li>企业主页:<input type="text" name="custom.siteUrl" value="${custom.siteUrl}">
				</li>
				<li>状态: <s:select name="custom.customStatus" value="custom.customStatus"
						list="#{'1':'启用','0':'停用'}"></s:select></li>
			</ul>
		</div>

		<div class="subtitle">门户信息</div>
		<div class="info2">
			<ul>
				<li>法人代表:<input type="text" name="custom.bossName" value="${custom.bossName}">
				</li>
				<li>注册日期:<input type="text" name="custom.regDatetime" value="${custom.regDatetime}"
					class="Wdate" onclick="WdatePicker()" id="regdate">
				</li>
				<li>证件类型: <input type="hidden" name="custom.cardTypeName" value="${custom.cardTypeName}"
					id="customcardtypename"> 
					<s:select id="customcardtype" value="custom.cardType"
						name="custom.cardType" list="cardTypeList"
						listKey="configTypeValue" listValue="configTypeName" headerKey=""
						headerValue="--请选择--"></s:select></li>
				<li>证件号码:<input type="text" name="custom.cardNum" id="cardnum" value="${custom.cardNum}">
				</li>
				<li>国家:<input type="text" name="custom.country" value="${custom.country}">
				</li>
				<li>省份: <s:select id="customprovince" name="custom.province" value="custom.province"
						list="provinceList" listKey="provinceID" listValue="province"
						headerKey="" headerValue="--请选择--"></s:select></li>
				<li>公司传真:<input type="text" name="custom.companyFax" value="${custom.companyFax}">
				</li>
				<li>城市: 
					<input type="hidden" id="city" value="${custom.city}"/>
				<select name="custom.city" id="customcity" >
						<option value="">--请选择--</option>
				</select></li>
				<li>公司电话:<input type="text" name="custom.companyTel" value="${custom.companyTel}">
				</li>
				<li>区: 
					<input type="hidden" id="area" value="${custom.area}"/>
					<select name="custom.area" id="customarea">
						<option value="">--请选择--</option>
				</select></li>
				<li>公司地址:<input type="text" name="custom.companyAddress" value="${custom.companyAddress}">
				</li>
			</ul>
			<div class="clear"></div>
			<div>
				备注:
				<textarea name="custom.memo" rows="2" cols="50" value="${custom.memo}"></textarea>
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
					<input type="hidden" id="contactcount" value="<s:property value='contactList.size()'/>">
					<s:iterator value="contactList" status="st">
						<tr>
						<td><input type='text' name='contactList[${st.index}].contactName' value="${contactName }"></td>
						<td><input type='text' name='contactList[${st.index}].contactTel'  value="${contactTel}"></td>
						<td><input type='text' name='contactList[${st.index}].contactFax'  value="${contactFax}"></td>
						<td><input type='text' name='contactList[${st.index}].contactEmail'  value="${contactEmail}"></td>
						<td><input type='text' name='contactList[${st.index}].contactRole'  value="${contactRole}"></td>
						<td  onclick='delTr(this)' style="cursor:hand">删除</td></tr>
						</tr>
					</s:iterator>
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
<link rel="stylesheet" type="text/css" href="/css/modifycustom.css">
<script type="text/javascript" src="/js/modifycustom.js"></script>
<script type="text/javascript" src="/medire/WdatePicker.js"></script>
</body>
</html>
<s:debug></s:debug>