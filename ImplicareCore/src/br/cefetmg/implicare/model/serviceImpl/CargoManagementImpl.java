package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.model.daoImpl.CargoDaoImpl;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoManagementImpl implements CargoManagement {

    private final CargoDao CargoDao;

    public CargoManagementImpl() {
        CargoDao = new CargoDaoImpl();
    }

    @Override
    public ArrayList<Cargo> listar() throws PersistenceException {
        ArrayList<Cargo> result = null;
        try {
            result = CargoDao.listar();
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CargoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(long CPF) throws PersistenceException {
        ArrayList<Cargo> result = null;
        try {
            result = CargoDao.listarCargoAreaEstudo(CPF);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CargoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Cargo pesquisar(int Cod_Cargo) throws PersistenceException {
        Cargo result = null;
        try {
            result = CargoDao.pesquisar(Cod_Cargo);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CargoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
