package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CargoInteresseDao;
import br.cefetmg.implicare.model.daoImpl.CargoInteresseDaoImpl;
import br.cefetmg.implicare.model.domain.CargoInteresse;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoInteresseManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoInteresseManagementImpl implements CargoInteresseManagement {

    private final CargoInteresseDao CargoInteresseDao;

    public CargoInteresseManagementImpl() {
        CargoInteresseDao = new CargoInteresseDaoImpl();
    }

    @Override
    public boolean insert(CargoInteresse CargoInteresse) throws BusinessException, PersistenceException {
        if(CargoInteresse == null)
            throw new BusinessException("CargoInteresse não pode ser nulo");
        
        return CargoInteresseDao.insert(CargoInteresse);
    }

    @Override
    public boolean delete(CargoInteresse CargoInteresse) throws PersistenceException {
        if(CargoInteresse == null)
            throw new BusinessException("CargoInteresse não pode ser nulo");
        
        return CargoInteresseDao.delete(CargoInteresse);
    }

    @Override
    public ArrayList<CargoInteresse> listar(long CPF) throws PersistenceException {
        
        return CargoInteresseDao.listar(CPF);
    }

}
