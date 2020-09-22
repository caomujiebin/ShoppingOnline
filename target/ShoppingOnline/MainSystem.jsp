<%@ page import="com.springmvc.entity.User" %>
<%@ page import="com.springmvc.entity.Good" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>网上商城主界面</title>
	<base href="${pageContext.request.contextPath}/" />
<link type="text/css" href="css/main.css" rel="stylesheet">
<link type="text/css" href="css/main1.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/pinla_fcous.js"></script>
<script type="text/javascript">
	$(function() {
		$("#shops-focus1").adfocus({
			drection : "left",
			numbox : ".numboxcont",
			imgbox : ".imgbox",
			speed : 5000,
			addClass : "pptOn",
			imgboxWidth : 670,
			imgboxHeight : 327,
			imgLen : 4,
			pull : "",
			usevent : "mouseover"
		});
		$("#shops-focus2").adfocus({
			drection : "left",
			numbox : ".numboxcont",
			imgbox : ".imgbox",
			speed : 5000,
			addClass : "pptOn",
			imgboxWidth : 278,
			imgboxHeight : 134,
			imgLen : 3,
			pull : "",
			usevent : "mouseover"
		});
	})
</script>
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

		function addCar(num) {
			alert("添加成功");
			var txt=document.getElementById(num);
			var b=txt.value;
			document.getElementById("car"+num).value = b;
		}

		function purchase(num) {
			var txt=document.getElementById(num);
			var b=txt.value;
			document.getElementById("good"+num).value = b;
		}
	</script>
</head>

