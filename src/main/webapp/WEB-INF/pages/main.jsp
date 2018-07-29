<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="inc/head.jsp"></jsp:include>
<div class="mbxnav">
代理商管理\当前账户信息
</div>
<div class="container">
	<div class="userInfo">
		<ul>
			<li><b>您好！${loginUser.userName}</b>			
				您上次登录时间
				<fmt:formatDate value="${loginUser.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				
			</li>
			<li>
			<!-- 显示Account对象的属性 -->
				您当前账户 余额:
				<c:choose>
					<c:when test="${empty account}">
						对不起,您没有开户
					</c:when>
					<c:otherwise>
						${account.money}
					</c:otherwise>
				</c:choose>
				<a href="${pageContext.request.contextPath}/agent/account/accountdetail">查看账户明细</a>
			</li>
		</ul>
	
	</div>

</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
