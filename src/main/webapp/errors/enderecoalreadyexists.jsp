<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 9/20/21
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="../css/main.css">
        <title>Endereço já existe</title>
    </head>
<body>
    <main>
        <div class="main-div ">
            <div class="container1">
                <h1 class="center-text">Sistema de cadastro de contatos - SCC</h1>
                <hr>
                <p class="center-text">Endereço: Rua ${rua} - ${numero} já existe!</p>
                <p class="center-text-end">Use outro endereço para o cadastro!</p>
                <div class="div-buttons">
                    <button class="return-button" type="button" onclick="previusPage()">Voltar</button>
                </div>
            </div>
        </div>
    </main>
    <script src="../js/main.js"></script>
</body>
</html>
