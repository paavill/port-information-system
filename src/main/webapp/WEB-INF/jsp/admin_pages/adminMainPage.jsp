<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head lang="US">
    <meta charset="UTF-8">
    <link rel="icon" href="images/icon.png" type="image/png">
    <title>Ports</title>
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
    <link rel="stylesheet" href="css/adminMainPage.css">
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
                    <li><a>Your role: administrator</a></li>
                    <li><a>Your user id: ${user.id}</a></li>
                    <li><input type="submit" form="logOutForm" value="Logout"></li>
                    <li><a href="">About system</a></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            <div class="tabs container">
                <button class="tablinks" onclick="openTab(event, 'Users')">Users</button>
                <button class="tablinks" onclick="openTab(event, 'Piers')">Piers</button>
                <button class="tablinks" onclick="openTab(event, 'Ships')">Ships</button>
            </div>
            <section id="Users" class="container mainView"> 
                <div class="buttons">
                    <a class="button" href="FrontController?command=SHOW_CREATE_USER_PAGE">Create</a>
                </div>
                <c:forEach var="userData" items="${usersData}">
                    <div class="info">
                        <h3>User #${userData.id}</h3>
                        <div>
                            <h4>Status:</h4>
                            <var>${userData.status.title}</var>
                        </div>
                        <div>
                            <h4>Role:</h4>
                            <var>${userData.role.title}</var>
                        </div>
                        <div>
                            <h4>Login:</h4>
                            <var>${userData.login}</var>
                        </div>
                        <div>
                            <h4>Password:</h4>
                            <var>${userData.password}</var>
                        </div>
                        <div>
                            <h4>Full name:</h4>
                            <var>${userData.fullName}</var>
                        </div>
                        <section class="buttons">
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="DELETE_USER">
                                <input name="userIdToDelete" type="hidden" value="${userData.id}">
                                <input class="button" type="submit" value="Delete">
                            </form>
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="SHOW_EDIT_USER_PAGE">
                                <input name="userIdToEdit" type="hidden" value="${userData.id}">
                                <input class="button" type="submit" value="Edit">
                            </form>
                        </section>
                    </div> 
                </c:forEach>
            </section>
            <section id="Piers" class="container mainView">
            	<div class="buttons">
                     <a class="button" href="FrontController?command=SHOW_CREATE_PIER_PAGE">Create</a>
                </div>
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
                        <section class="buttons">
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="DELETE_PIER">
                                <input name="pierIdToDelete" type="hidden" value="${pierData.id}">
                                <input class="button" type="submit" value="Delete">
                            </form>
                        </section>
                    </div> 
                </c:forEach>
            </section>
            <section id="Ships" class="container mainView">
            	<div class="buttons">
                        <a class="button" href="FrontController?command=SHOW_CREATE_SHIP_PAGE">Create</a>
                </div>
                <c:forEach var="shipData" items="${shipsData}">
                    <div class="info">
                        <h3>Ship #${shipData.id}</h3>
                        <div>
                            <h4>Ship title:</h4>
                            <var>${shipData.title}</var>
                        </div>
                        <section class="buttons">
                            <form action="FrontController" method="post">
                                <input name="command" type="hidden" value="DELETE_SHIP">
                                <input name="shipIdToDelete" type="hidden" value="${shipData.id}">
                                <input class="button" type="submit" value="Delete">
                            </form>
                        </section>
                    </div> 
                </c:forEach>
            </section>    
        </div>
    <footer></footer>
</body>