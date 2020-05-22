<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2020/5/22
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>CRM登录</title>
    <script type="text/javascript" src="../../js/jquery-1.11.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn").on("click",function () {
                var show='';
                var flag=true;
                var uname=$("#uname").val();
                var pwd=$("#pwd").val();
                if (uname==''||pwd==undefined){
                    show='用户名不能为空';
                    flag=false;
                }else if (pwd==''||pwd==undefined){
                    show='密码不能为空';
                    flag=false;
                }
                if (show==''&&flag==true){
                    $("#formId").submit();
                }else {
                    alert(show);
                    return;
                }
            });
        });
    </script>
</head>
<body>
<h1>登录</h1>
<p style="color: crimson;">${errorMsg}</p>
<form:form id="formId" action="/doLogin" method="post" modelAttribute="user">
    用户名：<form:input path="uname" id="uname"/><br>
    密码：<form:password path="password" id="pwd"/><br>
    <input type="button" id="btn" value="提交">
</form:form>
</body>
</html>
