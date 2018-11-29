package br.cefetmg.implicare.model.domain;

public class AreaEstudo {

    private int codAreaEstudo;
    private String nomAreaEstudo;

    public AreaEstudo(int codAreaEstudo, String nomAreaEstudo) {
        this.codAreaEstudo = codAreaEstudo;
        this.nomAreaEstudo = nomAreaEstudo;
    }

    public int getCodAreaEstudo() {
        return codAreaEstudo;
    }

    public void setCodAreaEstudo(int codAreaEstudo) {
        this.codAreaEstudo = codAreaEstudo;
    }

    public String getNomAreaEstudo() {
        return nomAreaEstudo;
    }

    public void setNomAreaEstudo(String nomAreaEstudo) {
        this.nomAreaEstudo = nomAreaEstudo;
    }
}
