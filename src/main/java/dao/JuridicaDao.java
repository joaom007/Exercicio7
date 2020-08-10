package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PessoaJuridica;
import util.ConexaoBanco;

public class JuridicaDao {

    private Connection con;

    public JuridicaDao() {
        this.con = new ConexaoBanco().getConnection();
    }

    public void cadastrarPJ(PessoaJuridica pj) throws SQLException {
        String query;
        query = "INSERT INTO cliente (nome, endereco, telefone, cep) VALUES (?, ?, ?, ?);";

        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, pj.getNome());
        st.setString(2, pj.getEnd());
        st.setString(3, pj.getTel());
        st.setString(4, pj.getCep());
        st.execute();
        
        query = "SELECT LAST_INSERT_ID() INTO @id;";
        st = con.prepareStatement(query);
        st.execute();

        query = "INSERT INTO pessoajuridica (cnpj, razaoSocial, cliente_idcliente) VALUES (?, ?, @id);";
        st = con.prepareStatement(query);
        st.setString(1, pj.getCNPJ());
        st.setString(2, pj.getRazaoSocial());
        st.execute();
        st.close();
        con.close();       
    }
    
    public List<PessoaJuridica> pesquisarPJ() throws SQLException, Exception {

        List<PessoaJuridica> lista = new ArrayList();
        String query = "SELECT cliente.*, pessoajuridica.cnpj, pessoajuridica.razaoSocial FROM cliente, pessoajuridica WHERE pessoajuridica.cliente_idcliente = cliente.idcliente;";

        PreparedStatement st = con.prepareStatement(query);
        ResultSet rs = st.executeQuery();
        System.out.println("QUERY EXECUTADA"); 
              

        while (rs.next()) {
            PessoaJuridica pjse = new PessoaJuridica();

            pjse.setId(rs.getInt("idcliente"));
            pjse.setNome(rs.getString("nome"));
            pjse.setEnd(rs.getString("endereco"));
            pjse.setTel(rs.getString("telefone"));
            pjse.setCep(rs.getString("cep"));
            pjse.setCNPJ(rs.getString("cnpj"));
            pjse.setRazaoSocial(rs.getString("razaoSocial"));

            lista.add(pjse);

        }

        return lista;
    }
}