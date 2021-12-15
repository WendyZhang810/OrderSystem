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


        </div>
    </div>
</div>



</body>
</html>
