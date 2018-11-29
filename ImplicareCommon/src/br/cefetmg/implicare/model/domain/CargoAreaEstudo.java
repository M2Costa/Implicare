package br.cefetmg.implicare.model.domain;

public class CargoAreaEstudo {

    private int codAreaEstudo;
    private int codCargo;

    public CargoAreaEstudo(int codAreaEstudo, int codCargo) {
        this.codAreaEstudo = codAreaEstudo;
        this.codCargo = codCargo;
    }

    public int getCodAreaEstudo() {
        return codAreaEstudo;
    }

    public void setCodAreaEstudo(int codAreaEstudo) {
        this.codAreaEstudo = codAreaEstudo;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

}
