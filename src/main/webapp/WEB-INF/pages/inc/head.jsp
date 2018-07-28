<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>AgentSystem</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/public.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/css/main.css">
<!-- ymPrompt弹出框 -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/statics/alertframe/skin/simple_gray/ymPrompt.css" />
<!-- humane提醒库 -->
<link id='theme' rel='stylesheet' href='${pageContext.request.contextPath}/statics/humane/themes/original.css' />
<script src='${pageContext.request.contextPath}/statics/humane/humane.js'></script>


<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/main.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/public.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/alertframe/ymPrompt.js"></script>
	
</head>
<body>
	<div class="head">
		<ul>
			<li><h2>AgentSystem</h2>
			<li class="headfunc">
				<ul>
					<li>欢迎您 ：${loginUser.userName} <a
						id="modifypwdbtna">修改密码</a> <a href="/exit.action">退出</a>
						</li>
				</ul>
			</li>
	</ul>

	</div>
	<!-- 主菜单 -->
	<div id="menu">
		<ul>
			<%-- <s:iterator value="roleFunctions" status="sta">
				<li class="m_line"><img src="/imgs/line1.gif"></li>
				<li id="m_<s:property value="#sta.index+1"/>" class="m_li"  onmouseover="mover(<s:property value="#sta.index+1"/>)"><a href="<s:property value="mainFunction.funcUrl"/>"><s:property value="mainFunction.functionName"/></a></li>
			</s:iterator> --%>
		</ul>
	</div>
	
	<!-- <div id="menu" class="menu">
		<ul>
			<li class="m_line"><img src="/imgs/line1.gif"></li>
			<li id="m_1" class="m_li"><a>代理商管理</a></li>
			<li class="m_line"><img src="/imgs/line1.gif"></li>
			<li id="m_4" class="m_li" onmouseover="mover(4)"><a>系统管理</a></li>
			<li class="m_line"><img src="/imgs/line1.gif"></li>
			<li id="m_5" class="m_li" onmouseover="mover(5)"><a>系统配置管理</a></li>
		</ul>
	</div> -->
	<!-- 子菜单 -->
	<div class="subbox">
		<ul class="smenu">
		<%-- 	<s:iterator value="roleFunctions" status="sta">
				<li id="s_<s:property value="#sta.index+1"/>" class="s_li">
					<s:iterator value="subFunctions">
						<a href="<s:property value="funcUrl"/>"><s:property value="functionName"/></a>
					</s:iterator>
				</li>
			</s:iterator> --%>
		
			<!-- <li id="s_1" class="s_li">	
				
				 
			</li>
			<li id="s_4" class="s_li">
				<a href="#">财务管理</a>
				<a href="/rolelist.action">角色管理</a>
				<a href="/permission.action">角色权限配置</a>
				<a href="/userlist.action">用户管理</a>
				<a href="#">关键词审核</a>
				
				 
			</li>
			<li id="s_5" class="s_li">
				<a href="/caiwutype.action">财务类型</a>
				<a href="/servicetype.action"> 服务类型</a>
				 <a href="/serviceyears.action">服务年限</a>
				<a href="/appurl.action">APP地址</a>
				<a href="/customtype.action"> 客户类型</a>
				 <a href="/cardtype.action">证件类型</a>
				<a href="/youhuitype.action">优惠类型</a>
				 
			</li> -->
		</ul>
	
	</div>


	<!-- 修改密码 -->
	<div id="modifydiv" class="modifydiv">

		<div class="modifTop">修改密码</div>
		<div class="modifyPasswordContent">
			<ul>
				<li>请输入原密码：<input type="password" id="oldpwdtext"> <span
					id="oldpwdtexttip">您本次登录的密码</span>
				<li>请输入新密码：<input type="password" id="newpwd"><span
					id="newpwdtip">新密码不少于6个字符</span>
				<li>请确认原密码：<input type="password" id="newpwd2"><span
					id="newpwd2tip">新密码不少于6个字符</span>
				<li><input type="button" id="modifypwdbtn" value="确认修改密码">
					<input id="modifypwdcancel" type="button" value="取消">
			</ul>

		</div>
		<div></div>
	</div>