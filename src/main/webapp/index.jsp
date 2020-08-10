<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Exercicio</title>
</head>
<body>
    
    <h1>Cadastro de Clientes</h1>
    <h4>Para consultar clientes, <a href="consulta.jsp">clique aqui.</a></h4>

    <div class="container">
        
        <form action="cadastro.jsp" method="post">
            <h2>Preecha caso seja pessoa física</h2>
            <p class="content">
                <label for="name">Nome: </label>
                <input type="text" id="name" name="nome">
            </p>
            <p class="content">
                <label for="end">Endereço: </label>
                <input type="text" id="end" name="end">
            </p>
            <p class="content">
                <label for="tel">Telefone: </label>
                <input type="text" id="tel" name="tel">
            </p>
            <p class="content">
                <label for="cep">CEP: </label>
                <input type="text" id="cep" name="cep">
            </p>
            <p class="content">
                <label for="cpf">CPF: </label>
                <input type="text" id="cpf" name="cpf">
            </p>
            <p class="content">
                <label for="nasc">Data de Nascimento: </label>
                <input type="text" id="nasc" name="nasc">
            </p>
            <p class="button">
                <input type="hidden" name="tipo" value="1">
                <input type="submit" name="Cadastrar" Value="Cadastrar">
            </p>
        </form>
        
        <form action="cadastro.jsp" method="post">
            <h2>Preecha caso seja pessoa juridica</h2>
            <p class="content">
                <label for="name">Nome: </label>
                <input type="text" id="name" name="nome">
            </p>
            <p class="content">
                <label for="end">Endereço: </label>
                <input type="text" id="end" name="end">
            </p>
            <p class="content">
                <label for="tel">Telefone: </label>
                <input type="text" id="tel" name="tel">
            </p>
            <p class="content">
                <label for="cep">CEP: </label>
                <input type="text" id="cep" name="cep">
            </p>
            <p class="content">
                <label for="cnpj">CNPJ: </label>
                <input type="text" id="cnpj" name="cnpj">
            </p>
            <p class="content">
                <label for="raz">Razão Social: </label>
                <input type="text" id="raz" name="raz">
            </p>
            <p class="button">
                <input type="hidden" name="tipo" value="2">
                <input type="submit" name="Cadastrar" Value="Cadastrar">
            </p>
        </form>
    </div>
    
</body>
</html>