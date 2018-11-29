package br.cefetmg.implicare.model.domain;

import java.sql.Date;

public class CandidatoVaga {

    private long cpf;
    private int seqVaga;
    private int codCargo;
    private long cnpj;
    private Date datPublicacao;
    private char statusCandidato;

    public CandidatoVaga(long cpf, int seqVaga, int codCargo, long cnpj, Date datPublicacao, char statusCandidato) {
        this.cpf = cpf;
        this.seqVaga = seqVaga;
        this.codCargo = codCargo;
        this.cnpj = cnpj;
        this.datPublicacao = datPublicacao;
        this.statusCandidato = statusCandidato;
    }
    
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getSeqVaga() {
        return seqVaga;
    }

    public void setSeqVaga(int seqVaga) {
        this.seqVaga = seqVaga;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDatPublicacao() {
        return datPublicacao;
    }

    public void setDatPublicacao(Date datPublicacao) {
        this.datPublicacao = datPublicacao;
    }

    public char getStatusCandidato() {
        return statusCandidato;
    }

    public void setStatusCandidato(char statusCandidato) {
        this.statusCandidato = statusCandidato;
    }
}