<body>
	<!--top 开始-->

	<div class="head_box">
		<div class="box">
			<!--head 开始-->
			<p class="pos_r" id="sy_img1"></p>
			<div>
				<p class="left mt20 ml10">
					<a href=""> <img src="images/logo.jpg" width="270" height="60"
						alt="中国移动"></a>
				</p>
				<div class="left">
					<div class="head_ssbox1">
						<a href="" class="head_ssan"></a>
					</div>

				</div>
				<div class="head_tan" style="width: 130px;">
					    <p class="hello">您好 ${username}</p>
						<p class="people">在线人数:${Count}</p>
						<div class="head_wdhb_ycc">
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<div class="nav">
				<div class="nav_1 sy_nav_1">
					<p class="nav_1_wz">全部商品分类</p>
					<div class="nav_all">
						<div class="nav_all_li">
							<p class="nav_tit">·手机品牌</p>
							<p class="nav_nr">
							<a href="${pageContext.request.contextPath}/select?Goodstype=all">全部</a>
								<a href="${pageContext.request.contextPath}/select?Goodstype=apple">苹果</a>
								 <a href="${pageContext.request.contextPath}/select?Goodstype=xiaomi">小米</a> 
								 <a href="${pageContext.request.contextPath}/select?Goodstype=jinli">金立</a> 
								 <a href="${pageContext.request.contextPath}/select?Goodstype=huawei">华为</a> 
							</p>
							<div class="nav_r" style="border-top: 1px solid #f40;">
								<ul>
									<li><a href="" class="nav_r_tit">国产品牌</a> | <a href="">华为</a>
										| <a href="">天语</a> | <a href="">万事通</a> | <a href="">百立丰</a>
										| <a href="">魅族</a> | <a href="">TCL</a> | <a href="">海信</a> |
										<a href="">德赛</a> | <a href="">波导</a> | <a href="">酷诺</a> | <a
										href="">新邮通</a> | <a href="">金立</a> | <a href="">夏新</a> | <a
										href="">华森酷比</a> | <a href="">宇龙酷派</a> | <a href="">联想</a> | <a
										href="">天迈</a> | <a href="">海尔</a> | <a href="">康佳</a> | <a
										href="">中兴</a> | <a href="">大唐电信</a> | <a
										href="">小米</a></li>
									<li class="navlast"><a href="" class="nav_r_tit">国际品牌</a>
										| <a href="">三星</a> | <a href="">苹果</a> | <a href="">飞利浦</a> |
										<a href="">HTC</a> | <a href="">宏基</a> | <a href="">诺基亚</a> |
										<a href="">摩托罗拉</a></li>
								</ul>
							</div>
						</div>

						<div class="nav_all_li">
							<p class="nav_tit">·价格区间</p>
							<p class="nav_nr">
								<a href="">1-499</a> <a href="">500-999</a> <a href="">1000-1999</a>
								
							</p>
							<div class="nav_r">
								<ul>
									<li class="navlast"><a href="" class="nav_r_tit">价格区间</a>
										| <a href="">全部</a> | <a href="">0-199元</a> | <a href="">200-499元</a>
										| <a href="">500-999元</a> | <a href="">1000-1999元</a> | <a
										href="">2000-2999元</a> | <a href="">3000-3999元</a> | <a
										href="">4000元以上</a></li>
								</ul>
							</div>
						</div>

						<div class="nav_all_li">
							<p class="nav_tit">·手机店铺</p>
							<p class="nav_nr">
								<a href="">中国移动通信集团终端有...</a> 
							</p>
							<div class="nav_r">
								<ul>
									<li class="navlast"><a href="" class="nav_r_tit">手机店铺</a>
										| <a href="">北京百纳威尔科技有限公司</a> | <a href="">天音通信有限公司安徽分公司</a> |
										<a href="">德赛电子</a> | <a href="">合肥松联通讯器材有限公司</a> | <a href="">中邮普泰</a>
										| <a href="">深圳爱施德</a> | <a href="">安徽鸿讯</a> | <a href="">中国移动通信集团终端有限公司安徽分公司</a>
									</li>
								</ul>
							</div>
						</div>

						<div class="nav_all_li">
							<p class="nav_tit">·屏幕尺寸</p>
							<p class="nav_nr">
								<a href="">3.5寸</a> <a href="">4.0-4.5寸</a> <a href="">4.7-5.5寸</a>
								
							</p>
							<div class="nav_r">
								<ul>
									<li class="navlast"><a href="" class="nav_r_tit">屏幕尺寸</a>
										| <a href="">5.6英寸及以上</a> | <a href="">5.5-5.0英寸</a> | <a
										href="">4.9-4.1英寸</a> | <a href="">4.0-3.1英寸</a> | <a href="">3.0英寸及以下</a>
									</li>
								</ul>
							</div>
						</div>

						<div class="nav_all_li">
							<p class="nav_tit">·手机配件</p>
							<p class="nav_nr">
								<a href="">存储卡</a> <a href="">手机</a> <a href="">电池</a> <a
									href="">保护套</a> 
							</p>
							<div class="nav_r">
								<ul>
									<li class="navlast"><a href="" class="nav_r_tit">手机配件</a>
										| <a href="">电池</a> | <a href="">蓝牙耳机</a> | <a href="">充电器</a>
										| <a href="">数据线</a> | <a href="">手机耳机</a> | <a href="">贴膜</a>
										| <a href="">存储卡</a> | <a href="">保护套</a> | <a href="">iPhone配件</a>
										| <a href="">便携/无线音箱</a> | <a href="">手机饰品</a></li>
								</ul>
							</div>
						</div>

						<div class="nav_all_li">
							<p class="nav_tit">·号卡中心</p>
							<p class="nav_nr">
								<a href="">SIM卡</a> <a href="">充值卡</a> <a href="">家园卡</a> 
							</p>
							<div class="nav_r">
								<ul>
									<li class="navlast"><a href="" class="nav_r_tit">号卡中心</a>
										| <a href="">SIM卡</a> | <a href="">充值卡</a> | <a href="">家园卡</a>
									</li>
								</ul>
							</div>
						</div>

					</div>
				</div>
				<ul class="nav_2">
					<li class="navhover"><a href="">首页</a></li>
					<li><a href="user/myMoney?userid=${id}">我的钱包</a></li>
					<li><a href="user/myInformation?userid=${id}">我的信息</a></li>
					<li><a href="car/goodCar?userid=${id}">购物车</a></li>
					<li><a href="orders/myOrder?userid=${id}">我的订单</a></li>
                    <li><a href="${pageContext.request.contextPath}/buyfast">秒杀</a></li>
					<li><a href="lottery/selectLottery?userid=${id}">抽奖</a></li>
				</ul>
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<!--head 结束-->

	<!--cont 开始-->
	<div class="box">
		<div class="cont">
			<div class="sy_cont_1">
				<div class="sy_cont_1_l">

					<div class="shops-focus" id="shops-focus1">
						<div class="imgwarpper">
							<ul class="imgbox">
								<li style="z-index: 1;"><a href=""><img
										src="https://s2.ax1x.com/2019/12/10/QDPbYF.jpg" width="670"
										height="327"></a></li>
								<li><a href=""><img
										src="https://s2.ax1x.com/2019/12/10/QDikSH.jpg" width="670"
										height="327"></a></li>
								<li><a href=""><img
										src="https://s2.ax1x.com/2019/12/10/QDPURH.jpg" width="670"
										height="327"></a></li>
								<li><a href=""><img
										src="https://s2.ax1x.com/2019/12/10/QDCHxA.jpg" width="670"
										height="327"></a></li>
							</ul>
						</div>
						<div class="numbox">
							<p class="numboxcont">
								<span class="pptOn"></span> <span></span> <span></span> <span></span>
							</p>
						</div>
					</div>
				</div>

				<div class="sy_cont_1_r">
					<div class="sy_hdm_1">
						<ul class="sy_hdm_1_tit">
							<li style="width: 138px;" class="hover" id="syone1"
								onmouseover="setTab('syone',1,2)">促销活动</li>
							<li class="sy_hdm_1_fgx"></li>
							<li id="syone2" onmouseover="setTab('syone',2,2)">公告资讯</li>
						</ul>
						<ul class="sy_hdm_1_nr" id="con_syone_1">
							<li><a href="">苹果iphone5s移动版直降180元</a></li>
							<li><a href="">三星N9008直降500元</a></li>
							<li><a href="">华为A954 全场5折给力优惠</a></li>
							<li><a href="">苹果iphone5s移动版直降180元</a></li>
							<li><a href="">三星N9008直降500元</a></li>
						</ul>
						<ul class="sy_hdm_1_nr none" id="con_syone_2">
							<li><a href="">苹果iphone5s移动版直降180元2</a></li>
							<li><a href="">三星N9008直降500元2</a></li>
							<li><a href="">华为A954 全场5折给力优惠2</a></li>
							<li><a href="">苹果iphone5s移动版直降180元2</a></li>
							<li><a href="">三星N9008直降500元2</a></li>
						</ul>

						<div class="shops-focus2" id="shops-focus2">
							<div class="imgwarpper">
								<ul class="imgbox">
									<li style="z-index: 1;"><a href=""><img
											src="images/ggao2.jpg" width="278" height="134"></a></li>
									<li><a href=""><img src="images/ggao3.jpg" width="278"
											height="134"></a></li>
									<li><a href=""><img src="images/ggao4.jpg" width="278"
											height="134"></a></li>
								</ul>
							</div>
							<div class="numbox">
								<p class="numboxcont">
									<span class="pptOn"></span> <span></span> <span></span>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="sy_title">
				<span class="sy_louc">1F</span> <span class="sy_title_l">新品推荐</span>
				<p class="sy_title_r">
					<a href="">三星</a> | <a href="">华为</a> | <a href="">小米</a> | <a
						href="">苹果</a> | <a href="">更多</a>
				</p>
			</div>
			<div class="sy_nr">

				<p class="sy_nr_l">
					<a href=""><img src="images/sy_nrimg1.jpg" width="208"
						height="730"></a>
				</p>
				<ul class="sy_nr_r">
					<c:forEach items="${goodlist.list}" var="good" varStatus="status">

						<li>
							<p class="sy_jbtj_tp">
								<a href="#"><img src="images/${good.goodsFile}" width="176"
									height="176"></a>
							</p>
							<p
								style="position: relative; text-align: center; line-height: 18px; height: 40px; margin-top: 5px;">
								${good.goodsType}${good.goodsName}(${good.goodsColor})<br />
								${good.goodsMessage}
							</p>
							<p class="cc7c7c7"
								style="position: relative; text-align: center;">
								参考价：
								<del class="font14">￥${good.goodsNoprice+""}</del>
							</p>

							<p class="sy_ljgm">
								<span class="sy_jbtj_jg">￥${good.goodsPrice+""}</span><br />
                                <input class="decrease" type="button" value="-" onclick="return del(${status.index})"/>
                                <input class="number" type="text" value="1" id="${status.index}"/>
                                <input class="add" type="button" value="+" onclick="return add(${status.index})"/>
							</p>
							   <form action="car/addgoodsCar?goodsId=${good.goodsId}&userid=${id}&username=${username}" method="post">
							    <input type="text" style="display: none;color:black" name="car${good.goodsId}" value="1" id="car${status.index}"/>
                                <input type="submit" value="加入购物车" onclick= "return addCar(${status.index})" class="addCar"/>
						       </form>
							   <form action="good/purchase?goodsId=${good.goodsId}&userid=${id}" method="post">
								   <input style="display: none" name="good${good.goodsId}" value="1" id="good${status.index}"/>
								   <input type="submit" value="立即购买" onclick= "return purchase(${status.index})" class="purchase"/>
							   </form>

						</li>
					</c:forEach>

					<!-- 显示分页信息 -->
					<div class="message">共
					<i class="blue">${goodlist.total }
					</i>件商品，当前显示第&nbsp;${goodlist.pageNum }&nbsp;</i>页
					总<i class="blue">&nbsp;${goodlist.pages }&nbsp;</i>页
				    </div>
					<div>
					</div>
					</div>
			<ul >
				<li class="page">
					<a class="blue" href="good/showGood?currentPage=1">首页</a></li>
				<c:if test="${goodlist.hasPreviousPage }">
					<li class="page1">
						<a class="blue" href="good/showGood?currentPage=${goodlist.pageNum-1}">
							<span class="blue">&laquo;</span></a>
					</li>
				</c:if>
				<c:if test="${goodlist.hasNextPage }">
					<li class="page2">
						<a href="good/showGood/?currentPage=${goodlist.pageNum+1 }">
							<span class="blue">&raquo;</span></a>
					</li>
				</c:if>
				<li class="page3">
					<a class="blue" href="good/showGood/?currentPage=${goodlist.pages}">末页</a>
				</li>
			</ul>
			</div>
	</div>
</body>
</html>
