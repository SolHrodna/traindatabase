<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Order pages</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
<form action="/exitFromOrder" method="post">
    <button type="submit" class="btn btn-primary btn-block" value="Exit">Exit</button>
</form>
<form action="/orderPage" method="post">
    <button type="submit" class="btn btn-primary btn-block" value="Order">My Order</button>
</form>
<form action="/showHistory" method="post">
    <button type="submit" class="btn btn-primary btn-block" value="History">My History</button>
</form>
</div>


<form action="/find" method="post">
    <div class="container">
    <table class="table">
        <tr>
            <td>
                <p>Укажите дату:
                    <input type="date" class="form-control" name="date">
                </p>
            </td>
            <td>
                <p>From:
                    <select class="form-control" name = "stationSelectFrom">
                    <option disabled>Выберите станцию</option>


                    <c:forEach items="${stationsList}" var="elem" varStatus="varStatus">
                        <option value="${elem.station}">${elem.station}</option>
                    </c:forEach>

                </select></p>

            </td>
            <td>
                <p>To:
                    <select class="form-control" name = "stationSelectTo">
                    <option disabled>Выберите станцию</option>


                    <c:forEach items="${stationsList}" var="elem" varStatus="varStatus">
                        <option value="${elem.station}">${elem.station}</option>
                    </c:forEach>

                </select></p>

            </td>
            <td>
                <br>
                <p><input type="submit" class="btn btn-primary btn-block" value="Отправить"></p>
            </td>
        </tr>
    </table>
    </div>

</form>

    <c:forEach items="${stations}" var="items" varStatus="varStatus">
    <form method="post" action="/order">
    <div class="row"></div>
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <table class="table">
            <tr>
                <td>${items.date}</td>
                <td>${items.train.number}</td>
            </tr>
            <tr>
                <td>
                    <c:forEach items="${items.stationsSet}" var="elem" varStatus="varStatus">
                        ${elem.station} &nbsp &nbsp
                    </c:forEach>
                </td>
            </tr>
        </table>
        <table>
            <tr>

                    <div class="col-md-4">
                        <button type="submit" class="btn btn-primary btn-block" value=${items.routeId} name="orderButtom">Order</button>
                    </div>
            </tr>
        </table>
    </div>
    </div>
    </form>
    </c:forEach>

</body>
</html>
