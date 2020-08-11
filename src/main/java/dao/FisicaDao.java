package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PessoaFisica;
import util.ConexaoBanco;

public class FisicaDao {

    private Connection con;

    public FisicaDao() {
        this.con = new ConexaoBanco().getConnection();
    }

    public void cadastrarPF(PessoaFisica pf) throws SQLException {
        String query;
        query = "INSERT INTO cliente (nome, endereco, telefone, cep) VALUES (?, ?, ?, ?);";

        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, pf.getNome());
        st.setString(2, pf.getEnd());
        st.setString(3, pf.getTel());
        st.setString(4, pf.getCep());
        st.execute();

        query = "SELECT LAST_INSERT_ID() INTO @id;";
        st = con.prepareStatement(query);
        st.execute();

        query = "INSERT INTO pessoafisica (cpf, dataNasc, cliente_idcliente) VALUES (?, ?, @id);";
        st = con.prepareStatement(query);
        st.setString(1, pf.getCPF());
        st.setString(2, pf.getNasc());
        st.execute();
        st.close();
        con.close();       
    }

    public List<PessoaFisica> pesquisarPF() throws SQLException, Exception {

        List<PessoaFisica> lista = new ArrayList();
        String query = "SELECT cliente.*, pessoafisica.cpf, pessoafisica.dataNasc FROM cliente, pessoafisica WHERE pessoafisica.cliente_idcliente = cliente.idcliente;";

        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        System.out.println("QUERY EXECUTADA"); 
              
        while (rs.next()) {
            PessoaFisica pfse = new PessoaFisica();

            pfse.setId(rs.getInt("idcliente"));
            pfse.setNome(rs.getString("nome"));
            pfse.setEnd(rs.getString("endereco"));
            pfse.setTel(rs.getString("telefone"));
            pfse.setCep(rs.getString("cep"));
            //pfse.setIdpf(rs.getInt("idpessoaFisica"));
            pfse.setCPF(rs.getString("cpf"));
            pfse.setNasc(rs.getString("dataNasc"));
            //pfse.setIdcli(rs.getInt("cliente_idcliente"));

            lista.add(pfse);

        }

        return lista;
    }    
}