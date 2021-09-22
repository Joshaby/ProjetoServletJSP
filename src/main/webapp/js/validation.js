function validateEntries(name, id) {
    const element = document.getElementById(name);
    const error = document.getElementById(id);
    if (element.value.length == 0) error.innerHTML = "Campo obrigatório";
    else error.innerHTML = "";
}