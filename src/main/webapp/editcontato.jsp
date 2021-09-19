<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 9/19/21
  Time: 7:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Editar contato</title>
</head>
<body>
    <main>
        <div class="main-div container">
            <h1 class="center-text">Sistema de cadastro de contatos - SCC</h1>
            <hr>
            <h2 class="center-text">Editar contato</h2>
            <form action="/contatos/edit?cId=${contato.id}" method="post" accept-charset="UTF-8">
                <div class="label-input-div">
                    <span>Nome</span>
                    <span id="nome-error"></span>
                </div>
                <input id="nome" type="text" name="nome" value="${contato.nome}"/>
                <div class="label-input-div">
                    <span>RG</span>
                    <span id="rg-error"></span>
                </div>
                <input id="rg" type="text" name="rg" value="${contato.rg}"/>
                <div class="label-input-div">
                  <span>CPF</span>
                  <span id="cpf-error"></span>
                </div>
                <input id="cpf" type="text" name="cpf" value="${contato.cpf}"/>
                </p>
                <div class="div-buttons last-button">
                    <button class="login-button" type="submit">Salvar</button>
                    <button class="return-button" type="button" onclick="previusPage()">Voltar</button>
                </div>
            </form>
        </div>
    </main>
    <script src="js/main.js"></script>
    <script src="js/validation.js"></script>
</body>
</html>

