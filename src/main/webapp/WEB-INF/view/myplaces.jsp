<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel='stylesheet' href='webjars/bootstrap/3.3.5/css/bootstrap.min.css' type='text/css' media='all'>
    <script src="webjars/jquery/2.1.4/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href="../../resources/css/myplaces.css">
    <link rel='stylesheet' href="../../resources/css/navigation.css">
</head>
<body>

<c:import url="header.jsp"/>

<div class="my-places-table">
    <div class="container">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">Ваши места</div>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Имя</th>
                    <th>Изображение</th>
                    <th>Описание</th>
                    <th>Редактировать</th>
                    <th>Удалить</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach var="place" items="${myPlaces}" varStatus="status">
                        <tr>
                            <td>${place.name}</td>
                            <td><div class="td-image"><img src="${myPhotos.get(status.index)}"></div></td>
                            <td><textarea class="form-control" rows="5" readonly>${place.description}</textarea></td>
                            <td><span class="glyphicon glyphicon-edit"></span></td>
                            <td><span class="glyphicon glyphicon-remove"></span></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="container">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="newPlaceBtn">
                Добавить новое место
            </button>
        </div>
    </div>
</div>



<div class="modal-container">
    <!-- Modal -->

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">New place</h4>
                </div>
                <form action="<c:url value="/myPhotos"/>" method="POST" enctype="multipart/form-data">
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="name">Название места</label>
                            <input class="form-control" id="name" name="name" placeholder="Place name">
                        </div>
                        <div class="form-group">
                            <label for="descr">Описание вашего места</label>
                            <textarea id="descr" class="form-control" rows="5"
                                      name="description" placeholder="Максимум 600 символов"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="inputFile">Выберите файл</label>
                            <input type="file" name="photo" id="inputFile" accept="image/jpeg, image/png">

                            <p class="help-block">Выберите картинку вашего места</p>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary">Добавить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</div>
<c:import url="footer.jsp"/>

</body>
</html>
