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
    <script src="${pageContext.request.contextPath}/js/addFoodtoTrolley.js">
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
                    <c:forEach items="${catalogs}" var="catalog">
                        <li class="nav-item">
                            <a style="color: aliceblue" class="nav-link" href="${pageContext.request.contextPath}/client/getFoodByCatalog?catalogId=${catalog.catalog_id}&catalogName=${catalog.catalog_name}">${catalog.catalog_name}</a>
                        </li>
                    </c:forEach>
                </h4>
            </ul>
        </div>
        <div class="col-8">
            <jsp:include page="header.jsp"/>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col" colspan="4">${catalogName}</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${foodsByCatalog}" var="food">
                    <tr>
                        <td>${food.food_name}</td>
                        <td>${food.food_price}</td>
                        <td><input id="note${food.food_id}" type="text" placeholder="note..."></td>
                        <td><button type="button" id="${food.food_id}" onclick="addFoodtoTrolley(this)">add</button></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <jsp:include page="footer.jsp"/>
        </div>
    </div>
</div>



</body>
</html>
