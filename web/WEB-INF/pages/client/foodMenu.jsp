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
                            <a style="color: aliceblue" class="nav-link" href="${pageContext.request.contextPath}/client/getFoodByCatalog?catalogId=${catalog.catalog_id}&catalogName=${catalog.catalog_name}&tableId=${tableId}">${catalog.catalog_name}</a>
                        </li>
                    </c:forEach>
                </h4>
            </ul>
        </div>
        <div class="col-8">
            <jsp:include page="header.jsp"/>


            <jsp:include page="footer.jsp"/>
        </div>
    </div>
</div>



</body>
</html>
