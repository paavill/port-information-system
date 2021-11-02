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
            <a href="index.html" class="logo">Port</a>
        </div>
    </header>

    <div class="main login">
        <div class="mainView">
            <h3>Авторизация</h3>
            <div>
                <div class="enter">
                    <h4>Логин:</h4>
                    <input type="text" placeholder="Enter some text">
                </div>
                <div class="enter">
                    <h4>Пароль:</h4>
                    <input type="password" placeholder="Enter some text">
                </div>
            </div>
            <div class="buttons">
                <a href="index.html">Войти</a>
                <a href="FrontController?command=SHOW_MAIN_NO_LOGIN_PAGE">Отмена</a>
            </div>
                <h5>место для вывода сообщений об ошибках</h5>
        </div>
    </div>

</body>