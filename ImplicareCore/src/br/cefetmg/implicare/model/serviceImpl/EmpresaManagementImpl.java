package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.EmpresaDao;
import br.cefetmg.implicare.model.daoImpl.EmpresaDaoImpl;
import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaManagementImpl implements EmpresaManagement {

    private final EmpresaDao EmpresaDao;

    public EmpresaManagementImpl() {
        EmpresaDao = new EmpresaDaoImpl();
    }

    @Override
    public boolean insert(Empresa Empresa) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = EmpresaDao.insert(Empresa);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(EmpresaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean update(Empresa Empresa) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = EmpresaDao.update(Empresa);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(EmpresaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public boolean delete(Empresa Empresa) throws BusinessException, PersistenceException {
        boolean result = false;
        try {
            result = EmpresaDao.delete(Empresa);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(EmpresaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Empresa pesquisar(long CNPJ) throws PersistenceException {
        Empresa result = null;
        try {
            result = EmpresaDao.pesquisar(CNPJ);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(EmpresaManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
