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
                <br><br><br>
                <h5><a  style="color: aliceblue" href="${pageContext.request.contextPath}/client/getCatalogs"> go back to order page</a></h5>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            </div>

        </div>
        <div class="col-8">
            <jsp:include page="header.jsp"/>

            <h4>${msg}</h4>
            <c:if test="${msg==null}">
                <table class="table">
                    <thead>
                        <tr>
                            <th>food name</th>
                            <th>price £</th>
                            <th>notes</th>
                            <th>delete</th>
                         </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${names}" var="name" varStatus="status">
                        <tr>
                            <td>${name}</td>
                            <td>${prices.get(status.index)}</td>
                            <td>${notes.get(status.index)}</td>
                            <td><a href="${pageContext.request.contextPath}/client/delFromTrolley?id=${ids.get(status.index)}">delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tr>
                        <td>total:</td>
                        <td><div id="total"></div></td>
                        <td></td>
                    </tr>
                </table>
                <a href="${pageContext.request.contextPath}/client/confirm">confirm</a><br>
                <a href="${pageContext.request.contextPath}/client/emptyTrolley">empty trolley</a>
            </c:if>

            <jsp:include page="footer.jsp"/>
        </div>
    </div>
</div>



</body>
</html>
