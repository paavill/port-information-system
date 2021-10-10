<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head lang="RU">
    <meta charset="UTF-8">
    <title>Порт</title>
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/table.css">
    <link rel="stylesheet" href="css/scrollbars.css">
    <link rel="stylesheet" href="css/tableHead.css">
    <script src="js/main.js"></script>
</head>
<body onload="setFirstActive()">
    <header>
        <div class="container">
            <a href="index.html" class="logo">Порт</a>
            <nav>
                <ul>
                    <li><a href="FrontController?command=SHOW_LOGIN_PAGE">Авторизация</a></li>
                    <li><a href="">О системе</a></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            
            <div class="tab container">
                <c:forEach var="oneTab" items="${tabs}">
                    <button class="tablinks" onclick="openCity(event, '${oneTab.name}')">${oneTab.name}</button>
                </c:forEach>
            </div>

            <c:forEach var="oneTab" items="${tabs}">
                <section id="${oneTab.name}" class="container mainView tabcontent">
                    
                    <c:forEach items="${oneTab.data}" var="d">    
                        <div class="info">
                            <h3>${d.portName}</h3>
                            <div>
                                <h4>Общее кол-во пирсов:</h4>
                                <var>${d.piarCount}</var>
                            </div>
                            <div>
                                <h4>Кол-во свободных пирсов:</h4>
                                <var>${d.freePiarCount}</var>
                            </div>
                            <div>
                                <h4>Общее кол-во лоцманов:</h4>
                                <var>${d.pilotCount}</var>
                            </div>
                            <div>
                                <h4>Кол-во свободных лоцманов:</h4>
                                <var>${d.freePilotCount}</var>
                            </div>
                        </div> 
                    </c:forEach>

                </section>
            </c:forEach>
            
        </div>
        
    <footer></footer>
</body>