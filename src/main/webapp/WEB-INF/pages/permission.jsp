<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include><div class="mbxnav">
	系统管理\<a href="javascript:void(0)">角色权限管理</a>
</div>
<div class="container">
	<ul>
		<!-- 角色列表 -->
		<li class="jslist">
			<ul>
				<c:forEach items="${roleList}" var="role">
					<li>
						<div id="sidebar">
							<a target="funclist" href="agent/role/funclist?roleId=${role.id}">${role.roleName}</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</li>
		<!-- 功能 列表 -->
		<li class="iframeli"><iframe id="funclist" name="funclist"
				width="100%" height="99%" src=""></iframe></li>
	</ul>

</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/statics/css/permission.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/statics/js/permission.js"></script>
</body>
</html>
