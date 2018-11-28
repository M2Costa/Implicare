package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmpresaManagement extends Remote{

    public boolean insert(Empresa Empresa) throws BusinessException, PersistenceException, RemoteException;

    public boolean update(Empresa Empresa) throws BusinessException, PersistenceException, RemoteException;

    public boolean delete(Empresa Empresa) throws BusinessException, PersistenceException, RemoteException;

    public Empresa pesquisar(long CNPJ) throws PersistenceException, RemoteException;
}
