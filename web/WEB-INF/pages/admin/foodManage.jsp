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
    <script src="${pageContext.request.contextPath}/js/alter.js"></script>

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
                <thead>
                <tr>
                    <th scope="col" colspan="4">catalogs</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${catalogs}" var="catalog">
                    <tr>
                        <td><a href="${pageContext.request.contextPath}/admin/foodByCatalog?id=${catalog.catalog_id}">${catalog.catalog_name}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br><br><br>
            <h5>add or alter</h5>
            <form action="${pageContext.request.contextPath}/admin/alterOrAddFood" method="post">
                <input type="hidden" id="food_id">
                name:<input type="text" id="food_name">
                price:<input type="text" id="food_price">
                catalog:
                <select>
                    <c:forEach items="${catalogs}" var="catalog">
                        <option value="${catalog.catalog_id}" <c:if test="${catalog.catalog_id==foods.get(0).catalog_id}">
                            selected
                        </c:if>>
                                ${catalog.catalog_name}
                        </option>
                    </c:forEach>
                </select>
                <input type="submit" name="submit" value="submit">

            </form>
            <table class="table">
                <thead>
                <tr>
                    <th>name</th>
                    <th>price</th>
                    <th>delete</th>
                    <th>alter</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${foods}" var="food">
                    <tr>
                        <td>${food.food_name}</td>
                        <td id="price${food.food_id}">${food.food_price}</td>
                        <td><a href="${pageContext.request.contextPath}/admin/delFood?id=${food.food_id}">delete</a></td>
                        <td><a href="#" id="${food.food_id}" name="${food.food_name}" onclick="alter(this)">alter</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>



</body>
</html>
