<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 9/12/21
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Email não encontrado</title>
</head>
<body>
    <main>
        <div class="main-div container1">
            <h1 class="center-text">Sistema de cadastro de contatos - SCC</h1>
            <hr>
            <p class="center-text">Email: ${email} não encontrado!</p>
            <p class="center-text">Se cadastre no sistema para continuar!</p>
            <div class="div-buttons">
                <button class="login-button">Resgistrar-se</button>
                <button class="return-button" type="button" onclick="previusPage()">Voltar</button>
            </div>
        </div>
    </main>
    <script src="js/main.js"></script>
</body>
</html>

