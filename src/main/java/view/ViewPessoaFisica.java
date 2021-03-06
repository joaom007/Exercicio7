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

import dao.FisicaDao;
import model.PessoaFisica;

public class ViewPessoaFisica extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /*
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter saida = resp.getWriter();

        saida.println("<html>");
        saida.println("<body>");
        saida.println("<p>Teste de Serverlet</p>");
        saida.println("</body>");
        saida.println("</html>");

        saida.flush();
        saida.close();
        */

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter saida = resp.getWriter();

        //CONSULTA PESSOAS FISICAS
        try {
            FisicaDao fd = new FisicaDao();

            List<PessoaFisica> lstPf = fd.pesquisarPF();             
            saida.println("[");
            int n = 0, i = 1;
            
            for (PessoaFisica pfselect : lstPf) {

                if(i==1) {
                    n = lstPf.size();
                    i = 2;
                }

                pfselect.getId();
                pfselect.getNome();
                pfselect.getEnd();
                pfselect.getTel();
                pfselect.getCep();
                pfselect.getCPF();
                pfselect.getNasc();
                
                String pessoaFisicaStr = new Gson().toJson(pfselect);

                if(n == 1) {
                    saida.printf(pessoaFisicaStr + "]");
                }else 
                    saida.println(pessoaFisicaStr + ",");
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