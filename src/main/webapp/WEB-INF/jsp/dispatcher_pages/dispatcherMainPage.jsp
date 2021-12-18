<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head lang="US">
    <meta charset="UTF-8">
    <link rel="icon" href="images/icon.png" type="image/png">
    <title>Port</title>
    <!--pages are controled main classes-->
    <link rel="stylesheet" href="css/main.css">
    <!--head of sight styles-->
    <link rel="stylesheet" href="css/header.css">
    <!--data table styles-->
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/tableHead.css">
    <!--control elements styles-->
    <link rel="stylesheet" href="css/scrollbars.css">
    <link rel="stylesheet" href="css/buttons.css">

    <link rel="stylesheet" href="css/dispatcherMainPage.css">

    <script src="js/main.js"></script>
</head>
<body onload="setFirstActive()">
    <header>
        <div class="container">
            <a href="index.html" class="logo">Port</a>
            <form id="logOutForm" action="FrontController" method="post">
                <input type="hidden" name="command" value="LOGOUT">
            </form>
            <nav>
                <ul>
                    <li><a>Your role: dispatcher</a></li>
                    <li><a>Your user id: ${user.id}</a></li>
                    <li><input type="submit" form="logOutForm" value="Logout"></li>
                    <li><a href="">About system</a></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            <div class="tabs container">
                <button class="tablinks" onclick="openTab(event, 'Statements for processing')">Statements for processing</button>
                <button class="tablinks" onclick="openTab(event, 'Captains')">Captains</button>
                <button class="tablinks" onclick="openTab(event, 'Ships')">Ships</button>
                <button class="tablinks" onclick="openTab(event, 'Piers')">Piers</button>
            </div>
            <section id="Statements for processing" class="container mainView"> 
                <c:forEach var="statement" items="${statementsToProcess}">
                    <div class="info">
                        <h3>Statement #${statement.id}</h3>
                        <div>
                            <h4>Captain Id:</h4>
                            <var>${statement.user.id}</var>
                        </div>
                        <div>
                            <h4>Ship Id:</h4>
                            <var>${statement.ship.id}</var>
                        </div>
                        <div>
                            <h4>Status:</h4>
                            <var>${statement.status.title}</var>
                        </div>
                        <div>
                            <h4>Type:</h4>
                            <var>${statement.type.title}</var>
                        </div>
                        <div>
                            <h4>Filing date:</h4>
                            <var>${statement.doDate}</var>
                        </div>
                        <section class="buttons">
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="SHOW_PROCESS_STATEMENT_PAGE">
                                <input name="statementIdToProcess" type="hidden" value="${statement.id}">
                                <input class="button" type="submit" value="Process">
                            </form>
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="REJECT_STATEMENT">
                                <input name="statementIdToReject" type="hidden" value="${statement.id}">
                                <input class="button" type="submit" value="Reject">
                            </form>
                        </section>
                    </div>
                </c:forEach>
            </section>
            <section id="Captains" class="container mainView"> 
                <c:forEach var="captainData" items="${captainsData}">
                    <div class="info">
                        <h3>Captain #${captainData.id}</h3>
                        <div>
                            <h4>Status:</h4>
                            <var>${captainData.status.title}</var>
                        </div>
                        <div>
                            <h4>Login:</h4>
                            <var>${captainData.login}</var>
                        </div>
                        <div>
                            <h4>Full name:</h4>
                            <var>${captainData.fullName}</var>
                        </div>
                    </div> 
                </c:forEach>
            </section>
            <section id="Ships" class="container mainView"> 
                <c:forEach var="shipData" items="${shipsData}">
                    <div class="info">
                        <h3>Ship #${shipData.id}</h3>
                        <div>
                            <h4>Title:</h4>
                            <var>${shipData.title}</var>
                        </div>
                        <%-- <div>
                            <h4>Captain Id:</h4>
                            <var>${shipData.captain}</var>
                        </div> --%>
                        <div>
                            <h4>Capacity:</h4>
                            <var>${shipData.capacity}</var>
                        </div>
                    </div> 
                </c:forEach>
            </section>
            <section id="Piers" class="container mainView">
                <c:forEach var="pierData" items="${piersData}">
                    <div class="info">
                        <h3>Pier #${pierData.id}</h3>
                        <div>
                            <h4>Pier status:</h4>
                            <var>${pierData.status}</var>
                        </div>
                        <div>
                            <h4>Pier capacity:</h4>
                            <var>${pierData.capacity}</var>
                        </div>
                        <div>
                            <h4>Residual capacity:</h4>
                            <var>${pierData.residualСapacity}</var>
                        </div>
                    </div> 
                </c:forEach>
            </section>     
        </div>
    <footer></footer>
</body>