<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<script src="webjars/jquery/2.1.4/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link rel='stylesheet' href='webjars/bootstrap/3.3.5/css/bootstrap.min.css' type='text/css' media='all'>
	<link rel='stylesheet' href="resources/css/enter.css">
	<link rel='stylesheet' href="resources/css/navigation.css">

</head>
<body>
<c:import url="WEB-INF/view/header.jsp"/>

<div class="container">
	<div class="page-header">
	  <h1>Добро пожаловать на гениальный сайт!</h1>
	</div>
	  <a class="btn btn-primary btn-lg" href="login" role="button">Войти</a>
	  <a class="btn btn-primary btn-lg" href="registration" role="button">Зарегистрироваться</a>
</div>

<c:import url="WEB-INF/view/footer.jsp"	/>

</body>
</html>
