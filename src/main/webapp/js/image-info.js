$('.image-link').click(function () {
    $('.modal-image').attr("src", $(this).attr("src"));
    $('.modal-description').text($(this).parent().children('.image-description').text());
    if ($(this).parent().children('.liked').text() == "1") {
        $('#id-like').addClass('glyphicon-heart');
        $('#id-like').removeClass('glyphicon-heart-empty');
    } else {
        $('#id-like').addClass('glyphicon-heart-empty');
        $('#id-like').removeClass('glyphicon-heart');
    }
    $('#myModal').modal('show');
});


$('.like-span').click(function () {
    $(this).toggleClass('glyphicon-heart-empty');
    $(this).toggleClass('glyphicon-heart');
});