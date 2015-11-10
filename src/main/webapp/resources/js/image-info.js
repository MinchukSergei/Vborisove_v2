$('.image-link').click(function () {
    $('.modal-image').attr("src", $(this).attr("src"));
    $('.modal-description').text($(this).parent().children('.image-description').text());
    var div = $('#id-like');
    if ($(this).parent().children('.liked').text() == "1") {
        div.addClass('glyphicon-heart');
        div.removeClass('glyphicon-heart-empty');
    } else {
        div.addClass('glyphicon-heart-empty');
        div.removeClass('glyphicon-heart');
    }
    $('#myModal').modal('show');
});


$('.like-span').click(function () {
    $(this).toggleClass('glyphicon-heart-empty');
    $(this).toggleClass('glyphicon-heart');
});