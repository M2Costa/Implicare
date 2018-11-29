package br.cefetmg.implicare.model.domain;

import java.sql.Date;

public class FormacaoAcademica {

    private long cpf;
    private int seqFormacao;
    private String instituicaoEnsino;
    private int codAreaEstudo;
    private String atividadesDesenvolvidas;
    private Date dataInicio;
    private Date dataTermino;
    private String descFormacaoAcademica;

    public FormacaoAcademica(long cpf, int seqFormacao, String instituicaoEnsino, int codAreaEstudo, String atividadesDesenvolvidas, Date dataInicio, Date dataTermino, String descFormacaoAcademica) {
        this.cpf = cpf;
        this.seqFormacao = seqFormacao;
        this.instituicaoEnsino = instituicaoEnsino;
        this.codAreaEstudo = codAreaEstudo;
        this.atividadesDesenvolvidas = atividadesDesenvolvidas;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descFormacaoAcademica = descFormacaoAcademica;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getSeqFormacao() {
        return seqFormacao;
    }

    public void setSeqFormacao(int seqFormacao) {
        this.seqFormacao = seqFormacao;
    }

    public String getInstituicaoEnsino() {
        return instituicaoEnsino;
    }

    public void setInstituicaoEnsino(String instituicaoEnsino) {
        this.instituicaoEnsino = instituicaoEnsino;
    }

    public int getCodAreaEstudo() {
        return codAreaEstudo;
    }

    public void setCodAreaEstudo(int codAreaEstudo) {
        this.codAreaEstudo = codAreaEstudo;
    }

    public String getAtividadesDesenvolvidas() {
        return atividadesDesenvolvidas;
    }

    public void setAtividadesDesenvolvidas(String atividadesDesenvolvidas) {
        this.atividadesDesenvolvidas = atividadesDesenvolvidas;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getDescFormacaoAcademica() {
        return descFormacaoAcademica;
    }

    public void setDescFormacaoAcademica(String descFormacaoAcademica) {
        this.descFormacaoAcademica = descFormacaoAcademica;
    }

}
