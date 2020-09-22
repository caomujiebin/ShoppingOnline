/**
 * 页面加载完成，读取cookie的信息
 * 如果有username和password
 * 则将用户名和密码发送给服务器，实现自动登录
 * 如果没有，则显示登录页面
 */
window.onload = function () {
    // 读取Cookie信息
    var cookies = document.cookie;
    // 如果cookie不为空
    if (cookies) {
        // 得到用户名和密码
        var username = getCookie("username");
        var password = getCookie("password");
        // 设置文本框的值
        document.getElementById("username").value = username;
        document.getElementById("password").value = password;
        // 自动提交表单
        //document.getElementById("loginForm").submit();
    }
};

/*
 * 得到指定cookie的值
 */
function getCookie(cname) {
    var ca = document.cookie.split(';'); // [username=admin;password=123]
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i]; // "password=123"
        var arr = c.split("="); // ["password",123]
        if (arr[0].trim() == cname){ // password
            return arr[1];
        }
    }
    return "";
}
