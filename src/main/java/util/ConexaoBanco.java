package util;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexaoBanco {

    private Connection conexao = null;
    private final String HOST = "172.17.0.3";
    private final String BANCO = "exercicio";
    private final String LOGIN = "root";
    private final String SENHA = "9eq3y%NhPG83o9fLZ%xL";
    

    public Connection getConnection() {

        try {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName(HOST);
            ds.setDatabaseName(BANCO);
            ds.setUser(LOGIN);
            ds.setPassword(SENHA);
            ds.setServerTimezone("UTC");

            ds.setConnectTimeout(2000);

            conexao = ds.getConnection();
            System.out.println("CONECTADO AO BANCO DE DADOS.");
            
        } catch (SQLException sqle) {
            System.out.println("FALHA NA CONEXÃO: " + sqle.getMessage());
        }

        return conexao;
    }
     
}
//encontrar ip docker
//docker container ls
//docker container inspect 4b92738f4806

//acessar docker 
//docker exec -it 4b92738f4806 bash

//parar docker
//docker container rm 4b92738f4806 --force