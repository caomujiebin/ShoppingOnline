<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="page-home">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">
	<base href="${pageContext.request.contextPath}/" />
<link href="css/purse.css" rel="stylesheet" type="text/css" />
<title>我的钱包</title>
</head>
<body>
<div class="name">我的钱包</div><br/>
<div class="money">

余额<br/><br/>
<div style="color:red;">￥:${restMoney}</div>
</div>
<div class="spend">
消费记录<br/></br>
	<c:forEach items="${goodlist}" var="good">
<div style="color:red;">商品：${good.getGoodsName()}<br/>
-￥：${good.getGoodsPrice()}<br/>购买时间：${good.getGoodsTime()}</div>
		</br>
	</c:forEach>

</div>
</body>
</html>