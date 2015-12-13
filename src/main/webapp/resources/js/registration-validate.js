$('form').validate({
    errorClass: "my-error-class",
    validClass: "my-valid-class",
    rules: {
        name: {
            required: true,
            maxlength: 30,
            minlength: 5
        },
        username: {
            required: true,
            maxlength: 20,
            minlength: 5
        },
        email: {
            required: true,
            email: true
        },
        password: {
            required: true,
            minlength: 5,
            maxlength: 20
        }
    }
});

