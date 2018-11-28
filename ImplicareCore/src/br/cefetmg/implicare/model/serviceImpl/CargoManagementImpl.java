package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.model.daoImpl.CargoDaoImpl;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoManagementImpl implements CargoManagement {

    private final CargoDao CargoDao;

    public CargoManagementImpl()throws  RemoteException {
        CargoDao = new CargoDaoImpl();
    }

    @Override
    public ArrayList<Cargo> listar() throws PersistenceException, RemoteException {
        return CargoDao.listar();
    }

    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(long CPF) throws PersistenceException, RemoteException {
        return CargoDao.listarCargoAreaEstudo(CPF);
    }

    @Override
    public Cargo pesquisar(int Cod_Cargo) throws PersistenceException, RemoteException {
        return CargoDao.pesquisar(Cod_Cargo);
    }

}
