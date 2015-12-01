$('.image-link').click(function () {
    $('.modal-image').attr("src", $(this).attr("src"));
    $('.modal-description').text($(this).parent().children('.image-description').text());
    $('.modal-title').text($(this).parent().children('.image-name').text());
    $('.like').children('.photoId').text($(this).attr("src"));


    isLiked($('.like-span'));
    $('#myModal').modal('show');
});


$('.like-span').click(function () {
    setGlyphIcon($(this));
});

function setGlyphIcon(param) {
    var photoId = param.parent().children('.photoId').text();
    $.ajax({
        url: photoId + '/switchLike',
        type: 'get',
        success: function (result) {
            if (result == "1") {
                param.addClass('glyphicon-heart-empty');
                param.removeClass('glyphicon-heart');
            } else {
                param.addClass('glyphicon-heart');
                param.removeClass('glyphicon-heart-empty');
            }
        }
    });
}

function isLiked(param) {
    var photoId = param.parent().children('.photoId').text();
    $.ajax({
        url: photoId + '/isLike',
        type: 'get',
        success: function (result) {
            if (result == "1") {
                param.addClass('glyphicon-heart');
            } else {
                param.addClass('glyphicon-heart-empty');
            }
        }
    });
}

