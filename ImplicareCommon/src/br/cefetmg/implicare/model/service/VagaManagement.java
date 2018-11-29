package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VagaManagement extends Remote{

    public void insert(Vaga vaga) throws BusinessException, PersistenceException, RemoteException;

    public void update(Vaga vaga) throws BusinessException, PersistenceException, RemoteException;

    public void delete(Vaga vaga) throws BusinessException, PersistenceException, RemoteException;

    public Vaga pesquisar(int seqVaga) throws PersistenceException, RemoteException;

    public ArrayList<Vaga> listarVagaEmpresa(long cnpj) throws PersistenceException, RemoteException;

    public ArrayList<Vaga> listarVagaCandidato(long cpf) throws PersistenceException, RemoteException;
}
