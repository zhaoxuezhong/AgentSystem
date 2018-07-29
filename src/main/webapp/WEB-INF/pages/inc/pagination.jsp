<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:if test="${not empty pager and pager.totalCount gt 0}">
	<div class="pagination pagination-centered">
	<ul>
		<c:if test="${pager.pageIndex > 1}">
			<li><a class="page-btn"
				href="javascript:page_nav(document.forms[0],1);">首页</a></li>
			<li><a class="page-btn"
				href="javascript:page_nav(document.forms[0],${pager.pageIndex-1});">上一页</a></li>
		</c:if>
		<c:set var="end"
			value="${pager.pageIndex<3?5:pager.pageIndex+3}"></c:set>
		<c:set var="begin"
			value="${pager.pageIndex<3?1:pager.pageIndex-2}"></c:set>
		<c:forEach begin="${begin}"
			end="${end>pager.pageTotalCount?pager.pageTotalCount:end}" var="i">
			<li class="${pager.pageIndex==i?'active':''}"><a class="page-btn" id="pageIndex${i}"
				href="javascript:page_nav(document.forms[0],${i})">${i}</a></li>
		</c:forEach>
		<c:if test="${pager.pageIndex < pager.pageTotalCount }">
			<li><a class="page-btn"
				href="javascript:page_nav(document.forms[0],${pager.pageIndex+1 });">下一页</a></li>
			<li><a class="page-btn"
				href="javascript:page_nav(document.forms[0],${pager.pageTotalCount });">最后一页</a></li>
		</c:if>
	</ul>
</div>
	
</c:if>

<script type="text/javascript">
	function page_nav(frm,num){
		if(frm==null||frm==undefined){
			location.href=path+"/${pager.url}&pageIndex="+num;
		}else{
			frm.pageIndex.value = num;
			frm.submit();
		}
	}
</script>