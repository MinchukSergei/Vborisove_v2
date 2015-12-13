$.validator.addMethod('filesize', function(value, element, param) {
    // param = size (en bytes)
    // element = element to validate (<input>)
    // value = value of the element (file name)
    return this.optional(element) || (element.files[0].size <= param)
});

$('#updatePlaceForm').validate({
    errorClass: "my-error-class",
    validClass: "my-valid-class",
    rules: {
        name: {
            required: true,
            minlength: 5,
            maxlength: 30
        },
        description: {
            minlength: 10,
            required: true
        },
        photo: {
            extension: 'png|jpe?g|gif',
            filesize: 100 * 1024 * 1024
        }
    }
});

$.validator.messages.filesize = 'File must less 100Mb';
