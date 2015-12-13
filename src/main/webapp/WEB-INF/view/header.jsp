<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-fixed-top navbar-default">
        <a class="navbar-brand"><img src="../../resources/img/vb.png"></a>
        <div class="container-fluid">
        <sec:authorize access="isAuthenticated()">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <div class="collapse navbar-collapse navbar-right" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/gallary"/>">Главная</a></li>
                <li><a href="<c:url value="/best"/>">Лучшие места</a></li>
                <li><a href="<c:url value="/myPhotos"/>">Любимый уголок</a></li>
                <li><a href="<c:url value="/j_spring_security_logout"/>">Выйти</a></li>
            </ul>
        </div>
        </sec:authorize>
        </div>
</nav>