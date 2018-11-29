package br.cefetmg.implicare.model.domain;

import java.sql.Date;

public class Candidato extends Usuario {

    private String nome;
    private Date dataNascimento;

    public Candidato(
            long cpfCnpj, long codCep, String descUsuario, String email, String endereco, String foto, String senha,
            String nome, Date dataNascimento) {
        super(cpfCnpj, codCep, descUsuario, email, endereco, foto, senha);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
