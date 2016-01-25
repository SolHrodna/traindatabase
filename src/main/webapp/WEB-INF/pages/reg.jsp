<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Page</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/jumbotron.css" />" rel="stylesheet">
</head>
<body>
<div class="container">
    <form action="/" method="get">
        <button type="submit" class="btn btn-primary btn-block" value="Exit">Exit</button>
    </form>

</div>

<div class="container">
    <form action="/registrationUser" method="post">
        <table class="table">
            <td>
                <p>Input Login:</p>
                <input class="form-control" type="text" name="loginReg">
                <p>Input Password:</p>
                <input class="form-control" type="text" name="passwordReg">
                <p>Input First name:</p>
                <input class="form-control" type="text" name="fnameReg">
                <p>Input Second name:</p>
                <input class="form-control" type="text" name="snameReg">
            </td>
            <td><br><br><br>
                <button class="btn btn-primary btn-block" type="submit">Reg</button>
            </td>
        </table>
    </form>


</div><br>

</body>
</html>
