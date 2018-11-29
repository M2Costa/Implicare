package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class AreaEstudoManagementImpl implements AreaEstudoManagement {

    private final AreaEstudoDao dao;

    public AreaEstudoManagementImpl(AreaEstudoDao dao) throws RemoteException{
        this.dao = dao;
    }

    @Override
    public ArrayList<AreaEstudo> listar() throws PersistenceException {
            return dao.listar();
    }

    @Override
    public AreaEstudo pesquisar(int codAreaEstudo) throws PersistenceException {
            return dao.pesquisar(codAreaEstudo);
    }
}