<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head lang="US">
    <link rel="icon" href="images/icon.png" type="image/png">
    <meta charset="UTF-8">
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

    <link rel="stylesheet" href="css/captainUnloadPage.css">

    <script src="js/captainUnload.js"></script>
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
                    <li><a>Your role: captain</a></li>
                    <li><a>Your user id: ${user.id}</a></li>
                    <li><input type="submit" form="logOutForm" value="Logout"></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            <section class="container mainView"> 
                <h3>Product unloading</h3>
                
                <form id="unloadForm" action="FrontController" method="post">
                    <input type="hidden" name="command" value="UNLOAD_PRODUCTS">
                    <input id="input-products" type="hidden" name="jsonProducts">
                </form>

                <div id="dynamic-div">
                    <div class="enters">
                        <div class="entersTitles">
                            <h4 class="title">Titile:</h4>
                            <h4 class="title">Number:</h4>
                        </div>
                        <div class="entersFields">
                            <input class="enter" required name="title" type="text" placeholder="Enter title">
                            <input class="enter" required name="number" type="number" placeholder="Enter number">
                        </div>
                    </div>
                </div>
                
                <div class="buttons">
                    <input class="button" type="submit" onclick="handleUnloadClick()" form="unloadForm" value="Unload products">
                    <input class="button" type="button" onclick="addProduct()" value="Add products">
                </div>
            </section>   
        </div>
    <footer></footer>
</body>