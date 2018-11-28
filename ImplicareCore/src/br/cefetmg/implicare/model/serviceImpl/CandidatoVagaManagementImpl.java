package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CandidatoVagaDao;
import br.cefetmg.implicare.model.daoImpl.CandidatoVagaDaoImpl;
import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoVagaManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CandidatoVagaManagementImpl implements CandidatoVagaManagement {

    private final CandidatoVagaDao CandidatoVagaDao;

    public CandidatoVagaManagementImpl() {
        CandidatoVagaDao = new CandidatoVagaDaoImpl();
    }

    @Override
    public boolean insert(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = CandidatoVagaDao.insert(CandidatoVaga);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CandidatoVagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = CandidatoVagaDao.update(CandidatoVaga);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CandidatoVagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException {
        ArrayList<CandidatoVaga> result = null;
        try {
            result = CandidatoVagaDao.listar(Seq_Vaga);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(CandidatoVagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
