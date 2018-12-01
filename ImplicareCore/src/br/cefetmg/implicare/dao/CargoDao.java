package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CargoDao {

    public ArrayList<Cargo> listar() throws PersistenceException;

    public ArrayList<Cargo> listarCargoAreaEstudo(long cpf) throws PersistenceException;

    public Cargo pesquisar(int codCargo) throws PersistenceException;
}
