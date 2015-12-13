<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--< page contentType="text/html;charset=UTF-8" language="java" %> -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="../../resources/js/login-validate.js" defer></script>
    <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
    <script src="webjars/jquery-validation/1.14.0/jquery.validate.min.js"></script>
    <script src="webjars/jquery-validation/1.14.0/jquery.validate.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.5/css/bootstrap.min.css' type='text/css' media='all'>
    <link rel='stylesheet' href="../../resources/css/navigation.css">
    <link rel='stylesheet' href="../../resources/css/login.css">
    <link rel='stylesheet' href="../../resources/css/validate.css">
</head>
<body>

<c:import url="header.jsp"/>


<div class="col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-1">
    <c:url var="loginUrl" value="/j_spring_security_check"/>
    <form action="${loginUrl}" method="POST" id="login-form">
        <div class="container-fluid">


            <div class="control-group" id="first-control">
                <div class="controls">
                    <label>Username</label>
                    <input name="username" type="text" placeholder="Enter your username" class="form-control">
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <label>Password</label>
                    <input name="password" type="password" placeholder="Enter your password" class="form-control">
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-primary center-block">Log in</button>
                </div>
            </div>

            <div class="control-group controls">
                <c:if test="${not empty error}">
                    <div class="alert alert-danger" role="alert">
                        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                        <span class="sr-only">Error:</span>
                        Invalid username or password
                    </div>
                </c:if>
            </div>
        </div>
    </form>
</div>

<c:import url="footer.jsp"/>

</body>
</html>

