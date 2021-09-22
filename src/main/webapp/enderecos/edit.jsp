<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 9/19/21
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <title>Editar endereço</title>
</head>
<body>
    <main>
        <div class="main-div ">
            <div class="container">
                <h1 class="center-text">Sistema de cadastro de contatos - SCC</h1>
                <hr>
                <h2>Editar endereço</h2>
                <form action="/enderecos/edit?eId=${endereco.id}" method="post" accept-charset="UTF-8">
                    <div class="label-input-div">
                        <span>Rua</span>
                        <span id="rua-error"></span>
                    </div>
                    <input id="rua" type="text" name="rua" value="${endereco.rua}"/>
                    <div class="label-input-div">
                        <span>Número</span>
                        <span id="email-error"></span>
                    </div>
                    <input id="numero" type="text" name="numero" value="${endereco.numero}"/>
                    <div class="label-input-div">
                        <span>Complemento</span>
                        <span id="complemento-error"></span>
                    </div>
                    <input id="complemento" type="text" name="complemento" value="${endereco.complemento}"/>
                    <div class="label-input-div">
                        <span>Bairro</span>
                        <span id="bairro-error"></span>
                    </div>
                    <input id="bairro" type="text" name="bairro" value="${endereco.bairro}"/>
                    <div class="label-input-div">
                        <span>CEP</span>
                        <span id="cep-error"></span>
                    </div>
                    <input id="cep" class="entry" type="text" name="cep" value="${endereco.cep}"/>
                    <div class="label-input-div">
                        <span>Cidade</span>
                        <span id="cidade-error"></span>
                    </div>
                    <input id="cidade" type="text" name="cidade" value="${endereco.cidade}"/>
                    <div class="label-input-div">
                        <span>Unidade Federativa</span>
                        <span id="unidadeFederativa-error"></span>
                    </div>
                    <input id="unidadeFederativa" type="text" name="unidadeFederativa" value="${endereco.unidadeFederativa}"/>
                    <div class="div-buttons last-button">
                        <button class="login-button" type="submit">Salvar</button>
                        <button class="return-button" type="button" onclick="previusPage()">Voltar</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <script src="../js/main.js"></script>
    <script src="../js/validation.js"></script>
</body>
</html>