package br.cefetmg.implicare.model.domain;

public class Empresa extends Usuario {

    private String nomRazaoSocial;
    private String nomeFantasia;

    public Empresa(
            long cpfCnpj, long codCep, String descUsuario, String email, String endereco, String foto, String senha,
            String nomRazaoSocial, String nomeFantasia) {
        super(cpfCnpj, codCep, descUsuario, email, endereco, foto, senha);
        this.nomRazaoSocial = nomRazaoSocial;
        this.nomeFantasia = nomeFantasia;
    }
    
    public String getNomRazaoSocial() {
        return nomRazaoSocial;
    }

    public void setNomRazaoSocial(String nomRazaoSocial) {
        this.nomRazaoSocial = nomRazaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
