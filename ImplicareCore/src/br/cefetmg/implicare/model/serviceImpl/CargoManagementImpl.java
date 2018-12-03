package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.Cargo;
import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class CargoManagementImpl extends UnicastRemoteObject implements CargoManagement {
    
    private final CargoDao dao;

    public CargoManagementImpl(CargoDao dao) throws RemoteException{
        this.dao = dao;
    }
    
    @Override
    public ArrayList<Cargo> listar() throws PersistenceException, RemoteException {
        return dao.listar();
    }

    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(long cpf) throws PersistenceException, RemoteException {
        return dao.listarCargoAreaEstudo(cpf);
    }

    @Override
    public Cargo pesquisar(int codCargo) throws PersistenceException, RemoteException {
        return dao.pesquisar(codCargo);
    }
}
