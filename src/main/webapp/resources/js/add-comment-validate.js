$('#commentValid').validate({
    errorClass: "my-error-class",
    validClass: "my-valid-class",
    rules: {
       commentSrc: {
           required: true
       }
    }
});