package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.model.daoImpl.FormacaoAcademicaDaoImpl;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormacaoAcademicaManagementImpl implements FormacaoAcademicaManagement {

    private final FormacaoAcademicaDao FormacaoAcademicaDao;

    public FormacaoAcademicaManagementImpl() {
        FormacaoAcademicaDao = new FormacaoAcademicaDaoImpl();
    }

    @Override
    public boolean insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = FormacaoAcademicaDao.insert(FormacaoAcademica);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(FormacaoAcademicaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = FormacaoAcademicaDao.update(FormacaoAcademica);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(FormacaoAcademicaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean delete(FormacaoAcademica FormacaoAcademica) throws PersistenceException {
        boolean result = false;
        try {
            result = FormacaoAcademicaDao.delete(FormacaoAcademica);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(FormacaoAcademicaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public FormacaoAcademica pesquisar(int Seq_Formacao) throws PersistenceException {
        FormacaoAcademica result = null;
        try {
            result = FormacaoAcademicaDao.pesquisar(Seq_Formacao);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(FormacaoAcademicaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException {
        ArrayList<FormacaoAcademica> result = null;
        try {
            result = FormacaoAcademicaDao.listar(CPF);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(FormacaoAcademicaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
