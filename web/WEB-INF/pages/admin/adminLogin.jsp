<%--
  Created by IntelliJ IDEA.
  User: naiqianzhang
  Date: 11/12/2021
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>welcome to wendy's grill</title>
    <link rel="stylesheet" href="../../../css/adminLogin.css">
    <style type="text/css">
        body{
            background-image: url("../../../images/img.png");
            background-size:cover;
        }
    </style>
</head>
<body>
<div id="adminLoginDiv">
    <h1>Admin Login</h1>
    <form method="post" action="/admin/login">
        <h3>
            username: <input class="input" type="text" name="username" placeholder="please enter username"><br>
        password: <input class="input" type="password" name="password" placeholder="please enter password"><br><br>
            <input id="submit" type="submit" value="login">
        </h3>
    </form>
    <h4>${msg}</h4>

</div>




</body>
</html>
