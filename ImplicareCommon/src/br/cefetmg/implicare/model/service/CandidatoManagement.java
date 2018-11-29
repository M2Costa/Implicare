package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CandidatoManagement extends Remote {
	
    public void insert(Candidato candidato) throws BusinessException, PersistenceException, RemoteException;

    public void update(Candidato candidato) throws BusinessException, PersistenceException, RemoteException;

    public void delete(Candidato candidato) throws BusinessException, PersistenceException, RemoteException;

    public Candidato pesquisar(long cpf) throws PersistenceException, RemoteException;
}
