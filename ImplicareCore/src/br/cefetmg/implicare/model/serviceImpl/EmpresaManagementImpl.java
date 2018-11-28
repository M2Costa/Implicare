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
        if(Empresa == null)
            throw new BusinessException("Empresa não pode ser nulo");
        return EmpresaDao.insert(Empresa);  
    }

    @Override
    public boolean update(Empresa Empresa) throws BusinessException, PersistenceException {
        if(Empresa == null)
            throw new BusinessException("Empresa não pode ser nulo"); 
        return EmpresaDao.update(Empresa);
            
    }

    @Override
    public boolean delete(Empresa Empresa) throws BusinessException, PersistenceException {
        if(Empresa == null)
            throw new BusinessException("Empresa não pode ser nulo");
        return EmpresaDao.delete(Empresa);
    }

    @Override
    public Empresa pesquisar(long CNPJ) throws PersistenceException {
        return EmpresaDao.pesquisar(CNPJ);
    }

}
