function changeVisibility() {
    const input = document.getElementById("senha")
    if (input.type === 'password') {
        input.type = 'text';
    }
    else {
        input.type = 'password'
    }
}

function previusPage() {
    window.history.back();
}