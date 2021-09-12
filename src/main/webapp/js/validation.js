function validatePassword() {
    const password = document.getElementById("senha");
    const error = document.getElementById("password-error");
    if (password.value.length == 0) {
        error.innerHTML = "Campo obrigatório";
    }
    else {
        error.innerHTML = "";
    }
}

function validateEmail() {
    const password = document.getElementById("email");
    const error = document.getElementById("email-error");
    if (password.value.length == 0) {
        error.innerHTML = "Campo obrigatório";
    }
    else {
        error.innerHTML = "";
    }
}