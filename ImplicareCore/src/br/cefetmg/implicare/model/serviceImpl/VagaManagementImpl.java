package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.VagaDao;
import br.cefetmg.implicare.model.daoImpl.VagaDaoImpl;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VagaManagementImpl implements VagaManagement {

    private final VagaDao VagaDao;

    public VagaManagementImpl() {
        VagaDao = new VagaDaoImpl();
    }

    @Override
    public boolean insert(Vaga Vaga) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = VagaDao.insert(Vaga);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(VagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(Vaga Vaga) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = VagaDao.update(Vaga);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(VagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean delete(Vaga Vaga) throws PersistenceException {
        boolean result = false;
        try {
            result = VagaDao.delete(Vaga);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(VagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Vaga pesquisar(int Seq_Vaga) throws PersistenceException {
        Vaga result = null;
        try {
            result = VagaDao.pesquisar(Seq_Vaga);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(VagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException {
        ArrayList<Vaga> result = null;
        try {
            result = VagaDao.listarVagaEmpresa(CNPJ);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(VagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException {
        ArrayList<Vaga> result = null;
        try {
            result = VagaDao.listarVagaCandidato(CPF);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(VagaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
