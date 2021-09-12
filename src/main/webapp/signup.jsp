<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 9/11/21
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Registrar</title>
<body>
    <main>
        <div class="main-div container">
            <h1>Sistema de cadastro de contatos - SCC</h1>
            <h2>Registro de novo usuário</h2>
            <form action="/signup" method="post">
                <p>Nome</p>
                <input id="nome" class="entry" type="text" name="nome"/>
                <p>Email</p>
                <input id="email" class="entry" type="email" name="email"/>
                <p>Senha</p>
                <input id="senha" class="entry" type="password" name="senha"/>
                <p class="show-password">Mostrar senha <input class="checkbox" type="checkbox" onclick="changeVisibility()"></p>
                <div class="div-buttons">
                    <button class="login-button" type="submit">Entrar</button>
                    <button class="return-button" type="button" onclick="previusPage()">Voltar</button>
                </div>
            </form>
        </div>
    </main>
    <script src="js/main.js"></script>
</body>
</html>
