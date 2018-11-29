package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class AreaEstudoManagementImpl extends UnicastRemoteObject implements AreaEstudoManagement {

    private final AreaEstudoDao dao;

    public AreaEstudoManagementImpl(AreaEstudoDao dao) throws RemoteException{
        this.dao = dao;
    }

    @Override
    public ArrayList<AreaEstudo> listar() throws PersistenceException, RemoteException {
            return dao.listar();
    }

    @Override
    public AreaEstudo pesquisar(int codAreaEstudo) throws PersistenceException, RemoteException {
            return dao.pesquisar(codAreaEstudo);
    }
}