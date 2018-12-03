package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CargoDao extends GenericDao {

    public ArrayList<Cargo> listar() throws PersistenceException;

    public ArrayList<Cargo> listarCargoAreaEstudo(int codAreaEstudo) throws PersistenceException;

    public Cargo pesquisar(int codCargo) throws PersistenceException;
}
