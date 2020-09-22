<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<head>
    <title>网上商城</title>
    <base href="${pageContext.request.contextPath}/" />
    <link href="css/register.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript"src="js/jquery.i18n.properties.js"></script>
</head>

<div class="main">
    <h1 id="title">Welcome to ShoppingOnline</h1>
    <p id="info" class="info"></p>
    <div class="main-w3lsrow">
        <!-- login form -->
        <div class="login-form login-form-left">
            <div class="agile-row">
                <h2 id="form1">Register Form</h2>
                <div class="login-agileits-top">
                    <form action="user/register" method="post" id="loginForm" onsubmit="return check()">
                        <p id="pusername">username </p>
                        <input type="text" id="username" class="username" name="username" value="${user.username}"/>
                        <p id="ppassword">password</p>
                        <input type="password" id="password" class="password" name="password" value="${user.password}"/>
                        <p id="prepassword">confirm password</p>
                        <input type="password" id="repassword" class="password" name="repassword" value="${user.repassword}" onkeyup  ="return confirmPassword()"/>
                        <p id="paddress">address</p>
                        <input type="text" id="address" class="username" name="address" value="${user.address}" />
                        <p id="ptelphone">telphone</p>
                        <input type="text" id="telphone" class="username" name="telphone" value="${user.telphone}"/>
                        <input id="register" type="submit" value="register"/>
                    </form>

                </div>
            </div>
        </div>
    </div>

    <script>

        $(function(){
              //从登陆页面获得选中的语言
                var flag=window.location.search;
                if(flag.indexOf("?")!=-1){
                    var id = flag.substr(flag.indexOf("=")+1);
                }
                if(id=="Login"){
                    loadProperties("en_US");
                }else{
                    loadProperties("zh_CN");
                }

                // 注册失去焦点事件
                $("#username").blur(function () {
                    // 1. 获取用户名
                   var username = $(this).val().trim();
                    if (username.length == 0) return;
                    // 发送异步请求：GET请求
                    $.get(
                        "user/haveUsername", // 请求地址
                        "username="+username, // 请求参数
                        function (result) { // 回调函数
                            if(result!=""&&result!=null){
                                $("#info").css("display","block");
                                $("#info").html($.i18n.prop('result'));
                                $("#password").attr('disabled',true);
                            }else{
                                $("#info").css("display","none");
                                $("#password").attr('disabled',false);
                            }

                        },
                        "text" // 返回数据类型
                    );
                });
        });
            function loadProperties(type) {
                jQuery.i18n.properties({
                    name: 'message', // 资源文件名称
                    path: 'language/', // 资源文件所在目录路径
                    mode: 'map', // 模式：变量或 Map
                    language: type, // 对应的语言
                    cache: false,
                    encoding: 'UTF-8',
                    callback: function () { // 回调方法
                        $('#pusername').html($.i18n.prop('username'));
                        $('#ppassword').html($.i18n.prop('password'));
                        $('#form1').html($.i18n.prop('form1'));
                        $('#title').html($.i18n.prop('title'));
                        $('#prepassword').html($.i18n.prop('repassword'));
                        $('#paddress').html($.i18n.prop('address'));
                        $('#ptelphone').html($.i18n.prop('telphone'));
                        $('#register')[0].value = $.i18n.prop('register');
                    }
                });
        };

       function confirmPassword() {
           var password = document.getElementById('password').value;
           var repassword = document.getElementById('repassword').value;
          if(password==repassword){
              document.getElementById("repassword").style.color = "white";
              return true;
          }else{
              document.getElementById("repassword").style.color = "red";
          }
       }
        //校验手机号是否合法和是否漏填
        function check(){
            //校验手机号是否合法
            var phonenum = document.getElementById('telphone').value;
            var reg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
            if(!reg.test(phonenum)){
                alert('请输入有效的手机号码！');
                return false;
            }else{
                //检验是否留空
                var password = document.getElementById('password').value;
                var repassword = document.getElementById('repassword').value;
                var username = document.getElementById('username').value;
                var address = document.getElementById('address').value;
                if(username==""||password==""||repassword==""||address==""){
                    alert("不能留空!");
                    return false;
                } else{
                    return true;
                }
            }
        }
    </script>
</div>
</body>
</html>
