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

    <link rel="stylesheet" href="css/moderatorMainPage.css">

    <script src="js/main.js"></script>
</head>
<body onload="setFirstActive()">
    <header>
        <div class="container">
             <a href="FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE" class="logo">Port</a>
            <form id="logOutForm" action="FrontController" method="post">
                <input type="hidden" name="command" value="LOGOUT">
            </form>
            <nav>
                <ul>
                    <li><a>Your role: moderator</a></li>
                    <li><a>Your user id: ${user.id}</a></li>
                    <li><input type="submit" form="logOutForm" value="Logout"></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            <div class="tabs container">
                <button class="tablinks" onclick="openTab(event, 'Unblocked users')">Unblocked users</button>
                <button class="tablinks" onclick="openTab(event, 'Blocked user')">Blocked user</button>
            </div>
            <section id="Unblocked users" class="container mainView"> 
            	<h4>${errorMessage}</h4>
                <c:remove var="errorMessage" scope="application"/>
                <c:forEach var="userData" items="${unblockedUsers}">
                    <div class="info">
                        <h3>User #${userData.id}</h3>
                        <div>
                            <h4>Role:</h4>
                            <var>${userData.role.title}</var>
                        </div>
                        <div>
                            <h4>Login:</h4>
                            <var>${userData.login}</var>
                        </div>
                        <div>
                            <h4>Full name:</h4>
                            <var>${userData.fullName}</var>
                        </div>
                        <section class="buttons">
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="BLOCK_USER">
                                <input name="userIdToBlock" type="hidden" value="${userData.id}">
                                <input class="button" type="submit" value="Block">
                            </form>
                        </section>
                    </div>
                </c:forEach>
            </section>
            <section id="Blocked user" class="container mainView">
                <c:forEach var="userData" items="${blockedUsers}">
                    <div class="info">
                        <h3>User #${userData.id}</h3>
                        <div>
                            <h4>Role:</h4>
                            <var>${userData.role.title}</var>
                        </div>
                        <div>
                            <h4>Login:</h4>
                            <var>${userData.login}</var>
                        </div>
                        <div>
                            <h4>Full name:</h4>
                            <var>${userData.fullName}</var>
                        </div>
                        <section class="buttons">
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="UNBLOCK_USER">
                                <input name="userIdToUnblock" type="hidden" value="${userData.id}">
                                <input class="button" type="submit" value="Unblock">
                            </form>
                        </section>
                    </div>
                </c:forEach>
            </section>     
        </div>
    <footer></footer>
</body>