package br.cefetmg.implicare.model.domain;

public class Telefone {

    private long CpfCnpj;
    private int seqTelefone;
    private String numTelefone;
    private char tipoTelefone;
    private int ddd;
    private int ramal;

    public Telefone(long CpfCnpj, int seqTelefone, String numTelefone, char tipoTelefone, int ddd, int ramal) {
        this.CpfCnpj = CpfCnpj;
        this.seqTelefone = seqTelefone;
        this.numTelefone = numTelefone;
        this.tipoTelefone = tipoTelefone;
        this.ddd = ddd;
        this.ramal = ramal;
    }

    public long getCpfCnpj() {
        return CpfCnpj;
    }

    public void setCpfCnpj(long CpfCnpj) {
        this.CpfCnpj = CpfCnpj;
    }

    public int getSeqTelefone() {
        return seqTelefone;
    }

    public void setSeqTelefone(int seqTelefone) {
        this.seqTelefone = seqTelefone;
    }

    public String getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public char getTipoTelefone() {
        return tipoTelefone;
    }

    public void setTipoTelefone(char tipoTelefone) {
        this.tipoTelefone = tipoTelefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getRamal() {
        return ramal;
    }

    public void setRamal(int Ramal) {
        this.ramal = Ramal;
    }

}
