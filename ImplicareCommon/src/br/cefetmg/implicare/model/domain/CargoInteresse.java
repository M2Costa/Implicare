package br.cefetmg.implicare.model.domain;

public class CargoInteresse {

    private long cpf;
    private int codCargo;

    public CargoInteresse(long CPF, int Cod_Cargo) {
        this.cpf = CPF;
        this.codCargo = Cod_Cargo;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }
}
