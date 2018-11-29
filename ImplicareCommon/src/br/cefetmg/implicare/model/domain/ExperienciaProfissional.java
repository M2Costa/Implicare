package br.cefetmg.implicare.model.domain;

import java.sql.Date;

public class ExperienciaProfissional {

    private long cpf;
    private int seqExperiencia;
    private String nomEmpresa;
    private int codCargo;
    private Date dataInicio;
    private Date dataTermino;
    private String descExperienciaProfissional;

    public ExperienciaProfissional(long cpf, int seqExperiencia, String nomEmpresa, int codCargo, Date dataInicio, Date dataTermino, String descExperienciaProfissional) {
        this.cpf = cpf;
        this.seqExperiencia = seqExperiencia;
        this.nomEmpresa = nomEmpresa;
        this.codCargo = codCargo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descExperienciaProfissional = descExperienciaProfissional;
    }
    
    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getSeqExperiencia() {
        return seqExperiencia;
    }

    public void setSeqExperiencia(int seqExperiencia) {
        this.seqExperiencia = seqExperiencia;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
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

    public String getDescExperienciaProfissional() {
        return descExperienciaProfissional;
    }

    public void setDescExperienciaProfissional(String descExperienciaProfissional) {
        this.descExperienciaProfissional = descExperienciaProfissional;
    }

}
