<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<head>
    <title>网上商城</title>
    <base href="${pageContext.request.contextPath}/" />
    <link href="css/register.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/commons.js"></script>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript"src="js/jquery.i18n.properties.js"></script>
</head>

<div class="main">
    <h1 id="title">Welcome to ShoppingOnline</h1>
    <div class="main-w3lsrow">
        <!-- login form -->
        <div class="login-form login-form-left">
            <div class="agile-row">
                <h2 id="form">Login Form</h2>
                <p id="error">${error}</p>
                <div class="login-agileits-top">
                    <form action="user/testRedirect" method="post" id="loginForm">

                        <p id="pusername">username </p>
                        <input type="text" id="username" class="username" name="username" value="${user.username}"/>
                        <p id="ppassword">password</p>
                        <input type="password" id="password" class="password" name="password" value="${user.password}"/>
                        <p id="vcode">vertifycode</p>
                        <input id="code" type="text" name="vcode" class="form-control" placeholder="验证码" style="width: 70px" maxlength="4"/>&nbsp;
                        <img src="vertify/VertifyCode" class="vertify" onclick="changeImage(this)" title="看不清，点击刷新">

                        <a class="language" id="lan_zh" name="lan_zh" onclick="return change(1)">Chinese</a>
                        <a class="language" id="lan_en" name="lan_en" onclick="return change(2)">English</a>
                        <label class="anim">
                            <input type="checkbox" class="checkbox" name="remember">
                            <span id="remember"> Remember me ?</span>
                        </label>
                        <input type="submit" value="Login" id="Login">
                    </form>

                </div>
                <div class="login-agileits-bottom">
                    <h6><a href="Register.jsp" id="Register">Register</a></h6>
                </div>
            </div>
        </div>
    </div>
    <script>
        // 监听验证码图片的点击：切换验证码图片
        function changeImage(img) {
            img.src = "vertify/VertifyCode?t=" + Math.random();
        }

        var LANGUAGE_Index = "zh_CN"; //标识语言

        jQuery(document).ready(function () {
            LANGUAGE_Index = jQuery.i18n.normaliseLanguageCode({}); //获取浏览器的语言
            loadProperties(LANGUAGE_Index);
        });

        //改变中文英文
        function change(lan) {
            if (lan==2) {
                LANGUAGE_Index = "en_US";
            } else {
                LANGUAGE_Index = "zh_CN";
            }
            loadProperties(LANGUAGE_Index);
        }

        //通过返回的类型来对应不同的资源路径
        function loadProperties(type) {
            jQuery.i18n.properties({
                name: 'message', // 资源文件名称
                path: 'language/', // 资源文件所在目录路径
                mode: 'map', // 模式：变量或 Map
                language: type, // 对应的语言
                cache: false,
                encoding: 'UTF-8',
                callback: function () { // 回调方法
                    $('#lan_zh').html($.i18n.prop('lan_zh'));
                    $('#lan_en').html($.i18n.prop('lan_en'));
                    $('#pusername').html($.i18n.prop('username'));
                    $('#ppassword').html($.i18n.prop('password'));
                    $('#vcode').html($.i18n.prop('vcode'));
                    $('#code')[0].placeholder = $.i18n.prop('vcode');
                    //document.getElementById("code").placeholder = $.i18n.prop('vcode');
                    $('#remember').html($.i18n.prop('remember'));
                    $('#Login')[0].value = $.i18n.prop('Login');
                    //document.getElementById("Login").value = $.i18n.prop('Login');
                    $('#Register').html($.i18n.prop('Register'));
                    $('#form').html($.i18n.prop('form'));
                    $('#title').html($.i18n.prop('title'));
                    if($.i18n.prop('Login')!=null)
                        //$('#Login')[0].value = $.i18n.prop('Login');
                    $('#Register')[0].href = "Register.jsp?flag="+$.i18n.prop('Login');
                }
            });
        }
    </script>
</div>
</body>
</html>
