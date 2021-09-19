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
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Página inicial</title>
</head>
<body>
    <header>
        <nav>
            <div class="nav-div">
                <h1>Sistema de cadastro de contatos - SCC</h1>
                <div>
                    <span class="username">Usuário: ${nomeUsuario}</span>
                    <button class="exit-button">Sair</button>
                </div>
            </div>
        </nav>
    </header>
    <main>
        <div class="main-div container-address">
            <div class="title-div">
                <h2 class="title-address">Endereços de: ${nomeContato}</h2>
                <a href="/newendereco.jsp"><button class="add-button">Adicionar</button></a>
            </div>
            <hr>
            <c:forEach items="${enderecos}" var="endereco">
                <div class="address-div">
                    <p class="address-name">Rua: ${endereco.rua} - ${endereco.numero}</p>
                    <div>
                        <a href="/enderecos/form?eId=${endereco.id}"><button class="edit-button">Editar</button></a>
                        <a href="/enderecos/del?eId=${endereco.id}"><button class="remove-button">Remover</button></a>
                    </div>
                </div>
                <c:set var="qtde" scope="page" value="${qtde + 1}"/>
            </c:forEach>
            <hr>
            <p class="end-text">Total de endereço: ${qtde}</p>
        </div>
    </main>
</body>
</html>
