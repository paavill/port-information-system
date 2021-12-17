<!DOCTYPE html>
<head lang="US">
    <meta charset="UTF-8">
    <link rel="icon" href="images/icon.png" type="image/png">
    <title>Port</title>
    <!--pages are controled main classes-->
    <link rel="stylesheet" href="css/main.css">
    <!--head of sight styles-->
    <link rel="stylesheet" href="css/header.css">
    <!--control elements styles-->
    <link rel="stylesheet" href="css/scrollbars.css">
    <link rel="stylesheet" href="css/buttons.css">
    <link rel="stylesheet" href="css/enterFieldsStyles.css">

    <link rel="stylesheet" href="css/createStatementPage.css">
</head>
<body>
    <header>
        <div class="container">
            <a href="index.html" class="logo">Port</a>
            <form id="logOutForm" action="/FrontController" method="post">
                <input type="hidden" name="command" value="LOGOUT" />
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
                <div class="info">
                    <h3>Creating statement</h3>
                    <div class="enters">
                        <div class="entersTitles">
                            <h4 class="title">User id:</h4>
                            <h4 class="title">Ship id:</h4>
                            <h4 class="title">Type:</h4>
                        </div>
                        <form id="statementData" class="entersFields" action="/FrontController" method="post">
                            <input type="hidden" name="command" value="CREATE_STATEMENT">
                            <var class="title">${user.id}</var>
                            <var class="title">${ship.id}</var>
                            <select class="enter" name="role">
                                <option>ENTER</option>
                                <option>EXIT</option>
                            </select>
                        </form>
                    </div>
                    <section class="buttons">
                        <input class="button" type="submit" form="userData" value="Create">
                        <a class="button" href="/FrontController?command=SHOW_CAPTAIN_MAIN_PAGE">Cancel</a>
                    </section>
                </div> 
            </section>
        </div>
    <footer></footer>
</body>