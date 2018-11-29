package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TelefoneManagement extends Remote{
    
    public void insert(Telefone telefone) throws BusinessException, PersistenceException, RemoteException;

    public void update(Telefone telefone) throws BusinessException, PersistenceException, RemoteException;

    public void delete(Telefone telefone) throws BusinessException, PersistenceException, RemoteException;

    public Telefone pesquisar(int seqTelefone) throws PersistenceException, RemoteException;

    public ArrayList<Telefone> listar(long cpjCnpj) throws PersistenceException, RemoteException;
}
