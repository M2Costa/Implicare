package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.CandidatoVaga;
import br.cefetmg.implicare.dao.CandidatoVagaDao;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class CandidatoVagaManagementImpl implements CandidatoVagaManagement {

    private final CandidatoVagaDao dao;
    
    public CandidatoVagaManagementImpl(CandidatoVagaDao dao) throws RemoteException{
        this.dao = dao;
    }

    @Override
    public void insert(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException, RemoteException {
        if(candidatoVaga == null)
            throw new BusinessException("A vaga do candidato não podem ser nula!");
        dao.insert(candidatoVaga);
    }

    @Override
    public void update(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException, RemoteException {
        if(candidatoVaga == null)
            throw new BusinessException("A vaga do candidato não podem ser nula!");
        dao.update(candidatoVaga);
    }

    @Override
    public ArrayList<CandidatoVaga> listar(int seqVaga) throws PersistenceException, RemoteException {
        return dao.listar(seqVaga);
    }
}
