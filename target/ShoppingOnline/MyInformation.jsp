<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" class="page-home">
<head>
<meta charset="utf-8">
<base href="${pageContext.request.contextPath}/" />
<meta http-equiv="Content-Type" content="text/html">
<link href="css/information.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-3.3.1.js"></script>
<title>个人信息</title>
</head>
<body>
	<div class="name">个人信息</div>
	<form>
		<p class="font" style="margin-left:544px;font-size:35px;">用户Id:${userlist.get(0).getId()}</p>
			<p class="font" style="margin-left:544px;font-size:35px;">用户名:${userlist.get(0).getUsername()}</p>
			<p class="font"style="margin-left:580px;font-size:35px;">地址:${userlist.get(0).getAddress()}</p>
			<p class="font"style="margin-left:580px;font-size:35px;">电话:${userlist.get(0).getTelphone()}</p>
			</form>
	<div>

		<form action="good/payforMoney" method="post">
			<input style="display: none" name="goodsCount" value="${goodsCount}"/>
			<input style="display: none" name="userid" value="${userid}"/>
			<input style="display: none" name="password" value="${userlist.get(0).getPassword()}"/>
			<input style="display: none" id="goodsid" name="goodid" value="${goodsId}"/><br/>
			<input style="display: none" name="goodsPrice" value="${goodsPrice}"/><br/>
			<input style="display: none" name="lotteryMoney" value="${lotteryMoney}"/><br/>
			<input id="lottery" name="lottery" style="margin-left:507px;font-size:35px;" value="${LotteryMessage}"></input>
			<span id="payforPassword" style="margin-left:507px;font-size:35px;">支付密码：</span>
			<input id="inputPassword" name="inputPassword" type="password" class="inputPassword" value=""/></br>
		   <p class="error">${Error}</p>
	        <input id="payfor" type="submit" class="payfor" value="确定付款"/>
		</form>
	</div>
<script type="text/javascript">
	window.onload = function () {
		//如果只是查看个人信息，则不显示付款信息，只有购买时才显示付款信息
		var text = $("#goodsid").value;
		if(text==""){
			$('#payfor').css("display","none");
			$('#payforPassword').css("display","none");
			$('#inputPassword').css("display","none");
			$('#lottery').css("display","none");
		}
	}
</script>
</body>
</html>