<%--
  Created by IntelliJ IDEA.
  User: --
  Date: 2020/5/21
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:if test="${loginState!=null}">
        欢迎你：${loginState}<br>
    </c:if>
    主界面
</body>
</html>
