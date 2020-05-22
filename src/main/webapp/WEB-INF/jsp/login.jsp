<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: --
  Date: 2020/5/21
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../../js/jquery-1.11.0.min.js"></script>
    <script>
        $(
            function () {
                $("#btn").on("click",function () {
                    var error="";
                    var flag=true;

                    var username=$("#name").val();
                    var password=$("#pwd").val();
                    if (username==""||username==undefined){
                        error="用户名不能为空!";
                        flag=false;
                    }
                    if (password==""||password==undefined){
                        error="密码不能为空!";
                        flag=false;
                    }
                    if (flag==true&&error==""){
                        $("#formId").submit();
                    }else {
                        alert(error);
                        return;
                    }
                });
            }
        );
    </script>
</head>
<body>
    <h1>登录</h1>
    <p style="color: red">${errorMsg}</p>
    <form:form action="/userController/doLogin" method="post" modelAttribute="user" id="formId">
    用户名：<form:input path="uName" id="name"/><br>
    密码：<form:password path="password" id="pwd"/><br>
    <input type="button" value="提交" id="btn">
    </form:form>
</body>
</html>
