<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>500错误页面</title>
    <base href="${pageContext.request.contextPath}/" />
</head>
<body>
<%=exception.getMessage()%>
<img src="images/500.png" width="1340" height="600"/>
</body>
</html>
