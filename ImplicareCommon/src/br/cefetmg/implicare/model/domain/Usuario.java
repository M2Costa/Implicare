package br.cefetmg.implicare.model.domain;

public class Usuario {

    private long cpfCnpj;
    private long codCep;
    private String descUsuario;
    private String email;
    private String endereco;
    private String foto;
    private String senha;

    public Usuario(long cpfCnpj, long codCep, String descUsuario, String email, String endereco, String foto, String senha) {
        this.cpfCnpj = cpfCnpj;
        this.codCep = codCep;
        this.descUsuario = descUsuario;
        this.email = email;
        this.endereco = endereco;
        this.foto = foto;
        this.senha = senha;
    }

    public long getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(long cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public long getCodCep() {
        return codCep;
    }

    public void setCodCep(long codCep) {
        this.codCep = codCep;
    }

    public String getDescUsuario() {
        return descUsuario;
    }

    public void setDescUsuario(String descUsuario) {
        this.descUsuario = descUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}