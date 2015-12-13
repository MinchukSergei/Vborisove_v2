$('.image-upd').click(function () {
    var id = $(this).parent().children('#plId').text();
    console.info(id);
    $('#nameUpd').val($(this).parent().children('#plName').text());
    $('#descrUpd').val($(this).parent().children('#plDescr').text());
    $('#imageSrcDesr').attr("src", $(this).parent().children('#plSrc').text());
    var iu = '/myPhotos/' + id + '/update';
    $('#rrr').attr('action', iu);

});