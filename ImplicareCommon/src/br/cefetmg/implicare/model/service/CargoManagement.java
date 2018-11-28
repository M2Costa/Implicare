package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CargoManagement {

    public ArrayList<Cargo> listar() throws PersistenceException;

    public ArrayList<Cargo> listarCargoAreaEstudo(long CPF) throws PersistenceException;

    public Cargo pesquisar(int Cod_Cargo) throws PersistenceException;
}
