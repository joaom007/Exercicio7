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
    <title>Consulta</title>
</head>
<body>

    <%  
        
        //CONSULTA PESSOAS FISICAS
        out.println("<h1>Consulta de pessoas fisicas</h1>");
        try {
            FisicaDao fd = new FisicaDao();

            List<PessoaFisica> lstPf = fd.pesquisarPF();

            out.println("<table>");
            out.println("<tr>");
            out.println("<td>ID</td>");
            out.println("<td>Nome</td>");
            out.println("<td>Endereco</td>");
            out.println("<td>Telefone</td>");
            out.println("<td>Cep</td>");
            out.println("<td>CPF</td>");
            out.println("<td>Data Nascimento</td>");
            out.println("</tr>");                   
            
            for (PessoaFisica pfselect : lstPf) {
                out.println("<tr>");
                out.println("<td>" + pfselect.getId() + "</td>");
                out.println("<td>" + pfselect.getNome() + "</td>");
                out.println("<td>" + pfselect.getEnd() + "</td>");
                out.println("<td>" + pfselect.getTel() + "</td>");
                out.println("<td>" + pfselect.getCep() + "</td>");
                out.println("<td>" + pfselect.getCPF() + "</td>");
                out.println("<td>" + pfselect.getNasc() + "</td>");
                out.println("</tr>"); 
                            
            }

        } catch (SQLException e) {
            out.println("<p>Erro " + e.getMessage() + "</p>");
        }
        out.println("</table>");

        //CONSULTA PESSOAS JURIDICAS
        out.println("<h1>Consulta de pessoas juridicas</h1>");
        try {
            JuridicaDao jd = new JuridicaDao();

            List<PessoaJuridica> lstPj = jd.pesquisarPJ();

            out.println("<table>");
            out.println("<tr>");
            out.println("<td>ID</td>");
            out.println("<td>Nome</td>");
            out.println("<td>Endereco</td>");
            out.println("<td>Telefone</td>");
            out.println("<td>Cep</td>");
            out.println("<td>CNPJ</td>");
            out.println("<td>Razão Social</td>");
            out.println("</tr>");                   
            
            for (PessoaJuridica pjselect : lstPj) {
                out.println("<tr>");
                out.println("<td>" + pjselect.getId() + "</td>");
                out.println("<td>" + pjselect.getNome() + "</td>");
                out.println("<td>" + pjselect.getEnd() + "</td>");
                out.println("<td>" + pjselect.getTel() + "</td>");
                out.println("<td>" + pjselect.getCep() + "</td>");
                out.println("<td>" + pjselect.getCNPJ() + "</td>");
                out.println("<td>" + pjselect.getRazaoSocial() + "</td>");
                out.println("</tr>"); 
                            
            }

        } catch (SQLException e) {
            out.println("<p>Erro " + e.getMessage() + "</p>");
        }
        out.println("</table>");
        
        
        
    
    %>

    <h4>Para voltar ao cadastro de clientes, <a href="index.jsp">clique aqui.</a></h4>
</body>
</html>