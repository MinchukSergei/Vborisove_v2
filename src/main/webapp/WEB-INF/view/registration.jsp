<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!--< page contentType="text/html;charset=UTF-8" language="java" %> -->

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
    <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.5/css/bootstrap.min.css' type='text/css' media='all'>
    <link rel='stylesheet' href="../../resources/css/navigation.css">
    <link rel='stylesheet' href="../../resources/css/registration.css">
</head>
<body>

<c:import url="header.jsp"/>

<div class="col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-1">
    <form action="<c:url value="/registration"/>" method="POST">
          <div class="container-fluid">
            <div class="control-group" id="first-control">
              <div class="controls">
                <label>Name</label>
                <input name="name" type="text" placeholder="Enter you name" class="form-control">
              </div>
            </div>

            <div class="control-group">
              <div class="controls">
                <label>Username</label>
                <input name="username" type="text" placeholder="Enter username" class="form-control">
              </div>
            </div>

            <div class="control-group">
              <div class="controls">
                <label>E-mail</label>
                <input name="email" type="text" placeholder="Please provide your E-mail" class="form-control">
              </div>
            </div>

            <div class="control-group">
              <div class="controls">
                  <label>Password</label>
                  <input name="password" type="password" placeholder="Password" class="form-control">
              </div>
            </div>

            <div class="control-group">
              <div class="col-md-4 col-md-offset-4 col-xs-6 col-xs-offset-3">
                <div class="controls">
                  <button type="submit" class="btn btn-primary btn-block">Register</button>
                </div>
              </div>
            </div>
          </div>
    </form>
</div>

<c:import url="footer.jsp"/>

</body>
</html>

