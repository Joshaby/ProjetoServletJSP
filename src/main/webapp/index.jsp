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
        <div class="main-div">
            <h1>Entrar</h1>
            <form action="/login" method="post">
                <p>Email</p>
                <input type="email" name="email" />
                <p>Senha</p>
                <input type="password" name="senha" />
                <div>
                    <button class="login-button" type="submit">Entrar</button>
                    <a href="/signup.jsp"><button class="signup-button" type="button">Registra-se</button></a>
                </div>
            </form>
        </div>
    </main>
</body>
</html>
