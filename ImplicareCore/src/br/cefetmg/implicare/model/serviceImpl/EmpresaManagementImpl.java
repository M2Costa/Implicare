package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.Empresa;
import br.cefetmg.implicare.dao.EmpresaDao;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.EmpresaManagement;
import java.rmi.RemoteException;

public class EmpresaManagementImpl implements EmpresaManagement {

    private final EmpresaDao dao;

    public EmpresaManagementImpl(EmpresaDao dao) throws RemoteException{
        this.dao = dao;
    }

    @Override
    public void insert(Empresa empresa) throws BusinessException, PersistenceException, RemoteException {
        if(empresa == null)
            throw new BusinessException("A empresa não pode ser nula!");
        if(empresa.getNomRazaoSocial() == null)
            throw new BusinessException("A empresa tem que ter uma razão social!");
        if(empresa.getNomRazaoSocial().isEmpty())
            throw new BusinessException("A razão social não pode estar vazia!");
        if(empresa.getNomeFantasia() == null)
            throw new BusinessException("A empresa tem que ter um nome fantasia");
        if(empresa.getNomeFantasia().isEmpty())
            throw new BusinessException("O nome fazntasia não pode estar vazio!");
        dao.insert(empresa);
    }

    @Override
    public void update(Empresa empresa) throws BusinessException, PersistenceException, RemoteException {
        if(empresa == null)
            throw new BusinessException("A empresa não pode ser nula!");
        if(empresa.getNomRazaoSocial() == null)
            throw new BusinessException("A empresa tem que ter uma razão social!");
        if(empresa.getNomRazaoSocial().isEmpty())
            throw new BusinessException("A razão social não pode estar vazia!");
        if(empresa.getNomeFantasia() == null)
            throw new BusinessException("A empresa tem que ter um nome fantasia");
        if(empresa.getNomeFantasia().isEmpty())
            throw new BusinessException("O nome fazntasia não pode estar vazio!");
        dao.update(empresa);
    }

    @Override
    public void delete(Empresa empresa) throws BusinessException, PersistenceException, RemoteException {
        if(empresa == null)
            throw new BusinessException("A empresa não pode ser nula!");
        dao.delete(empresa);
    }

    @Override
    public Empresa pesquisar(long cnpj) throws PersistenceException, RemoteException {
        return dao.pesquisar(cnpj);
    }
}
