<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script src="../../resources/js/image-comment.js" defer></script>
    <link rel='stylesheet' href='webjars/bootstrap/3.3.5/css/bootstrap.min.css' type='text/css' media='all'>
    <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
    <script src="webjars/jquery-validation/1.14.0/jquery.validate.min.js"></script>
    <script src="webjars/jquery-validation/1.14.0/jquery.validate.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href="../../resources/css/navigation.css">
    <link rel='stylesheet' href="../../resources/css/best.css">
    <link rel='stylesheet' href="../../resources/css/validate.css">
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
        <c:forEach var="topPlaces" items="${places}" varStatus="status">
            <%--<div class="flex-image">--%>
                <%--<img src="${photos.get(status.index)}" class="image-link">--%>
                <%--<span class="image-name" hidden>${allPlaces.name}</span>--%>
                <%----%>
            <%--</div>--%>

            <div class="flex">
                <div class="thumbnail">
                <div class="flex-image">
                    <img src="${photos.get(status.index)}" class="image-link">
                </div>
                </div>


                <div class="image-description">
                    <div class="panel panel-info">
                        <div class="panel-heading">${topPlaces.name}</div>
                        <div class="panel-body">
                                ${topPlaces.description}
                        </div>
                    </div>
                </div>

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
                    <span class="modal-title" id="placeName"></span>
                </div>
                <div class="modal-body">
                    <img class="modal-image" src="">
                    <div class="like">
                        <span class="glyphicon like-span" id="id-like"></span>
                        <span class="photoId" hidden></span>
                    </div>
                </div>

                <div class="panel panel-default">
                    <div class="panel-heading" id="placeDescription"></div>
                    <ul class="list-group" id="comments">
                    </ul>
                </div>

                <div class="modal-footer">
                    <form id="commentValid">
                        <div class="controls">
                            <textarea id="commentSrc"
                              name="commentArea" class="form-control required" rows="3"
                              placeholder="Введите комментарий..." maxlength="600"></textarea>
                        </div>
                        <div class="controls">
                            <button type="submit" id="btn-add" class="btn btn-primary">Добавить комментарий</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<c:import url="footer.jsp"/>

</body>
</html>