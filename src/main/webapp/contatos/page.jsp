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
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/main.css">
    <title>Página inicial</title>
</head>
<body>
    <header>
        <nav>
            <div class="nav-div">
                <h1>Sistema de cadastro de contatos - SCC</h1>
                <div>
                    <span class="username">Usuário: ${nome}</span>
                    <a href="/logout"><button class="exit-button">Sair</button></a>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="main-div">
            <div class="container-contacts">
                <div class="title-div">
                    <h2 class="title-contacts">Contatos</h2>
                    <a href="/contatos/new.html"><button class="add-button">Adicionar</button></a>
                </div>
                <hr>
                <c:forEach items="${contatos}" var="contato">
                    <div class="contacts-div">
                        <p class="contact-name">${contato.nome}</p>
                        <div>
                            <a href="/contatos/form?cId=${contato.id}"><button class="edit-button">Editar</button></a>
                            <a href="/enderecos?cId=${contato.id}"><button class="show-button">Ver</button></a>
                            <a href="/contatos/del?cId=${contato.id}"><button class="remove-button">Remover</button></a>
                        </div>
                    </div>
                    <c:set var="qtde" scope="page" value="${qtde + 1}"/>
                </c:forEach>
                <hr>
                <p class="end-text">Total de contatos: ${qtde}</p>
            </div>
        </div>
    </main>
</body>
</html>
