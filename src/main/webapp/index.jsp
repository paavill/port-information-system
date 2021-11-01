<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<head lang="US">
    <meta charset="UTF-8">
    <title>Порт</title>
</head>
    <body>
        <jsp:forward page="/FrontController">
            <jsp:param name="command" value="SHOW_MAIN_NO_LOGIN_PAGE"/>
        </jsp:forward>
    </body>
</html>