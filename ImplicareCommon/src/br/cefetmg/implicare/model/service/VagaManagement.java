package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VagaManagement extends Remote{


    public boolean insert(Vaga Vaga) throws BusinessException, PersistenceException, RemoteException;

    public boolean update(Vaga Vaga) throws BusinessException, PersistenceException, RemoteException;

    public boolean delete(Vaga Vaga) throws PersistenceException, RemoteException;

    public Vaga pesquisar(int Seq_Vaga) throws PersistenceException, RemoteException;

    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException, RemoteException;

    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException, RemoteException;
}
