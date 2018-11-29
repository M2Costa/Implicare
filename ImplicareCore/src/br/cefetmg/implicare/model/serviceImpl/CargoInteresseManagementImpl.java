package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CargoInteresseDao;
import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoInteresseManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class CargoInteresseManagementImpl implements CargoInteresseManagement {

    private final CargoInteresseDao dao;

    public CargoInteresseManagementImpl(CargoInteresseDao dao) throws RemoteException{
        this.dao = dao;
    }

    @Override
    public void insert(CargoInteresse cargoInteresse) throws BusinessException, PersistenceException, RemoteException {
        if(cargoInteresse == null)
            throw new BusinessException("O cargo de interesse não pode ser nulo!");
        dao.insert(cargoInteresse);
    }

    @Override
    public void delete(CargoInteresse cargoInteresse) throws BusinessException, PersistenceException, RemoteException {
        if(cargoInteresse == null)
            throw new BusinessException("O cargo de interesse não pode ser nulo!");
        dao.delete(cargoInteresse);
    }

    @Override
    public ArrayList<CargoInteresse> listar(long cpf) throws PersistenceException, RemoteException {
        return dao.listar(cpf);
    }

}
