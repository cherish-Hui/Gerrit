<%@ page language="java"  import="java.util.*" import="model.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<head>
<title>编辑用户状态</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/static/css/after/adminStyle.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/static/js/after/jquery.js"></script>
</head>
<%
	User user=(User)request.getAttribute("user");
          
      %>
      
<body>
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><img alt="会员列表" src="${pageContext.request.contextPath}/static/img/after/user_01.png"><em>编辑用户状态</em></span>
  </div>
  <form action="UpDateUserStateServlet" method="post">
  <table class="list-style">
   <tr>
    <td style="width:15%;text-align:right;">编号：</td>
    <td><input type="text"  name="id" class="textBox length-middle" value="${requestScope.user.user_id}" readonly="true"/></td>
   </tr>
   
   <tr>
    <td style="width:15%;text-align:right;">昵称：</td>
    <td><input type="text" class="textBox length-middle" value="${requestScope.user.username}" readonly="true"/></td>
   </tr>
   
   <tr>
    <td style="text-align:right;">密码：</td>
    <td><input type="text" class="textBox length-middle" value="${requestScope.user.password}" readonly="true"/></td>
   </tr>
   
   <tr>
    <td style="text-align:right;">姓名：</td>
    <td><input type="text" class="textBox length-middle" value="${requestScope.user.realname}" readonly="true"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">性别：</td>
    <td><input type="text" class="textBox length-short" value="${requestScope.user.sex}" readonly="true"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">出生日期：</td>
    <td>
     <input type="text" class="textBox length-middle" value="${requestScope.user.birthday}" readonly="true"/>
     
    </td>
   </tr>
   <tr>
    <td style="text-align:right;">邮箱：</td>
    <td>
     <input type="text" class="textBox length-long" value="${requestScope.user.email}" readonly="true"/>
     
    </td>
   </tr>

    <td style="text-align:right;">手机：</td>
    <td><input type="text" class="textBox length-middle" value="${requestScope.user.telphone}" readonly="true"/></td>
   </tr>
   <tr>
    <td style="text-align:right;">头像：</td>
    <td><img src="${pageContext.request.contextPath}/static/img/after/${requestScope.user.picture}"width="50" height="50" class="img-circle" /></td>
   </tr>
    <script type="text/javascript">
    $(function(){

        $("#sel  option[value='1'] ").attr("selected",true)

});   
 </script>
   <tr>
    <td style="text-align:right;">状态：</td>
    <td>
    <select id ="sel" class="inline-select" name="state" >
     <option value="2" <c:if test='${requestScope.user.state==null}'> selected="selected" </c:if> >请选择</option>
     <option value="0" <c:if test='${requestScope.user.state=="0"}'> selected="selected" </c:if> >失效</option>
     <option value="1" <c:if test='${requestScope.user.state=="1"}'> selected="selected" </c:if> >正在使用</option>
    </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="更新保存"/></td>
   </tr>
  </table>
  </form>
 </div>
</body>
<script>
$(document).ready(function() {
  $('.tbBtn').click(function(){
	  
    	alert("修改成功");
 });
 
});
</script>
</html>