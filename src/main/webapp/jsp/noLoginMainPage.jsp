<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<head lang="US">
    <meta charset="UTF-8">
    <title>${titleText}</title>
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
            <a href="index.html" class="logo">${logoText}</a>
            <nav>
                <ul>
                    <li><a href="FrontController?command=SHOW_LOGIN_PAGE">${authorizationText}</a></li>
                    <li><a href="">${aboutSystemText}</a></li>
                </ul>
            </nav>
        </div>
    </header>
        <div class="main">
            
            <div class="tabs container">
                <button class="tablinks" onclick="openTab(event, '${aboutPortInformationText}')">${aboutPortInformationText}</button>
                <button class="tablinks" onclick="openTab(event, '${aboutPiersInformationText}')">${aboutPiersInformationText}</button>
            </div>

            <section id="${aboutPortInformationText}" class="container mainView">
                   
                <div class="info">
                    <h3>${portData.portName}</h3>
                    <div>
                        <h4>${piarCountText}</h4>
                        <var>${portData.piarCount}</var>
                    </div>
                    <div>
                        <h4>${freePiarCountText}</h4>
                        <var>${portData.freePiarCount}</var>
                    </div>
                    <div>
                        <h4>${pilotCountText}</h4>
                        <var>${portData.pilotCount}</var>
                    </div>
                    <div>
                        <h4>${freePilotCountText}</h4>
                        <var>${portData.freePilotCount}</var>
                    </div>
                </div> 

            </section>

            <section id="${aboutPiersInformationText}" class="container mainView">
                <c:forEach var="pierData" items="${piersData}">
                    <div class="info">
                        <h3>${pierIdText} ${pierData.id}</h3>
                        <div>
                            <h4>${pierStatusText}</h4>
                            <var>${pierData.status}</var>
                        </div>
                        <div>
                            <h4>${pierCapacityText}</h4>
                            <var>${pierData.capacity}</var>
                        </div>
                    </div> 
                </c:forEach>

            </section>
            
        </div>
        
    <footer></footer>
</body>