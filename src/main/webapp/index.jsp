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
    <title>Entrar</title>
<body>
    <main>
        <div class="main-div container">
            <h1>Sistema de cadastro de contatos - SCC</h1>
            <h2>Fazer login</h2>
            <form action="/login" method="post">
                <p>Email</p>
                <input id="email" type="email" name="email" />
                <p>Senha</p>
                <input id="senha" type="password" name="senha" />
                <p class="show-password">Mostrar senha <input class="checkbox" type="checkbox" onclick="changeVisibility()"></p>
                <div class="div-buttons">
                    <button class="login-button" type="submit">Entrar</button>
                    <a href="/signup.jsp"><button class="signup-button" type="button">Registra-se</button></a>
                </div>
            </form>
        </div>
    </main>
    <script src="js/main.js"></script>
</body>
</html>
