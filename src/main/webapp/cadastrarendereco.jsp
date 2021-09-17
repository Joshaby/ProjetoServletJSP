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
                <h1 class="center-text">Cadastrar Endereço</h1>
             </div>
                <form action="/cadastrarEndereco" method="post">
                       <div class="div-endereco" >
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
                           <a href="/listaEndereco.jsp"><button class="cadastro-contato-button" type="submit" value="cadastar"
                           >Cadastar</button></a>
                       </div>
                </form>

    </main>
        <script src="js/main.js"></script>
        <script src="js/validation.js"></script>



</body>
</html>