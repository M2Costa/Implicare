package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CargoInteresseDao {

    public boolean insert(CargoInteresse CargoInteresse) throws PersistenceException;

    public boolean delete(CargoInteresse CargoInteresse) throws PersistenceException;

    public ArrayList<CargoInteresse> listar(long CPF) throws PersistenceException;
}
