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

    <link rel="stylesheet" href="css/captainLoadPage.css">

    <script src="js/captainLoad.js"></script>
</head>
<body>
    <header>
        <div class="container">
            <a href="index.html" class="logo">Port</a>
            <form id="logOutForm" action="FrontController" method="post">
                <input type="hidden" name="command" value="LOGOUT">
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
            <section class="container mainView"> 
                <h3 class="processTitle">Product unloading</h3>
                
                <form id="loadForm" action="FrontController" method="post">
                    <input type="hidden" name="command" value="LOAD_PRODUCTS">
                    <input id="input-products" type="hidden" name="jsonProducts">
                </form>
                
                <div id="products-table">     
                    <c:forEach var="product" items="${productsData}">
                        <div class="info">
                            <h3>Product title: ${product.title}</h3>
                            <div class="enters">
                                <div class="entersTitles">
                                    <h4 class="title">Number of products:</h4>
                                    <h4 class="title">Product title:</h4>
                                    <h4 class="title">How many products to load:</h4>
                                </div>

                                <div class="entersFields">
                                    <var class="title">${product.count}</var>
                                    <var class="title">${product.title}</var>
                                    <input class="enter" required type="number" placeholder="Enter number">
                                    <input type="hidden" value="${product.title}">
                                </div>
                            </div>
                        </div> 
                    </c:forEach>
                </div>
                
                <div class="buttons">
                    <input class="button" type="submit" onclick="handleLoadClick()" form="loadForm" value="Load products">
                </div>
            </section>   
        </div>
    <footer></footer>
</body>