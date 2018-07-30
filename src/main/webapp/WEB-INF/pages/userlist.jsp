<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
	<!-- 导航 -->
	系统管理\ <a href="javasrcipt:void(0)">用户管理</a>
</div>
<div class="container">

	<!-- 添加面板 -->
	<div id="addUserDiv" class="addUserDivClass addback">

		<ul>
			<li class="lititle"><br>添加代理商用户信息
			<li>登录账号:<input type="text" id="a_userCode" name="userCode"><span>*</span>
			</li>
			<li>登录名称 :<input type="text" id="a_userName"
				name="userName"><span>*</span></li>
			<li>登录 密码 :<input type="password" id="a_userPassword"
				name="userPassword" value="123456"><span>*默认初始密码为123456</span>
			</li>
			<li>角色: 
					<select id="a_roleId" name="roleId" >
				<c:forEach items="${roleList}" var="role">
					<option value="${role.id }">${role.roleName }</option>
				</c:forEach>
			</select>
			</li>
			<li>是否启用: <select id="a_isStart" name="isStart">
					<option value="1" selected>启用</option>
					<option value="0">停用</option>
			</select> <span>*</span> <input id="addUserSubmit" type="button" value="保存">
				<input id="addCancel" type="reset" value="取消">
			</li>
		</ul>

	</div>
	<!-- 修改面板 -->
	<div id="modifyUserDiv" class="addUserDivClass modifyback">
		<ul>
			<li class="lititle"><br>修改代理商用户信息 <input type="hidden"
				id="m_userId" name="id" />
			<li>登录账号:<input type="text" id="m_userCode" name="userCode"><span>*</span>
			</li>
			<li>登录名称 :<input type="text" id="m_userName"
				name="userName"><span>*</span></li>
			<li>登录 密码 :<input type="password" id="m_userPassword"
				name="userPassword" value="123456"><span>*默认初始密码为123456</span>
			</li>
			<li>角色:
			<select id="m_roleId" name="roleId" >
				<c:forEach items="${roleList}" var="role">
					<option value="${role.id }">${role.roleName }</option>
				</c:forEach>
			</select>
			</li>
			<li>是否启用: <select id="m_isStart" name="isStart">
					<option value="">--请选择--</option>
					<option value="1" selected>启用</option>
					<option value="0">停用</option>
			</select> <span>*</span> <input id="modifyUserSubmit" type="button" value="保存">
				<input id="modifyCancel" type="reset" value="取消">
			</li>
		</ul>
	</div>

	<div class="addUserDiv">
		<input id="addUser" type="button" value="新增用户">
	</div>


	<!-- 用户搜索 -->
	<div>
		<form action="agent/user/userList.html" method="post">
			用户名称:<input type="text" name="userName"
				value="${asUser.userName}"> 角色:
			<select name="roleId" >
			<option value="">--请选择--</option>
				<c:forEach items="${roleList}" var="role">
					<option value="${role.id }" ${role.id==asUser.roleId?'selected':''}>${role.roleName }</option>
				</c:forEach>
			</select>
			是否启用:
			<select name="isStart">
			<option value="">--请选择--</option>
					<option value="1" ${asUser.isStart==1?'selected':''}>启用</option>
				<option value="0" ${asUser.isStart==0?'selected':''}>未启用</option>
			</select>
			<input type="submit" value="查询">
			<input type="hidden" name="pageIndex" value="1" />
		</form>
	</div>
	<!-- 用户列表 -->
	<table>
		<thead>
			<tr>
				<th>登录账号</th>
				<th>用户名称</th>
				<th>角色</th>
				<th>创建时间</th>
				<th>是否启用</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty userList.list}">
				<tr>
					<td colspan="6">查无数据</td>
					</tr>
			</c:if>
			<c:forEach items="${userList.list}" var="user">
				<tr>
					<td>${user.userCode}</td>
					<td>${user.userName}</td>
					<td>${user.roleName}</td>
					<td>${user.creationTime}
					</td>
					<td>${user.isStart==1?'启用':'停用'}</td>
					<td><span class="modifyUser"
						userid='${user.id}'
						usercode='${user.userCode}'
						username='${user.userName}'
						userpassword='${user.userPassword}'
						isstart='${user.isStart}'
						roleid='${user.roleId}'> 修改</span> | <span
						userid='${user.id}'
						usercode='${user.userCode}'
						roleid='${user.roleId}' class="deleteUser">
							删除</span> | 
							<span><a
							href="javascript:ymPrompt.win('/yfklist.action?id=${user.id}&userCode=${user.userCode}',1000,500,'预付款',null,null,null,true)">预付款</a></span> | 
							<span><a
							href="javascript:ymPrompt.win('/loglist.action?id=${user.id}&userCode=${user.userCode}',1000,500,'LOG日志',null,null,null,true)">LOG日志</a>
					</span></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:set value="${userList}" var="pager"></c:set>
	<%@ include file="inc/pagination.jsp" %>
	<%-- <div class="pagination pagination-centered">
				<ul>
					<li><a
						href="/userlist.action?pager.page=1&uname=<s:property value="uname" />&user.roleId=<s:property value="user.roleId" />&user.isStart=<s:property value="user.isStart"/>">首页</a>
					</li>
					<s:if test="pager.prevPages!=null">
						<s:iterator value="pager.prevPages"  var="num">
							<li><a href="/userlist.action?pager.page=<s:property value="#num"/>&uname=<s:property value="uname" />&user.roleId=<s:property value="user.roleId" />&user.isStart=<s:property value="user.isStart"/>"><s:property value="#num"/></a></li>
						</s:iterator>
					</s:if>
					<li class="active">
						<a href="#"><s:property value="pager.page"/></a>
					</li>
					<s:if test="pager.nextPages!=null">
						<s:iterator value="pager.nextPages" var="num">
							<li><a href="/userlist.action?pager.page=<s:property value="#num"/>&uname=<s:property value="uname" />&user.roleId=<s:property value="user.roleId" />&user.isStart=<s:property value="user.isStart"/>"><s:property value="#num"/></a></li>
						
						</s:iterator>
					</s:if>
					<li><a 					
					href="/userlist.action?pager.page=<s:property value="pager.pageCount"/>&uname=<s:property value="uname" />&user.roleId=<s:property value="user.roleId" />&user.isStart=<s:property value="user.isStart"/>">尾页</a>
					</li>
				</ul>
			</div> --%>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/userlist.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/userlist.js"></script>
</body>
</html>