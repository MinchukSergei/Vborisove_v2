$('#login-form').validate({
    errorClass: "my-error-class",
    validClass: "my-valid-class",
    rules: {
        username: {
            required: true
        },
        password: {
            required: true
        }
    }
});