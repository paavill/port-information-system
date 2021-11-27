<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head lang="US">
    <meta charset="UTF-8">
    <title>Port</title>
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
            <a href="index.html" class="logo">Port</a>
            <nav>
                <ul>
                    <li><a href="FrontController?command=SHOW_LOGIN_PAGE">Authorization</a></li>
                    <li><a href="">About system</a></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            <div class="tabs container">
                <button class="tablinks" onclick="openTab(event, 'Port')">Port</button>
                <button class="tablinks" onclick="openTab(event, 'Piers')">Piers</button>
            </div>
            <section id="Port" class="container mainView"> 
                <div class="info">
                    <h3>${portData.portName}</h3>
                    <div>
                        <h4>Piers:</h4>
                        <var>${portData.piarCount}</var>
                    </div>
                    <div>
                        <h4>Free piers:</h4>
                        <var>${portData.freePiarCount}</var>
                    </div>
                </div> 
            </section>
            <section id="Piers" class="container mainView">
                <c:forEach var="pierData" items="${piersData}">
                    <div class="info">
                        <h3>Piers #${pierData.id}</h3>
                        <div>
                            <h4>Pier status:</h4>
                            <var>${pierData.status}</var>
                        </div>
                        <div>
                            <h4>Pier capacity:</h4>
                            <var>${pierData.capacity}</var>
                        </div>
                    </div> 
                </c:forEach>
            </section>     
        </div>
    <footer></footer>
</body>