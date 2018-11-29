package br.cefetmg.implicare.model.domain;

public class Cargo {

    private int codCargo;
    private String nomCargo;

    public Cargo(int codCargo, String nomCargo) {
        this.codCargo = codCargo;
        this.nomCargo = nomCargo;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }
}
