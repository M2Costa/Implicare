package br.cefetmg.implicare.model.service;


import br.cefetmg.implicare.model.domain.jpa.CandidatoVaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CandidatoVagaManagement extends Remote{
	
    public void insert(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException, RemoteException;

    public void update(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException, RemoteException;

    public ArrayList<CandidatoVaga> listar(int seqVaga) throws PersistenceException, RemoteException;
}
