package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.daoImpl.AreaEstudoDaoImpl;
import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaEstudoManagementImpl extends UnicastRemoteObject implements AreaEstudoManagement {

    private final AreaEstudoDao AreaEstudoDao;

    public AreaEstudoManagementImpl() throws RemoteException{
        AreaEstudoDao = new AreaEstudoDaoImpl();
    }   

    @Override
    public ArrayList<AreaEstudo> listar() throws PersistenceException, RemoteException{
        return AreaEstudoDao.listar();
    }

    @Override
    public AreaEstudo pesquisar(int Cod_Area_Estudo) throws PersistenceException, RemoteException {
      
        return AreaEstudoDao.pesquisar(Cod_Area_Estudo);
    }

}
