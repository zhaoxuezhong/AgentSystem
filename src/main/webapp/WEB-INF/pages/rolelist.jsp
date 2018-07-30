<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	系统管理\ <a href="">角色管理</a>
</div>
<div class="container">
	<!-- 添加面板 -->
	<div id="addRoleDiv" class="addRoleDivClass addback">
	<form>
		<ul>
			<li class="lititle"><br>添加角色信息
			<li>角色名称:<input type="text" id="a_roleName" name="roleName"></li>
			<li>是否启用:
				<select id="a_isStart" name="isStart">
					<option value="1" selected>启用</option>
					<option value="0">停用</option>
				</select>
				
				<input id="addRoleSubmit" type="button" value="保存"> 
				<input id="addCancel" type="reset" value="取消"> 
			</li>
		</ul>
		</form>
	</div>
	<!-- 修改面板 -->
	<div id="modifyRoleDiv" class="addRoleDivClass modifyback">
		<ul>
			<li class="lititle"><br>修改角色信息
			<input type="hidden" id="m_roleId" />
			<li>角色名称:<input type="text" id="m_roleName" name="roleName"></li>
			<li>是否启用:
				<select id="m_isStart" name="isStart">
					<option value="1" selected>启用</option>
					<option value="0">停用</option>
				</select>
				
				<input id="modifyRoleSubmit" type="button" value="保存"> 
				<input id="modifyCancel" type="reset" value="取消"> 
			</li>
		</ul>
	</div>
	<div class="addRoleDiv">
		<input id="addRole" type="button" value="新增角色">
	</div>
	<!-- 角色列表 -->
	<table>
		<thead>
			<tr>
				<th>角色名称</th>
				<th>创建时间</th>
				<th>是否启用</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${roleList}" var="role">
			<tr>
				<td>${role.roleName}</td>
				<td>${role.creationTime}</td>
				<td>${role.isStart==1?'启用':'停用'}</td>
				<td>
					<span class="modifyRole"
								roleid="${role.id}"
								rolename="${role.roleName}"
								isstart="${role.isStart}"> 修改</span> 
								| <span
								class="deleteRole" 
								roleid="${role.id}"
								rolename="${role.roleName}"> 删除</span>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/rolelist.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/rolelist.js"></script>
</body>
</html>