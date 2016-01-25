<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User's Editor</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/jumbotron.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
<form action="/exitFromEditor" method="post">
    <button type="submit" class="btn btn-primary btn-block" value="History">Exit</button>
</form>
</div>
    <form id="formEdit" action="javascript:void(0);" method="post">
    <div class="container">
        <table class="table">
            <tr>
                <td>Login: ${user.login}</td>
                <td>Password: ${user.password}</td>
                <td>Firstname: ${user.firstname}</td>
                <td>Secondname: ${user.secondname}</td>
            </tr>
            <tr>
                <td>
                    <c:forEach items="${user.orderSet}" var="elem" varStatus="varStatus">
                        Route id:${elem.routers.routeId} Date: ${elem.routers.date} Train number: ${elem.routers.train.number} Order id:${elem.orderId} Order Status:${elem.status}
                        <table>
                            <tr>
                                <div class=container>
                                    <button class="btn btn-primary btn-block" type="submit" value=${elem.orderId} name="orderDelete" onclick="document.getElementById('formEdit').action = '/deleteOrderEditor'; document.getElementById('formEdit').submit">Delete</button>
                                </div>
                                <div class=container>
                                    <button class="btn btn-primary btn-block" type="submit" value=${elem.orderId} name="orderCancel" onclick="document.getElementById('formEdit').action = '/editOrderEditor'; document.getElementById('formEdit').submit">Cancel</button>
                                </div>
                            </tr>
                        </table>
                    </c:forEach>
                </td>
            </tr>
        </table>
    </div>
    </form>
</body>
</html>
