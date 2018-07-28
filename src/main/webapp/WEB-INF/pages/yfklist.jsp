<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="inc/head.jsp"></jsp:include><div class="mbxnav">
	
	账号[${user.userCode}]代理商预付款</a>
</div>
<div class="container">
	<!-- search box -->
	<div class="searchuserdiv ope">
		<ul>
			<li>
				<form action="/yfklist.action" method="post" onsubmit="return searchyfklistFunc()">
					<input type="hidden" name="user.id" value="${user.id}"/>
					<input type="hidden" name="user.userCode" value="${user.userCode}"/>
					操作类型:<select name="accountDetail.detailType">
					
					<option value="">--请选择--</option>
					<option 	<s:if test="accountDetail.detailType==9999"> selected="selected"</s:if>	
					 value="9999">系统自动-关键词申请扣款</option>
					<option 	<s:if test="accountDetail.detailType==9998"> selected="selected"</s:if>	
					value="9998">系统自动-返回预注册冻结资金</option>
					<option  	<s:if test="accountDetail.detailType==9997"> selected="selected"</s:if>	
					value="9997">系统自动-扣除申请关键词的所有资金</option>
					<option 	<s:if test="accountDetail.detailType==9996"> selected="selected"</s:if>	
					value="9996">系统自动-扣除关键词续费资金</option>
					<s:iterator value="accountConfigList">
						<option
							<s:if test="id==accountDetail.detailType">  selected="selected" </s:if>						
						 	value="<s:property value="id"/>"><s:property value="configTypeName"/></option>
					</s:iterator>
					
					</select> 
					
					
					操作时间: <input type="text" class="Wdate" 
						size="15" onClick="WdatePicker()" id="starttime" readonly="readonly"
						name="accountDetail.startTime" value="<s:date name="accountDetail.startTime" format="yyyy-MM-dd"/>"> 至 <input type="text" class="Wdate"
						size="15" onClick="WdatePicker()" id="endtime"  readonly="readonly"
						name="accountDetail.endTime" value="<s:date name="accountDetail.endTime" format="yyyy-MM-dd"/>"> 
						<input type="submit" value="查询" />

				</form></li>
		</ul>
	</div>
	<!-- accountdetail列表 -->
	<table>
		<thead>
			<tr>
				<th>序号</th>
				<th>账务类型</th>
				<th>账务资金</th>
				<th>账户余额</th>
				<th>备注信息</th>
				<th>明细时间</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="pager.items" status="st">

				<tr>
					<td><s:property value="#st.index+1" />
					</td>
					<td><s:property value="detailTypeName" />
					</td>
					<td>￥<s:property value="money" />
					</td>
					<td>￥<s:property value="accountMoney" />
					</td>
					<td><s:property value="memo" />
					</td>
					<td><s:date name="detailDateTime" format="yyyy-MM-dd HH:mm:ss" />
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>

	<div class="pagination pagination-centered">
		<ul>
			<li><a
				href="/yfklist.action?pager.page=1&user.id=${user.id}&user.userCode=${user.userCode}&accountDetail.detailType=<s:property value="accountDetail.detailType"/>&accountDetail.startTime=<s:property value="accountDetail.startTime"/>&accountDetail.endTime=<s:property value="accountDetail.endTime"/>">首页</a>
			</li>
			<s:if test="pager.prevPages!=null">
				<s:iterator value="pager.prevPages" var="num">
					<li><a href="/yfklist.action?pager.page=<s:property value="#num"/>&user.id=${user.id}&user.userCode=${user.userCode}&accountDetail.detailType=<s:property value="accountDetail.detailType"/>&accountDetail.startTime=<s:property value="accountDetail.startTime"/>&accountDetail.endTime=<s:property value="accountDetail.endTime"/>"><s:property
								value="#num" />
					</a>
					</li>
				</s:iterator>
			</s:if>
			<li class="active"><a href="#"><s:property
						value="pager.page" />
			</a></li>
			<s:if test="pager.nextPages!=null">
				<s:iterator value="pager.nextPages" var="num">
					<li><a href="/yfklist.action?pager.page=<s:property value="#num"/>&user.id=${user.id}&user.userCode=${user.userCode}&accountDetail.detailType=<s:property value="accountDetail.detailType"/>&accountDetail.startTime=<s:property value="accountDetail.startTime"/>&accountDetail.endTime=<s:property value="accountDetail.endTime"/>"><s:property
								value="#num" />
					</a>
					</li>

				</s:iterator>
			</s:if>
			<li><a
				href="/yfklist.action?pager.page=<s:property value="pager.pageCount"/>&user.id=${user.id}&user.userCode=${user.userCode}&accountDetail.detailType=<s:property value="accountDetail.detailType"/>&accountDetail.startTime=<s:property value="accountDetail.startTime"/>&accountDetail.endTime=<s:property value="accountDetail.endTime"/>">尾页</a>
			</li>
		</ul>
	</div>
</div>
<jsp:include page="inc/foot.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="/css/yfk.css">
<script type="text/javascript" src="/js/yfk.js"></script>
<script type="text/javascript" src="/medire/WdatePicker.js"></script>
</body>
</html>
<s:debug></s:debug>