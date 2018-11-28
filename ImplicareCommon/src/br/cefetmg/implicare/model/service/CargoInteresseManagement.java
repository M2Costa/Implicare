package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CargoInteresseManagement extends Remote{

    public boolean insert(CargoInteresse CargoInteresse) throws BusinessException, PersistenceException, RemoteException;

    public boolean delete(CargoInteresse CargoInteresse) throws PersistenceException, RemoteException;

    public ArrayList<CargoInteresse> listar(long CPF) throws PersistenceException, RemoteException;
}
