<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>在线商城抽奖</title>
    <base href="${pageContext.request.contextPath}/" />
    <link href="css/lotter.css" rel="stylesheet" type="text/css" />
    <script src="js/jquery-3.3.1.js"></script>

</head>

<body>
<div class="count">
    <div class="choose">
        <p>每个新用户都只有一次抽奖机会哦</p>
        <p >${flag}</p>
        <input style="display: none" id="chance" value="${flag}">
    </div>

</div>
    <!-- 小像框 -->
    <div id="small">
        <img id="smallPhoto" src="images/No_10.png"/>
    </div>

    <!-- 大像框 -->
    <div id="big">
        <img id="bigPhoto" src="images/No_10.png"/>
    </div>

    <!-- 开始按钮 -->
    <input id="btnStart" type="button" value="开始">

    <!-- 停止按钮 -->
    <input id="btnStop" type="button"  value="停止">

<form action="lottery/saveLottery" method="post" id="lottery">
     <input style="display: none" type="text" name="userid" value="${userid}" id="userid">
    <input style="display: none" pe="text" name="lotteryId" value="123" id="lotteryId">
    <input id="submit" type="submit" value="领取" style="display: none" onclick="addTicket()">
</form>

    <script type="text/javascript">

        function addTicket() {
           alert("领取成功，优惠券已存到您的卡包中");
        }

        if($("#chance")[0].value!=""&&$("#chance")[0].value!=null){
            //设置开始按钮不可点击
            $("#btnStart").prop("disabled",true);
        }
        // 准备一个一维数组，用户的图片的路径
        var imgs = [
            "images/No_10.png",
            "images/No_20.png",
            "images/No_50.png",
            "images/100_10.png",
            "images/150_20.png",
            "images/300_50.png",
            "images/500_100.png",
            "images/800_200.png",
            "images/1000_300.png",
            "images/2000_500.png"
        ];

        // 定义变量记录当前显示的图片索引
        var index = 0;

        // 定义变量接收定时任务id
        var taskId = 0;

        // 设置停止按钮的状态：不可点击
        $("#btnStop").prop("disabled",true);

        // 监听开始按钮点击
        $("#btnStart").click(function () {
            // 1. 设置开始按钮不可点
            $(this).prop("disabled",true);

            // 2. 设置停止按钮可点击
            $("#btnStop").prop("disabled",false);

            // 3. 开启一个定时器：每隔0.2秒切换小相框图片
            // 参数1：定时器回调函数，用来封装定时任务
            // 参数2：时间间隔：单位毫秒
            // setTimeout开启的定期器只会执行一次
            // setInterval开启的定期器会重复执行
            taskId = setInterval(changeImage,50);
        });


        // 监听停止按钮点击
        $("#btnStop").click(function () {
            // 1. 设置停止按钮不可点
            $(this).prop("disabled",true);
            // 2. 设置开始按钮可点击
            $("#btnStart").prop("disabled",false);

            // 3. 停止定时任务
            clearInterval(taskId);
            // 4. 将小相框图片显示在大相框上
            // 4.1 隐藏大相框图片
            $("#bigPhoto").hide();
            // 4.2 设置大相框图片
            $("#bigPhoto").attr("src",$("#smallPhoto").attr("src"));
            $("#bigPhoto").fadeIn(5000);

            $('#lotteryId')[0].value=index%imgs.length;
            var flag=window.location.search;
            $("#submit").css("display","block");
            //$("#lottery").submit();
        });

        // 切换图片函数：每隔0.2秒切换小相框图片

        function changeImage() {
            // 索引加一
            index++;// index > imgs.length
            // 计算真实的索引值
            var i = index % imgs.length; // 10000 % 7 = 0 - 6
            // 根据索引获得要切换的图片
            var img = imgs[i];
            // 根据id获取小相框图片元素对象
            $("#smallPhoto").attr("src",img);
        }

        //休眠方法
         function sleep(numberMillis) {
        var now = new Date();
        var exitTime = now.getTime() + numberMillis;
        while (true) {
            now = new Date();
            if (now.getTime() > exitTime)
                return;
        }
        }

    </script>
</body>
</html>
