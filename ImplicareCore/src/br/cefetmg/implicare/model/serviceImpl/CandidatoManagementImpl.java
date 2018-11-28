package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CandidatoDao;
import br.cefetmg.implicare.model.daoImpl.CandidatoDaoImpl;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;

import br.cefetmg.implicare.model.service.CandidatoManagement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CandidatoManagementImpl implements CandidatoManagement {

    private final CandidatoDao CandidatoDao;

    public CandidatoManagementImpl() {
        CandidatoDao = new CandidatoDaoImpl();
    }

    @Override
    public boolean insert(Candidato Candidato) throws BusinessException, PersistenceException {
        if(Candidato == null)
            throw new BusinessException("Candidato não pode ser nulo");
        
        return CandidatoDao.insert(Candidato);
    }

    @Override
    public boolean update(Candidato Candidato) throws BusinessException, PersistenceException {
        if(Candidato == null)
            throw new BusinessException("Candidato não pode ser nulo");
   
        return CandidatoDao.update(Candidato);
    }

    @Override
    public boolean delete(Candidato Candidato) throws BusinessException, PersistenceException {
        if(Candidato == null)
            throw new BusinessException("Candidato não pode ser nulo");
        
        return CandidatoDao.delete(Candidato);
    }

    @Override
    public Candidato pesquisar(long CPF) throws PersistenceException {
        return CandidatoDao.pesquisar(CPF);
    }

}
