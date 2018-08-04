<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<h3>功能列表</h3>
	<!-- 操作按钮 -->
	<div class="btndiv">
		<input type="hidden" id="roleid" value="${roleId}">
		<input id="saverolefunc" type="button" value="保存" /> <input
			id="huanyuan" type="button" value="还原" />
	</div>
	<!-- 功能表格 -->
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" id="cball">全选 /全不选</th>
				<th>功能名称</th>
				<th>功能URL</th>
				<th>创建时间</th>
				<th>是否启用</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${funclist}" var="fc">
				 <tr>
					<td>
						<input type="checkbox" class="cb ${fc.checked==1?'huanyuan':'' }" ${fc.checked==1?'checked':'' } 
						 value="${fc.id}">
					</td>
					<td>${fc.functionName}
					</td>
					<td>${fc.funcUrl}
					</td>
					<td>${fc.creationTime}
					</td>
					<td>${fc.isStart==1?'启用':'停用'}
				</tr>
				 
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
	var path="${pageContext.request.contextPath}/";
</script>
<!-- humane提醒库 -->
<link id='theme' rel='stylesheet' href='${pageContext.request.contextPath}/statics/humane/themes/original.css' />
<script src='${pageContext.request.contextPath}/statics/humane/humane.js'></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/public.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/functionlist.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/functionlist.js"></script>
</body>
</html>
