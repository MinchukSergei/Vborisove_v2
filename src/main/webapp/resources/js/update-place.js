$('.image-upd').click(function () {
    var id = $(this).parent().children('#plId').text();

    $('#nameUpd').val($(this).parent().children('#plName').text());
    $('#descrUpd').val($(this).parent().children('#plDescr').text());
    $('#imageSrcDesr').attr("src", $(this).parent().children('#plSrc').text());
    var iu = '/myPhotos/' + id + '/update';
    $('#updatePlaceForm').attr('action', iu);
});

//$('#newPlaceBtn').click(function () {
//    $('#inputFile-error').remove();
//    $('#name-error').remove();
//    $('#descr-error').remove();
//});

//$('#updatePlaceBtn').click(function () {
//    $('#nameUpd-error').remove();
//    $('#descrUpd-error').remove();
//    $('#inputFileUpd-error').remove();
//});
