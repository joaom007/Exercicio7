<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="model.Cliente"%>
<%@ page import="model.PessoaFisica"%>
<%@ page import="model.PessoaJuridica"%>
<%@ page import="dao.FisicaDao"%>
<%@ page import="dao.JuridicaDao"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!--
    01 - Com base no exemplo da aula, crie um projeto com JSP para cadastro e pesquisa de clientes usando formulários
    para o cadastro e tabelas para a pesquisa.
    Usar as Classes de modelo, DAO e Conexão com o Banco. A Classe Cliente deve conter os atributos nome, endereço, telefone e cep.
    02 - Usando o conceito de Herança, criar duas subclasses para a classe Cliente: PessoaFisica (com os atributos CPF e data de nascimento)
    e PessoaJuridica (com os atributos razãoSocial e CNPJ). Completar o cadastro e pesquisa de ambas no banco de dados.
-->
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Cadastro</title>
</head>
<body>

    <%  
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            //response.setCharacterEncoding("UTF-8");

            if(request.getParameter("tipo").equals("1")) {
                
                PessoaFisica pf = new PessoaFisica();
                
                pf.setNome(request.getParameter("nome"));
                pf.setEnd(request.getParameter("end"));
                pf.setTel(request.getParameter("tel"));
                pf.setCep(request.getParameter("cep"));
                pf.setCPF(request.getParameter("cpf"));
                pf.setNasc(request.getParameter("nasc"));

                FisicaDao fd = new FisicaDao();
                fd.cadastrarPF(pf);
                out.println("<h1>Dados inseridos com sucesso !!!");

            } else if(request.getParameter("tipo").equals("2")) {
                
                PessoaJuridica pj = new PessoaJuridica();
                pj.setNome(request.getParameter("nome"));
                pj.setEnd(request.getParameter("end"));
                pj.setTel(request.getParameter("tel"));
                pj.setCep(request.getParameter("cep"));
                pj.setCNPJ(request.getParameter("cnpj"));
                pj.setRazaoSocial(request.getParameter("raz"));

                JuridicaDao jd = new JuridicaDao();
                jd.cadastrarPJ(pj);
                out.println("<h1>Dados inseridos com sucesso !!!");
            }
    
        } catch (SQLException e) {
            out.println("<p>Erro " + e.getMessage() + "</p>");
        }     
    
    %>

    <h4>Para consultar clientes, <a href="consulta.jsp">clique aqui.</a></h4>
</body>
</html>