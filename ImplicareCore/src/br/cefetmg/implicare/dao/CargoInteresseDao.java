package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CargoInteresseDao {

    public void insert(CargoInteresse cargoInteresse) throws PersistenceException;

    public void delete(CargoInteresse cargoInteresse) throws PersistenceException;

    public ArrayList<CargoInteresse> listar(long cpf) throws PersistenceException;
}
