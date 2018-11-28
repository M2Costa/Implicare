package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.daoImpl.ExperienciaProfissionalDaoImpl;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExperienciaProfissionalManagementImpl implements ExperienciaProfissionalManagement {

    @Override
    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException {
        try {
            return ExperienciaProfissionalDaoImpl.getInstance().insert(ExperienciaProfissional);
        } catch (br.cefetmg.implicare.exception.PersistenceException e) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean update(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException {
        try {
            return ExperienciaProfissionalDaoImpl.getInstance().update(ExperienciaProfissional);
        } catch (br.cefetmg.implicare.exception.PersistenceException e) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        try {
            return ExperienciaProfissionalDaoImpl.getInstance().delete(ExperienciaProfissional);
        } catch (br.cefetmg.implicare.exception.PersistenceException e) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public ExperienciaProfissional pesquisar(int SeqExperiencia) throws PersistenceException {
        try {
            return ExperienciaProfissionalDaoImpl.getInstance().pesquisar(SeqExperiencia);
        } catch (br.cefetmg.implicare.exception.PersistenceException e) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException {
        try {
            return ExperienciaProfissionalDaoImpl.getInstance().listar(CPF);
        } catch (br.cefetmg.implicare.exception.PersistenceException e) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}