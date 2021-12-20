<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<link rel="stylesheet" href="css/createUserPage.css">
</head>
<body>
	<header>
		<div class="container">
			<a href="index.html" class="logo">Port</a>
			<form id="logOutForm" action="/FrontController" method="post">
				<input type="hidden" name="command" value="LOGOUT">
			</form>
			<nav>
				<ul>
					<li><a>Your role: dispatcher</a></li>
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
				<h3>Processing statement #${statement.id}</h3>
				<div class="enters">
					<div class="entersTitles">
						<h4 class="title">User Id:</h4>
						<h4 class="title">Ship Id:</h4>
						<h4 class="title">Type:</h4>
						<h4 class="title">Filing date:</h4>
						<h4 class="title">Pier:</h4>
					</div>
					<form id="statementDataForm" class="entersFields"
						action="FrontController" method="post">
						<input type="hidden" name="command" value="APPLY_STATEMENT">
						<var class="title">${statement.user.id}</var>
						<var class="title">${statement.ship.id}</var>
						<var class="title">${statement.type.title}</var>
						<var class="title">${statement.doDate}</var>
						<var class="title">${statement.user.id}</var>
						<input name="statementIdToProcess" type="hidden" value="${statement.id}">
						<select class="enter" name="selectedPier">
							<c:forEach var="pier" items="${piersData}">
								<option>${pier.id}</option>
							</c:forEach>
						</select>
					</form>
				</div>
				<section class="buttons">
					<input class="button" type="submit" form="statementDataForm"
						value="Apply"> <a class="button"
						href="FrontController?command=SHOW_MAIN_DISPATCHER_PAGE">Cancel</a>
				</section>
			</div>
		</section>
	</div>
	<footer></footer>
</body>