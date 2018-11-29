package br.cefetmg.implicare.model.domain;

import java.sql.Date;

public class Vaga {

    private long cnpj;
    private int seqVaga;
    private int codCargo;
    private Date dataPublicacao;
    private int numVagas;
    private int cargaHoraria;
    private double remuneracao;
    private String descVaga;
    private int statusVaga;

    public Vaga(long cnpj, int seqVaga, int codCargo, Date dataPublicacao, int numVagas, int cargaHoraria, double remuneracao, String descVaga, int statusVaga) {
        this.cnpj = cnpj;
        this.seqVaga = seqVaga;
        this.codCargo = codCargo;
        this.dataPublicacao = dataPublicacao;
        this.numVagas = numVagas;
        this.cargaHoraria = cargaHoraria;
        this.remuneracao = remuneracao;
        this.descVaga = descVaga;
        this.statusVaga = statusVaga;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
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

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getRemuneracao() {
        return remuneracao;
    }

    public void setRemuneracao(double remuneracao) {
        this.remuneracao = remuneracao;
    }

    public String getDescVaga() {
        return descVaga;
    }

    public void setDescVaga(String descVaga) {
        this.descVaga = descVaga;
    }

    public int getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(int statusVaga) {
        this.statusVaga = statusVaga;
    }

}
