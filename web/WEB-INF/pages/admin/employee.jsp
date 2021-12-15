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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pageStyle.css">
    <title>${catalogName}</title>
    <script src="${pageContext.request.contextPath}/js/alterUser.js">
    </script>

</head>
<body>
<div class="container" id="gridContainer" >
    <div class="row">
        <div class="col-3">
            <div id="welcome">
                <h4> welcome to wendy's grill</h4>
            </div>
            <ul class="nav flex-column" id="catalogUL">
                <h4>
                    <li class="nav-item">
                        <a style="color: aliceblue" class="nav-link" href="${pageContext.request.contextPath}/admin/food">
                            food management
                        </a>
                    </li>
                    <li class="nav-item">
                        <a style="color: aliceblue" class="nav-link" href="${pageContext.request.contextPath}/admin/employee">
                            employee management
                        </a>
                    </li>
                    <li class="nav-item">
                        <a style="color: aliceblue" class="nav-link" href="${pageContext.request.contextPath}/admin/logOut">
                            log out
                        </a>
                    </li>
                </h4>
            </ul>
            <br><br><br><br><br><br><br>
        </div>
        <div class="col-8">
            <jsp:include page="header.jsp"/>
            <table class="table">
                <h4>employee</h4>
                <form method="post" action="${pageContext.request.contextPath}/admin/addOrAlterUser">
                    <input type="hidden" name="userId" id="input_id">
                    username:<input type="text" name="username" id="input_username">

                    isManager:
                    true:<input type="radio" name="isManager" value="true">
                    false:<input type="radio" name="isManager" value="false">

                    <input type="submit" value="submit" name="submit">
                </form>
                <thead>
                <tr>
                    <th>username</th>
                    <th>isManager</th>
                    <th>alter</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.manager}</td>
                        <td><a href="#" name="${user.username}" id="${user.userId}" onclick="alterUser(this)">alter</a></td>
                        <td><a href="${pageContext.request.contextPath}/admin/delUser?id=${user.userId}">delete</a></td>
                </c:forEach>

                </tbody>
            </table>


        </div>
    </div>
</div>



</body>
</html>
