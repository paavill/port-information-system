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
    <link rel="stylesheet" href="css/enterFieldsStyles.css">

    <link rel="stylesheet" href="css/captainMainPageStatementProcess.css">
    <script src="js/main.js"></script>
</head>
<body onload="setFirstActive()">
    <header>
        <div class="container">
            <a href="index.html" class="logo">Port</a>
            <form id="logOutForm" action="/FrontController" method="post">
                <input type="hidden" name="command" value="LOGOUT" />
            </form>
            <nav>
                <ul>
                    <li><a>Your role: captain</a></li>
                    <li><a>Your user id: ${user.id}</a></li>
                    <li><input type="submit" form="logOutForm" value="Logout"></li>
                    <li><a href="">About system</a></li>
                </ul>
            </nav>
        </div>
    </header>
    <div class="main">
        <div class="verticalContainer">
            <div class="container statement">
                <h3>Statement in process</h3>
                <div class="enters">
                    <div class="entersTitles">
                        <h4 class="title">Id:</h4>
                        <h4 class="title">State:</h4>
                        <h4 class="title">Type:</h4>    
                    </div>
                    <form id="statementData" class="entersFields" action="/FrontController" method="post">
                        <input type="hidden" name="command" value="CANCEL_STATEMENT">
                        <input type="hidden" name="statementId" value="${stetement.id}">
                        <h4 class="title">${statement.id}</h4>
                        <h4 class="title">${statement.status.title}</h4>
                        <h4 class="title">${statement.type.title}</h4>
                    </form>
                </div>
                <section class="buttons">
                    <input class="button" type="submit" form="statementData" value="Cancel">
                </section>
                <h5>${statementErrorMessage}</h5>
            </div>
        </div>
        <div class="verticalContainer">
            <div class="tabs container">
                <button class="tablinks" onclick="openTab(event, 'Old statements to enter')">Old statements to enter</button>
                <button class="tablinks" onclick="openTab(event, 'Old statements to exit')">Old statements to exit</button>
            </div>
            <section id="Old statements to enter" class="container mainView"> 
                <c:forEach var="statement" items="${enterStatements}">
                    <div class="info">
                        <h3>Statement #${statement.id}</h3>
                        <div>
                            <h4>Ship:</h4>
                            <var>${statement.ship}</var>
                        </div>
                        <div>
                            <h4>Pier:</h4>
                            <var>${statement.pier}</var>
                        </div>
                        <div>
                            <h4>Filing time:</h4>
                            <var>${statement.password}</var>
                        </div>
                        <div>
                            <h4>Lead time:</h4>
                            <var>${statement.fullName}</var>
                        </div>
                    </div> 
                </c:forEach>
            </section>
            <section id="Old statements to exit" class="container mainView">
                <c:forEach var="statement" items="${exitStatements}">
                    <div class="info">
                        <h3>Statement #${statement.id}</h3>
                        <div>
                            <h4>Ship:</h4>
                            <var>${statement.ship}</var>
                        </div>
                        <div>
                            <h4>Pier:</h4>
                            <var>${statement.pier}</var>
                        </div>
                        <div>
                            <h4>Filing time:</h4>
                            <var>${statement.password}</var>
                        </div>
                        <div>
                            <h4>Lead time:</h4>
                            <var>${statement.fullName}</var>
                        </div>
                    </div> 
                </c:forEach>
            </section> 
        </div>   
    </div>
    <footer></footer>
</body>