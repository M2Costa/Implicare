/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.ExperienciaProfissionalDao;
import br.cefetmg.implicare.model.daoImpl.ExperienciaProfissionalDaoImpl;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.model.exception.BusinessException;
import br.cefetmg.implicare.model.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Morato
 * 
 */

public class ExperienciaProfissionalManagementImpl implements ExperienciaProfissionalManagement {
    private final ExperienciaProfissionalDao ExperienciaProfissionalDao;
    
    public ExperienciaProfissionalManagementImpl(){
        ExperienciaProfissionalDao = new ExperienciaProfissionalDaoImpl();
    }
    
    @Override
    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = ExperienciaProfissionalDao.insert(ExperienciaProfissional);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(ExperienciaProfissional ExperienciaProfssional) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = ExperienciaProfissionalDao.update(ExperienciaProfssional);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        boolean result = false;
        try {
            result = ExperienciaProfissionalDao.delete(ExperienciaProfissional);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public ExperienciaProfissional pesquisar(int Seq_Experiencia) throws PersistenceException {
        ExperienciaProfissional result = null;
        try {
            result = ExperienciaProfissionalDao.pesquisar(Seq_Experiencia);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    @Override
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException {
        ArrayList<ExperienciaProfissional> result = null;
        try {
            result = ExperienciaProfissionalDao.listar(CPF);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(ExperienciaProfissionalManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
