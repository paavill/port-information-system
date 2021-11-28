<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Port</title>
    <link rel="stylesheet" href="css/header.css">
    
    <link rel="stylesheet" href="css/main.css">
    
    <link rel="stylesheet" href="css/buttons.css">
    <link rel="stylesheet" href="css/enterFieldsStyles.css">
    <!--if something broke put next style before buttons-->
    <link rel="stylesheet" href="css/authorization.css">
    <script src="/js/main.js"></script>
</head>
<body>
    <header>
        <div class="container">
            <a href="index.html" class="logo">Port</a>
        </div>
    </header>

    <div class="main login">
        <div class="mainView">
            <h3>Authorization</h3>
            <form action="FrontController" method="post">
            	<input name="command" value="LOGIN" type="hidden">
	            <div>
	                <div>
	                    <h4>Login:</h4>
	                    <input class="enter" name="login" type="text" placeholder="Enter login">
	                </div>
	                <div>
	                    <h4>Password:</h4>
	                    <input class="enter" name="password" type="password" placeholder="Enter password">
	                </div>
	            </div>
	            <div class="buttons">
	                <input class="button" type="submit" value="Enter">
	                <a class ="button" href="FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE">Cancel</a>
	            </div>
	                <h5>${errorText}</h5>
	         </form>    
        </div>
    </div>

</body>