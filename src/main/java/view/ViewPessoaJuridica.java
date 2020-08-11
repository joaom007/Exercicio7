package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.JuridicaDao;
import model.PessoaJuridica;

public class ViewPessoaJuridica extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter saida = resp.getWriter();

        //CONSULTA PESSOAS FISICAS
        try {
            JuridicaDao jd = new JuridicaDao();

            List<PessoaJuridica> lstPj = jd.pesquisarPJ();             
            saida.println("[");
            int n = 0, i = 1;
            
            for (PessoaJuridica pjselect : lstPj) {

                if(i==1) {
                    n = lstPj.size();
                    i = 2;
                }

                pjselect.getId();
                pjselect.getNome();
                pjselect.getEnd();
                pjselect.getTel();
                pjselect.getCep();
                pjselect.getCNPJ();
                pjselect.getRazaoSocial();
                
                String pessoaJuridicaStr = new Gson().toJson(pjselect);

                if(n == 1) {
                    saida.printf(pessoaJuridicaStr + "]");
                }else 
                    saida.println(pessoaJuridicaStr + ",");
                n--;
            }

        } catch (SQLException e) {
            saida.println("<p>Erro " + e.getMessage() + "</p>");
        } catch (Exception e) {
            e.printStackTrace();
            saida.println("<p>Erro " + e.getMessage() + "</p>");
        }

        saida.flush();
        saida.close();


    }
}