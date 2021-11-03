<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Port</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/authorization.css">
    <script src="js/main.js"></script>
</head>
<body>
    <header>
        <div class="container">
            <a href="index.html" class="logo">${logoText}</a>
        </div>
    </header>

    <div class="main login">
        <div class="mainView">
            <h3>${authorizationText}</h3>
            <div>
                <div class="enter">
                    <h4>${loginText}</h4>
                    <input type="text" placeholder="${placeholderLoginText}">
                </div>
                <div class="enter">
                    <h4>${passwordText}</h4>
                    <input type="password" placeholder="${placeholderPasswordText}">
                </div>
            </div>
            <div class="buttons">
                <a href="FrontController?command=LOGIN">${enterButtonText}</a>
                <a href="FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE">${cancelButtonText}</a>
            </div>
                <h5>${errorText}</h5>
        </div>
    </div>

</body>