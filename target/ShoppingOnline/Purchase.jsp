<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="v-on" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en" class="page-home">
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath}/" />
<link href="css/car.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.4.4.min.js"></script>
<title>待付款</title>
</head>
<body>
<div class="name">
	待付款
</div>
<c:forEach items="${goodCarlist}" var="goodcar" varStatus="status">
	<div class="main">

	<img src="images/${goodcar.getGoodsFile()}" width="176" height="176">
		<div class="display">
			品牌：${goodcar.getGoodsType()}${goodcar.getGoodsName()}<br />
			 价格：${goodcar.getGoodsPrice()}RMB<br />
			颜色：${goodcar.getGoodsColor()}<br />
			${goodcar.getGoodsMessage()}

		</div>
		<div class="buy">
		<a href="good/delgoodCar?goodsId=${goodcar.getGoodsId()}&userid=${userid}">删除宝贝</a>
		</div>

		<input type="button" onclick="return add(${status.index})" value="+" class="add"/>
		<input type="text" id="${status.index}" value="1" name="number" class="buy2"/>
		<input type="button" onclick="return del(${status.index})" value="-" class="del"/>

		<input type="submit" value="立即购买" class="buy1" >
		<script type="text/javascript">
            //
			function add(num)
			{//alert(num);
				var txt=document.getElementById(num);
				var a=txt.value;
				if(a>=9) {
					alert('对不起，购买数量不能多于9件');
				}
				else {
					a++;
					txt.value=a;
				}
			}
			function del(num)
			{
				var txt=document.getElementById(num);
				var b=txt.value;
				if(b<=1) {
					alert('对不起，购买数量不能少于0件');
				}
				else {
					b--;
					txt.value=b;
				}
			}
		</script>
		</div>
		
		<hr/>
</c:forEach>

</body>
</html>