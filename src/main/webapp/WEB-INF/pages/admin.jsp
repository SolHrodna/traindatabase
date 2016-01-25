<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin's Tools</title>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/jumbotron.css" />" rel="stylesheet">
</head>
<body>

    <script type="text/javascript">
        var show;
        function hidetxt(type) {
            param = document.getElementById(type);
            if (param.style.display == "none") {
                if (show) show.style.display = "none";
                param.style.display = "block";
                show = param;
            } else {param.style.display = "none"}
        }


        function deleteUser(){
                document.getElementById("formEditorUser").action = "/deleteUser";
                document.getElementById("formEditorUser").submit();
                }
        function editUser(){
            document.getElementById("formEditorUser").action = "/editUser";
            document.getElementById("formEditorUser").submit();
        }


    </script>


    <div align="right"><h1>Hello, Admin.</h1></div>
    <div class="container">
        <form action="/" method="get">
            <button type="submit" class="btn btn-primary btn-block" value="Exit">Exit</button>
        </form>

    </div>

    <div class="jumbotron">
    <div class="container">
    <a onclick="hidetxt('div1'); return false;" href="#" rel="nofollow">Add Route</a>
        <div class="container" id="div1">
            <form action="/addRoute" method="post">
            <table class="table">
            <td>
                    <td>
                    <p>Input date:</p>
                    <input type="date" class="form-control" name="date">
                    <p>Input time:</p>
                    <input type="time" class="form-control" name="time">
                    </td>
                        <td>
                            <p>Trains:</p>
                            <select size="7" multiple class="form-control" name = "trainSelectAdd">

                                <c:forEach items="${trainList}" var="elem" varStatus="varStatus">
                                    <option value="${elem.trainId}">${elem.number} ${elem.model} ${elem.numPlaces}</option>
                                </c:forEach>

                            </select>


                    </td>


                     <td>

                            <p>Route's stations:</p>

                            <select size="7" multiple class="form-control" name = "stationNew">

                                <c:forEach items="${stationNew}" var="elem" varStatus="varStatus">
                                    <option value="${elem.stationId}">${elem.station}</option>
                                </c:forEach>




                        </select>
                    </td>
                    <td>

                            <br><br>
                            <button type="submit" class="btn btn-primary btn-block" name="addStation" value="add"><=</button>


                            <button type="submit" class="btn btn-primary btn-block" name="addStation" value="remove">=></button>

                            <button type="submit" class="btn btn-primary btn-block" name="addStation" value="clear">Clear</button>




                    </td>
                    <td>
                        <p>Stations:</p>
                            <select size="7" multiple class="form-control" name = "stationSelect">

                            <c:forEach items="${stationsList}" var="elem" varStatus="varStatus">
                                <option value="${elem.stationId}">${elem.station}</option>
                            </c:forEach>

                        </select>

                    </td>
                    <td>
                        <br><br>
                        <button type="submit" class="btn btn-primary btn-block" name="addStation" value="addRoute">Add</button>
                    </td>


            </tr>
        </table>
            </form>


        </div><br>



    <a onclick="hidetxt('div3'); return false;" href="#" rel="nofollow">Add Station</a>
    <div class="container" id="div3" style="display: none;">
        <form action="/addStation" method="post">
            <table class="table">
                <td>
                    <p>Input Station:</p>
                    <input type="text" class="form-control" name="station">
                </td>
                <td>
                    <br><br>
                    <button type="submit" class="btn btn-primary btn-block">Add</button>
                </td>
            </table>
        </form>


    </div><br>




        <a onclick="hidetxt('div5'); return false;" href="#" rel="nofollow">Add User</a>
        <div class="container" id="div5" style="display: none;">
            <form action="/addUser" method="post">
                <table class="table">
                    <td>
                        <p>Input Login:</p>
                        <input type="text" class="form-control" name="login">
                        <p>Input Password:</p>
                        <input type="text" class="form-control" name="password">
                        <p>Input First name:</p>
                        <input type="text" class="form-control" name="fname">
                        <p>Input Second name:</p>
                        <input type="text" class="form-control" name="sname">
                    </td>
                    <td>
                        <br><br>
                        <button type="submit" class="btn btn-primary btn-block">Add</button>
                    </td>
                </table>
            </form>

        </div><br>


        <a onclick="hidetxt('div6'); return false;" href="#" rel="nofollow">User's Editor</a>
        <div class="container" id="div6" style="display: none;">
            <form id="formEditorUser" action="javascript:void(0);" method="post">
                <table class="table">
                    <td>
                    <td>
                        <p>Users:</p>
                        <select size="7" class="form-control" name = "userSelect">

                            <c:forEach items="${userList}" var="elem" varStatus="varStatus">
                                <option value="${elem.userId}">${elem.login} ${elem.password} ${elem.firstname} ${elem.secondname}</option>
                            </c:forEach>

                        </select>

                    </td>
                    </td>
                    <td>
                        <br><br>
                        <button type="submit" class="btn btn-primary btn-block" name="deleteUser" onclick="document.getElementById('formEditorUser').action = '/deleteUser'; document.getElementById('formEditorUser').submit">Delete</button>
                        <button type="submit" class="btn btn-primary btn-block" name="editUser" onclick="document.getElementById('formEditorUser').action = '/editUser'; document.getElementById('formEditorUser').submit">Edit</button>
                    </td>
                </table>
            </form>


        </div><br>
        <a onclick="hidetxt('div7'); return false;" href="#" rel="nofollow">Add Train</a>
        <div class="container" id="div7" style="display: none;">
            <form action="/addTrain" method="post">
                <table class="table">
                    <td>
                        <p>Input Number:</p>
                        <input type="text" class="form-control" name="number">
                        <p>Input Model:</p>
                        <input type="text" class="form-control" name="model">
                        <p>Input Number of Places:</p>
                        <input type="number" class="form-control" name="nplaces">
                    </td>
                    <td>
                        <br><br>
                        <button type="submit" class="btn btn-primary btn-block">Add</button>
                    </td>
                </table>
            </form>


        </div><br>


        <!--<a onclick="hidetxt('div8'); return false;" href="#" rel="nofollow">Delete Train</a> -->
        <div class="container" id="div8" style="display: none;">
            <form action="/deleteTrain" method="post">
                <table class="table">
                    <td>
                    <td>
                        <p>Trains:</p>
                        <select size="7"class="form-control"  name = "trainSelect">

                            <c:forEach items="${trainList}" var="elem" varStatus="varStatus">
                                <option value="${elem.trainId}">${elem.number} ${elem.model} ${elem.numPlaces}</option>
                            </c:forEach>

                        </select>

                    </td>
                    </td>
                    <td>
                        <br><br>
                        <button type="submit" class="btn btn-primary btn-block">Delete</button>
                    </td>
                </table>
            </form>

        </div><br>

        <!--<a onclick="hidetxt('div2'); return false;" href="#" rel="nofollow">Delete Route</a>-->
        <div class="container" id="div2" style="display: none;">
            <form action="/deleteRoute" method="post">
                <table class="table">
                    <td>
                    <td>
                        <p>Stations:</p>
                        <select size="7" class="form-control" name = "routeSelect">

                            <c:forEach items="${routersList}" var="elem" varStatus="varStatus">
                                <option value="${elem.routeId}">${elem.date} ${elem.train.number}</option>
                            </c:forEach>

                        </select>

                    </td>
                    </td>
                    <td>
                        <br><br>
                        <button type="submit" class="btn btn-primary btn-block">Delete</button>
                    </td>
                </table>
            </form>


        </div><br>
        <!--<a onclick="hidetxt('div4'); return false;" href="#" rel="nofollow">Delete Station</a>-->
        <div class="container" id="div4" style="display: none;">
            <form action="/deleteStation" method="post">
                <table class="table">
                    <td>
                    <td>
                        <p>Stations:</p>
                        <select size="7" class="form-control" name = "stationSelect">

                            <c:forEach items="${stationsList}" var="elem" varStatus="varStatus">
                                <option value="${elem.stationId}">${elem.station}</option>
                            </c:forEach>

                        </select>

                    </td>
                    </td>
                    <td>
                        <button type="submit" class="btn btn-primary btn-block" >Delete</button>
                    </td>
                </table>
            </form>


        </div><br>

    </div>
    </div>

</body>
</html>
