<%--
  Created by IntelliJ IDEA.
  User: Italo Santos Neves
  Date: 13/11/21
  Time: 15:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <title>Cadastar Contato</title>
</head>
<body>
    <main class="main-contato">
            <div class="titulo">
                <h1 class="center-text">Cadastrar contato</h1>
             </div>

                <h2  class="center-text">Contato</h2>
                <form action="/cadastrarContato" method="post">
                    <div class="div-contato">
                       <div>
                            <span>Nome</span>
                       </div>
                        <input id="nome" type="text" name="nome" />

                       <div>
                        <span>RG</span>
                       </div>
                            <input id="rg" type="text" name="rg"/>
                       <div>
                           <span>CPF</span>
                       </div>
                           <input id="cpf" type="text" name="cpf"/>
                    </div>
                       <div class="div-endereco" >

                               <h2 class="center-text">Endereco</h2>
                              <div>
                                   <span>Rua</span>
                              </div>
                                   <input id="rua" type="text" name="rua"/>
                               <div>
                                    <span>Número</span>
                               </div>
                                    <input id="numero" type="text" name="numero"/>
                               <div>
                                      <span>Complemento</span>
                               </div>
                                       <input id="complemento" type="text" name="complemento"/>
                               <div>
                                        <span>Bairro</span>
                               </div>
                                        <input id="bairro" type="text" name="bairro"/>
                               <div>
                                        <span>CEP</span>
                               </div>
                                         <input id="cep" type="text" name="cep"/>
                               <div>
                                          <span>Cidade</span>
                               </div>
                                          <input id="cidade" type="text" name="cidade"/>

                              <div>
                                        <span>Unidade Federativa(UF)</span>
                              </div>
                                       <input id="uf" type="text" name="uf"/>

                       </div>


                       <div class="div-buttons">
                           <a href="/home.jsp"><button class="cadastro-contato-button" type="submit" value="cadastar"
                           >Cadastar</button></a>
                       </div>
                </form>

    </main>
        <script src="js/main.js"></script>
        <script src="js/validation.js"></script>



</body>
</html>