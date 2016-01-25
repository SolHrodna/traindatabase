<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/jumbotron.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
<form action="/exitFromOrder" method="post">
    <button type="submit" class="btn btn-primary btn-block" value="Exit">Exit</button>
</form>
<form action="/backOrder" method="post">
    <button type="submit" class="btn btn-primary btn-block" value="Back">Back</button>
</form>
</div>
<c:forEach items="${orderList}" var="items" varStatus="varStatus">
    <form id="formOrder" method="post" action="">
        <div class="container">
            <table class="table">
                <tr>
                    <td>${items.routers.date}</td>
                    <td>${items.routers.train.number}</td>
                </tr>
                <tr>
                    <td>${items.status}</td>
                    <td>${items.orderId}</td>
                </tr>
                <tr>
                    <td>
                        <c:forEach items="${items.routers.stationsSet}" var="elem" varStatus="varStatus">
                            ${elem.station} &nbsp &nbsp
                        </c:forEach>
                    </td>
                </tr>

            </table>

        </div>
    </form>
</c:forEach>

</body>
</html>
