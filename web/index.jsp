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
    <link rel="stylesheet" href="fonts/indexFont.css">
    <link rel="stylesheet" href="css/indexStyle.css">
    <style type="text/css">
        body{
            background-image: url("images/img.png");
            background-size:cover;
        }
    </style>
</head>
<body>
<div id="indexPage">
    <h1>Welcome to Wendy's Grill</h1>
    <h3>enter your table number to order food</h3>
    <form method="post" action="${pageContext.request.contextPath}/client/getCatalogs">
        <div id="tableId">
            <input type="text" name="tableId">
            <input type="submit" value="order">
        </div>

    </form>

</div>
<div><a href="${pageContext.request.contextPath}/admin/redirectToLoginPage">admin</a></div>




</body>
</html>
