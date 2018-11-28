package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CandidatoVagaDao;
import br.cefetmg.implicare.model.daoImpl.CandidatoVagaDaoImpl;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CandidatoVagaManagementImpl implements CandidatoVagaManagement {

    private final CandidatoVagaDao CandidatoVagaDao;

    public CandidatoVagaManagementImpl() throws RemoteException {
        CandidatoVagaDao = new CandidatoVagaDaoImpl();
    }

    @Override
    public boolean insert(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException, RemoteException {
        if(CandidatoVaga == null)
            throw new BusinessException("CandidatoVaga não pode ser nulo");
        
        return CandidatoVagaDao.insert(CandidatoVaga);
    }

    @Override
    public boolean update(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException, RemoteException {
        if(CandidatoVaga == null)
            throw new BusinessException("CandidatoVaga não pode ser nulo");
       
        return CandidatoVagaDao.update(CandidatoVaga);
    }

    @Override
    public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException, RemoteException {
 
        return CandidatoVagaDao.listar(Seq_Vaga);
    }

}
