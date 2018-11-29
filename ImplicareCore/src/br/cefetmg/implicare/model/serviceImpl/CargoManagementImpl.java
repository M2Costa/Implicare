package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CargoManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class CargoManagementImpl implements CargoManagement {
    
    private final CargoDao dao;

    public CargoManagementImpl(CargoDao dao) throws RemoteException{
        this.dao = dao;
    }
    
    @Override
    public ArrayList<Cargo> listar() throws PersistenceException {
        return dao.listar();
    }

    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(long cpf) throws PersistenceException {
        return dao.listarCargoAreaEstudo(cpf);
    }

    @Override
    public Cargo pesquisar(int codCargo) throws PersistenceException {
        return dao.pesquisar(codCargo);
    }
}
