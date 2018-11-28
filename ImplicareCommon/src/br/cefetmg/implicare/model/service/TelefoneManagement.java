package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TelefoneManagement extends Remote{

    public boolean insert(Telefone Telefone) throws BusinessException, PersistenceException, RemoteException;

    public boolean update(Telefone Telefone) throws BusinessException, PersistenceException, RemoteException;

    public boolean delete(Telefone Telefone) throws PersistenceException, RemoteException;

    public Telefone pesquisar(int Seq_Telefone) throws PersistenceException, RemoteException;

    public ArrayList<Telefone> listar(long CPF_CNPJ) throws PersistenceException, RemoteException;
}
