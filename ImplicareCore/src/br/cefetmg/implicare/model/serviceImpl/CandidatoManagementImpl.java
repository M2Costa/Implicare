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
        boolean result = false;
        try {
            result = CandidatoDao.insert(Candidato);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CandidatoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(Candidato Candidato) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = CandidatoDao.update(Candidato);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CandidatoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean delete(Candidato Candidato) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = CandidatoDao.delete(Candidato);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CandidatoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Candidato pesquisar(long CPF) throws PersistenceException {
        Candidato result = null;
        try {
            result = CandidatoDao.pesquisar(CPF);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CandidatoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
