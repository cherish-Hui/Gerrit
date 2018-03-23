<%@page import="model.CarCar"%>
<%@page import="model.ShowList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="/DtShopping/static/css/font/mycss5.css" />
<link rel="stylesheet" href="/DtShopping/static/css/font/bootstrap1.css" />
<script type="text/javascript"
	src="/DtShopping/static/js/font/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="/DtShopping/static/js/font/bootstrap.min.js"></script>
<script type="text/javascript" src="/DtShopping/static/js/font/main.js"></script>

</head>


<body>
	
	<%@ include file="Header.jsp"%>
<div class="adress">
					<div class="tttile">
						<h2>在线支付</h2>
					</div>
					<div class="kong">
						<h3>提交订单成功</h3>
						<div class="iii"><span>你此次支付的金额为：￥<label class="hhhas">${mon}</label></span></div>
						<div class="iii"><span>请点击下面的支付方式去支付</span></div>
						<ul class="paypay">
							<li class="pay1"><img src="/DtShopping/static/img/fontlogin/alipay@2x.png" /></li>
							<li ><img src="/DtShopping/static/img/fontlogin/weixinpay@2x.png"/></li>
							<li ><img src="/DtShopping/static/img/fontlogin/pay-boc@2x.png" /></li>
							<li ><img src="/DtShopping/static/img/fontlogin/pay-ccb@2x.png" /></li>
							<li class="wqes"  ><img src="/DtShopping/static/img/fontlogin/yipay.png" /></li>
						</ul>
					</div>
				</div>
		<%@ include file="Footer.jsp"%>
</body>

	<script type="text/javascript">
	$(".wqes").mousedown(function(){
		window.location.href='/DtShopping/order/yeepay.jhtml';
	});
</script>
	
</html>