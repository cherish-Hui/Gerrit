<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<title>管理员列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/static/css/after/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/static/js/after/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/after/public.js"></script>
</head>
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><img alt="管理员列表" src="${pageContext.request.contextPath}/static/img/after/管理员.png"> <em>管理员列表</em></span>
    <c:set var="prive" value="${permission_level}"></c:set>
    <c:if test="${prive==1}">
    	<span class="modular fr"><a href="${pageContext.request.contextPath}/AfterJsp/add_manager.jsp" class="pt-link-btn">+添加管理员</a></span>
    </c:if>
    
  </div>
  <table class="list-style Interlaced">
   <tr>
   	<th>管理员ID</th>
   	<th>管理员头像</th>
    <th>管理员账号</th>
    <th>电子邮箱地址</th>
    <th>管理员姓名</th>
    <th>加入时间</th>
    <th>权限级别</th>
    <th>账号状态</th>
    <th>最后登陆时间</th>
    <th>操作</th>
   </tr>
   <c:forEach items="${managerlist}" var="Manager">
   <tr>
    <td class="center">${Manager.managerid}</td>
    <td class="center"><img alt="头像" src="${pageContext.request.contextPath}/static/img/mainimg/${Manager.photo}" style="height: 40px;width: 40px"></td>
    <td class="center">${Manager.username}</td>
    <td class="center">${Manager.email}</td>
    <td class="center">${Manager.realname}</td>
    <td class="center">${Manager.boonday}</td>
    <td class="center">
    	<c:choose>
    		<c:when test="${Manager.permission==1}">超级管理员</c:when>
    		<c:when test="${Manager.permission==2}">订单管理员</c:when>
    		<c:when test="${Manager.permission==3}">商品管理员</c:when>
    		<c:when test="${Manager.permission==4}">用户管理员</c:when>
    		<c:otherwise>未知</c:otherwise>
    	</c:choose>
    </td>
    <td class="center">
    	<c:choose>
    		<c:when test="${Manager.state==1}">正常</c:when>
    		<c:when test="${Manager.state==0}">冻结</c:when>
    		<c:otherwise>未知</c:otherwise>
    	</c:choose>
    </td>
    <td class="center">${Manager.lastlogen}</td>
    <td class="center">
     <a href="${pageContext.request.contextPath}/queryManagerInfoServlet?managerid=${Manager.managerid}&permission=${permission_level}" title="编辑" ><img src="${pageContext.request.contextPath}/static/img/after/icon_edit.gif"/></a>
    </td>
   </tr>
   </c:forEach>
  </table>
 </div>
</body>
</html>