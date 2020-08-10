package model;

public class PessoaJuridica extends Cliente {

    private String CNPJ, razaoSocial;
    private int idpj, idcli;

    public int getIdpj() {
        return this.idpj;
    }

    public void setIdpj(int idpj) {
        this.idpj = idpj;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
    
    public int getIdcli() {
        return this.idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

}