<%--
  Created by IntelliJ IDEA.
  User: jose
  Date: 9/12/21
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="qtde" scope="page" value="${0}"/>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Página inicial</title>
</head>
<body>
    <header>
        <nav>
            <div class="nav-div">
                <h1>Sistema de cadastro de contatos - SCC</h1>
                <div>
                    <span class="username">Usuário: ${nome}</span>
                    <button class="exit-button">Sair</button>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="main-div container-contacts">
            <div class="title-div">
                <h2 class="title-contacts">Contatos</h2>
                <a href="/cadastrarcontato.jsp">
                <button class="add-button">Adicionar</button>
                </a>
            </div>
            <hr>
            <c:forEach items="${contatos}" var="contato">
                <div class="contacts-div">
                    <p>${contato.nome}</p>
                    <div>
                        <button class="edit-button">Editar</button>
                        <button class="show-button">Ver</button>
                        <button class="remove-button">Remover</button>
                    </div>
                </div>
                <c:set var="qtde" scope="page" value="${qtde + 1}"/>
            </c:forEach>
            <hr>
            <p class="end-text">Total de contatos: ${qtde}</p>
        </div>
    </main>
</body>
</html>