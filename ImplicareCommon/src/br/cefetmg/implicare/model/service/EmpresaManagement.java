package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EmpresaManagement extends Remote{

	public void insert(Empresa empresa) throws BusinessException, PersistenceException, RemoteException;

    public void update(Empresa empresa) throws BusinessException, PersistenceException, RemoteException;

    public void delete(Empresa empresa) throws BusinessException, PersistenceException, RemoteException;

    public Empresa pesquisar(long cnpj) throws PersistenceException, RemoteException;
}
