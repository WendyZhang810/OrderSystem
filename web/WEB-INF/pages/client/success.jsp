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
    <title>Trolley</title>

</head>
<body>

<div class="container" id="gridContainer" >
    <div class="row">
        <div class="col-3">
            <div id="welcome">
                <h4> welcome to wendy's grill</h4>
                <br><br><br><br><br>
                <h4><a style="color: aliceblue" href="../index.jsp">go to first page</a></h4>

                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

            </div>

        </div>
        <div class="col-8">
            <jsp:include page="header.jsp"/>

            <h4>order success, <a href="${pageContext.request.contextPath}/client/getCatalogs>go back to menu</a></h4>

            <jsp:include page="footer.jsp"/>
        </div>
    </div>
</div>



</body>
</html>
