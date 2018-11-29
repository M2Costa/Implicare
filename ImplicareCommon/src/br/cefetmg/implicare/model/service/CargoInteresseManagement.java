package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CargoInteresseManagement extends Remote{

    public void insert(CargoInteresse cargoInteresse) throws BusinessException, PersistenceException, RemoteException;

    public void delete(CargoInteresse cargoInteresse) throws BusinessException, PersistenceException, RemoteException;

    public ArrayList<CargoInteresse> listar(long cpf) throws PersistenceException, RemoteException;
}
