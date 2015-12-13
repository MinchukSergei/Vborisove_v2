$('.image-link').click(function () {
    $('.modal-image').attr("src", $(this).attr("src"));
    $('#placeName').text($(this).parent().parent().parent().children('.image-description')
        .children('.panel').children('.panel-heading').text());
    $('#placeDescription').text($(this).parent().parent().parent().children('.image-description')
        .children('.panel').children('.panel-body').text());
    $('.like').children('.photoId').text($(this).attr("src"));
    isLiked($('.like-span'));
    $('#myModal').modal('show');

    var photoId = $('.photoId').text();
    getComments(photoId);
    $('#commentSrc-error').remove();
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

$('#commentValid').validate({
    errorClass: "my-error-class",
    validClass: "my-valid-class",
    rules: {
        commentSrc: {
            required: true,
            maxlength: 600
        }
    }
});

$('#btn-add').click(function() {
    if ($('#commentValid').valid()) {
        var photoId = $('.photoId').text();

        $.ajax({
            url: photoId + '/addComment',
            type: 'post',
            data: {
                'commentSrc': $('#commentSrc').val()
            },
            success: function () {
                $('#commentSrc').val("");
                getComments(photoId);
            }
        });
    }
    return false;
});

function getComments(param) {
    $('#comments').empty();
    $.ajax({
        url: param + '/getComments',
        type: 'get',
        contentType: 'application/json; charset=UTF-8',
        success: function(result) {
            console.info(result);
            $.each(result, function() {
                console.info($(this)[0].left + ": " + $(this)[0].right);
                $("<div/>", {
                    'class': "list-group-item",
                    'html' : "<h4 class=list-group-item-heading>" + $(this)[0].right + "</h4>" +
                    "<p class=list-group-item-text>" + $(this)[0].left + "</p>"
                }).appendTo($('#comments'));
            });
        }
    });
}

