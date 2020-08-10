package model;

public class PessoaFisica extends Cliente {

    private String CPF, Nasc;
    private int idpf, idcli;

    public int getIdpf() {
        return this.idpf;
    }

    public void setIdpf(int idpf) {
        this.idpf = idpf;
    }

    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNasc() {
        return this.Nasc;
    }

    public void setNasc(String Nasc) {
        this.Nasc = Nasc;
    }

    public int getIdcli() {
        return this.idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }
    
}