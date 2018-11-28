package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CargoInteresseManagement {

    public boolean insert(CargoInteresse CargoInteresse) throws BusinessException, PersistenceException;

    public boolean delete(CargoInteresse CargoInteresse) throws PersistenceException;

    public ArrayList<CargoInteresse> listar(long CPF) throws PersistenceException;
}
