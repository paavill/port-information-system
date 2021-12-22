<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <link rel="icon" href="images/icon.png" type="image/png">
    <title>Port</title>
    <link rel="stylesheet" href="css/header.css">
    
    <link rel="stylesheet" href="css/main.css">
    
    <link rel="stylesheet" href="css/buttons.css">
    <link rel="stylesheet" href="css/enterFieldsStyles.css">
    <link rel="stylesheet" href="css/scrollbars.css">
    <!--if something broke put next style before buttons-->
    <link rel="stylesheet" href="css/undefinedCommandPage.css">
</head>
<body>
    <header>
        <div class="container">
            <a href="FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE" class="logo">Port</a>
        </div>
    </header>

    <div class="main login">
        <div class="mainView">
            <h3>Undefined command</h3>
                <div>${errorCommand}</div>
	            <div class="buttons">
	                <a class ="button" href="FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE">OK</a>
	            </div>
        </div>
    </div>

</body>