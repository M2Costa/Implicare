package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CargoInteresseManagement {

    public void insert(CargoInteresse cargoInteresse) throws BusinessException, PersistenceException;

    public void delete(CargoInteresse cargoInteresse) throws BusinessException, PersistenceException;

    public ArrayList<CargoInteresse> listar(long cpf) throws PersistenceException;
}
