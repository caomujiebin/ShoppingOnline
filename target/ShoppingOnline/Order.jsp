<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" class="page-home">
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html">
	<base href="${pageContext.request.contextPath}/" />
	<link href="css/order.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-3.3.1.js"></script>
	<title>我的订单</title>
</head>
<body>
<div class="name">
	我的订单
</div>
<c:forEach items="${orderlist}" var="order">
	<div class="main">

		<img src="images/${order.getGoodsFile()}" width="176" height="176">
		<div class="display">
			品牌：${order.getGoodsType()}
				${order.getGoodsName()}<br />
			价格：${order.getGoodsPrice()}RMB<br />
			颜色：${order.getGoodsColor()}<br />
				${order.getGoodsMessage()}<br />
				${order.getGoodsTime()}<br />
			个数：${order.getNumber()}

		</div>

		<div class="buy1">
			<a>${order.getGoodsStatus()}</a>
		</div>
		<div class="buy">

			<a href="orders/deleteOrder?goodsId=${order.getGoodsId()}&userid=${userid}" onclick="return delOrder()">删除订单</a>
		</div>
	</div><hr/>
</c:forEach>
<script>
	//删除订单之前确认
	function delOrder() {
		if(confirm("真的要删除吗?"))
			return true;
		else
			return false;
	}
</script>
</body>
</html>