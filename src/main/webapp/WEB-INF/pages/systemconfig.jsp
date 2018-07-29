<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	系统配置管理\
	<c:if test="${configType==1}">
		<a href="agent/systemconfig/list/1">财务类型</a>
	</c:if>
	<c:if test="${configType==2}">
		<a href="agent/systemconfig/list/2">服务类型</a>
	</c:if>
	<c:if test="${configType==3}">
		<a href="agent/systemconfig/list/3">服务年限</a>
	</c:if>
	<c:if test="${configType==4}">
		<a href="agent/systemconfig/list/4">APP地址</a>
	</c:if>
	<c:if test="${configType==5}">
		<a href="agent/systemconfig/list/5">客户类型</a>
	</c:if>
	<c:if test="${configType==6}">
		<a href="agent/systemconfig/list/6">证件类型</a>
	</c:if>
	<c:if test="${configType==7}">
		<a href="agent/systemconfig/list/7">优惠类型</a>
	</c:if>
</div>
<div class="container">

	<!-- 添加输入界面 -->
	<div class="modifySystemdiv addback" id="addSystemdiv">
		<ul>
			<li class="lititle">你正在进行添加操作<input type="hidden"
				id="addConfigType" value="${configType}">
			</li>

			<li>类型名称：<input type="text" id="addConfigName"></li>

			<c:if test="${configType==7||configType==2 }">
				<li>配置项值:<input type="text" id="addConfigValue">
				</li>
			</c:if>

			<li>是否启用:<select id="addIsStartSelect">
					<option value="1" selected="selected">启用</option>
					<option value="0">停用</option>
			</select> <input type="button" id="addSystemConfigBtn" value="保存"> <input
				type="button" id="cancleAddSystemConfigBtn" value="取消">
		</ul>
	</div>
	<!-- 修改界面 -->
	<div class="modifySystemDiv modifyback" id="modifySystemdiv">
		<ul>
			<li class="lititle">你正在修改操作 <input type="hidden" id="sid" /> <!-- 配置项的主键ID -->
				<input type="hidden" id="modifyConfigType"
				value="${configType}">
			</li>

			<li>类型名称：<input type="text" id="modifyConfigName"></li>
			<c:if test="${configType==7||configType==2 }">
				<li>配置项值:<input type="text" id="modifyConfigValue">
				</li>
			</c:if>
			<li>是否启用:<select id="modifyIsStartSelect">
					<option value="1" selected="selected">启用</option>
					<option value="0">停用</option>
			</select> <input type="button" id="modifySystemConfigBtn" value="保存">
				<input type="button" id="cancleModifySystemConfigBtn" value="取消">
		</ul>
	</div>
	<c:choose>
		<c:when
			test="${configType==1||configType==2||configType==5||configType==6||configType==7}">
			<!-- 列表 -->
			<div>
				<!-- 添加按钮 -->
				<div class="addSystemConfig">
					<input type="button" id="addsystemconfig" value="添加" />
				</div>
				<!-- 列表 -->
				<table>
					<thead>
						<tr>
							<th>序号</th>
							<th>配置类型</th>
							<c:if test="${configType==2||configType==7 }">
								<th>配置数值</th>
							</c:if>
							<th>是否启用</th>

							<th>操作</th>
					</thead>
					<tbody>
						<c:forEach items="${systemConfigList}" var="config" varStatus="st">
							<tr>
								<td>${st.index+1}</td>
								<td>${config.configTypeName}</td>
								<c:if test="${config.configType==2 || config.configType==7}">
									<td>${config.configValue}</td>
								</c:if>
								<td><c:if test="${config.isStart==1}">启用</c:if> <c:if
										test="${config.isStart==0}">停用</c:if></td>
								<td><span class="modifySystemBtn" sid="${config.id}"
									configtype="${config.configType}"
									sname="${config.configTypeName}" svalue="${config.configValue}"
									isstart="${config.isStart}"> 修改</span> <span
									class="deleteSystemBtn" sid="${config.id}"
									sname="${config.configTypeName}"> 删除</span></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</c:when>
		<c:otherwise>
			<!-- simple div configType:3|4-->
			<div class="simpleconfig">
				<h3>
					<c:if test="${configType==3 }">
				服务年限管理-填写最大的服务年限
			</c:if>
					<c:if test="${configType==4 }">
				APP URL管理-填写制作APP的系统的URL地址
			</c:if>
				</h3>
				<input type="hidden" id="configType"
					value="${configType}">
				<!-- 服务年限 configType=3 -->

				<input type="hidden" id="simpleConfigId"
					value="${systemConfigList[0].id}">
				<ul>
					<li>配置名称：<input type="text" id="simpleTypeName"
						value="${systemConfigList[0].configTypeName}">
					</li>
					<li>配置数值：<input type="text" id="simpleConfigValue"
						value="${systemConfigList[0].configValue}">
					</li>

					<li><input type="button" id="simpleBtn" value="保存"></li>
				</ul>
			</div>
		</c:otherwise>
	</c:choose>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/systemconfig.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/systemconfig.js"></script>
</body>
</html>