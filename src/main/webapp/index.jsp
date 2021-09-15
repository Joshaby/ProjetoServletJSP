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
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Entrar</title>
</head>
<body>
    <main>
        <div class="main-div container">
            <h1 class="center-text">Sistema de cadastro de contatos - SCC</h1>
            <hr>
            <h2 class="center-text">Fazer login</h2>
            <form action="/login" method="post" accept-charset="UTF-8">
                <div class="email-div">
                    <span>Email</span>
                    <span id="email-error"></span>
                </div>
                <input id="email" type="email" name="email" oninput="validateEmail()" onblur="validateEmail()"/>
                <div class="password-div">
                    <span>Senha</span>
                    <span id="password-error"></span>
                </div>
                <input id="senha" type="password" name="senha" oninput="validatePassword()" onblur="validatePassword()"/>
                <p><a href="/forgot.jsp">Esqueceu sua senha?</a></p>
                <p class="show-password">Mostrar senha <input class="checkbox" type="checkbox" onclick="changeVisibility()"></p>
                <div class="div-buttons">
                    <button class="login-button" type="submit">Entrar</button>
                    <a href="/signup.jsp"><button class="signup-button" type="button">Resgistrar-se</button></a>
                </div>
            </form>
        </div>
    </main>
    <script src="js/main.js"></script>
    <script src="js/validation.js"></script>
</body>
</html>
