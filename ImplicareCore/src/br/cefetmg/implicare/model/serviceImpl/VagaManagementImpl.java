package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.Vaga;
import br.cefetmg.implicare.dao.VagaDao;
import br.cefetmg.implicare.model.daoImpl.VagaDaoImpl;

import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class VagaManagementImpl extends UnicastRemoteObject implements VagaManagement {
    
    private final VagaDao dao;

    public VagaManagementImpl(VagaDao dao) throws RemoteException {
        this.dao = dao;
    }

    @Override
    public void insert(Vaga vaga) throws BusinessException, PersistenceException, RemoteException {
        if(vaga == null)
            throw new BusinessException("A vaga não pode ser nula!");
        VagaDaoImpl.getInstance().insert(vaga);
    }

    @Override
    public void update(Vaga vaga) throws BusinessException, PersistenceException, RemoteException {
        if(vaga == null)
            throw new BusinessException("A vaga não pode ser nula!");
        VagaDaoImpl.getInstance().update(vaga);
    }

    @Override
    public void delete(Vaga vaga) throws PersistenceException, RemoteException {
        if(vaga == null)
            throw new BusinessException("A vaga não pode ser nula!");
        VagaDaoImpl.getInstance().delete(vaga);
    }

    @Override
    public Vaga pesquisar(int seqVaga) throws PersistenceException, RemoteException {
        return VagaDaoImpl.getInstance().pesquisar(seqVaga);
    }
    
    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long cnpj) throws PersistenceException, RemoteException {
        return VagaDaoImpl.getInstance().listarVagaEmpresa(cnpj);
    }

    @Override
    public ArrayList<Vaga> listarVagaCandidato(long cpf) throws PersistenceException, RemoteException {
        return VagaDaoImpl.getInstance().listarVagaCandidato(cpf);
    }
}