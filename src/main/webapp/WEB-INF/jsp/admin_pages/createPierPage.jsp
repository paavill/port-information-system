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
    <!--control elements styles-->
    <link rel="stylesheet" href="css/scrollbars.css">
    <link rel="stylesheet" href="css/buttons.css">
    <link rel="stylesheet" href="css/enterFieldsStyles.css">

    <link rel="stylesheet" href="css/createPierPage.css">
</head>
<body>
    <header>
        <div class="container">
            <a href="FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE" class="logo">Port</a>
            <form id="logOutForm" action="FrontController" method="post">
                <input type="hidden" name="command" value="LOGOUT">
            </form>
            <nav>
                <ul>
                    <li><a>Your role: administrator</a></li>
                    <li><a>Your user id: ${user.id}</a></li>
                    <li><input type="submit" form="logOutForm" value="Logout"></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            <section class="container mainView"> 
                <div class="info">
                    <h3>Creating pier</h3>
                    <div class="enters">
                        <div class="entersTitles">
                            <h4 class="title">Capacity:</h4>
                        </div>
                        <form id="pierDataForm" class="entersFields" action="FrontController" method="post">
                            <input type="hidden" name="command" value="CREATE_PIER">
                            <input class="enter" required name="pierCapacity" type="number" min="1" max="1e21 - 1">  
                        </form>
                    </div>
                    <section class="buttons">
                        <input class="button" type="submit" form="pierDataForm" value="Create">
                        <a class="button" href="FrontController?command=SHOW_MAIN_ADMIN_PAGE">Cancel</a>
                    </section>
                    <h4>${errorMessage}</h4>
                </div> 
            </section>
        </div>
    <footer></footer>
</body>