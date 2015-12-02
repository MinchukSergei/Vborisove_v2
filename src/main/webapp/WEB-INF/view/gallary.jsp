<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="../../resources/js/image-info.js" defer></script>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.5/css/bootstrap.min.css' type='text/css' media='all'>
    <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href="../../resources/css/navigation.css">

</head>
<body>


<c:import url="header.jsp"/>

<div class="player">
    <audio controls="controls">
        Your browser does not support the <code>audio</code> element.
        <source src="http://online-radiorelax.tavrmedia.ua/RadioRelax_Nature?63" type="audio/wav">
    </audio>
</div>


<div class="gallary">
    <div class="flex-container">
        <c:forEach var="allPlaces" items="${places}" varStatus="status">

        <div class="flex1">
            <img src="${photos.get(status.index)}" class="image-link">
            <span class="image-name" hidden>${allPlaces.name}</span>
            <span class="image-description" hidden>${allPlaces.description}</span>
        </div>
        </c:forEach>
    </div>
</div>

<div class="container modal-container">
    <!-- Modal -->
    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <span class="modal-title"></span>
                </div>
                <div class="modal-body">
                    <img class="modal-image" src="">
                    <div class="like">
                        <span class="glyphicon like-span" id="id-like"></span>
                        <span class="photoId" hidden></span>
                    </div>
                </div>
                <div class="modal-footer">
                    <span class="modal-description"></span>
                </div>
            </div>

        </div>
    </div>

</div>


<footer>
    <div class="container">
        <div class="row">
            <p>Copyright © 2015 Minchuk Sergei.</p>
        </div>
    </div>
</footer>

</body>
</html>
