package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CandidatoManagement extends Remote {

    public boolean insert(Candidato Candidato) throws BusinessException, PersistenceException, RemoteException;

    public boolean update(Candidato Candidato) throws BusinessException, PersistenceException, RemoteException;

    public boolean delete(Candidato Candidato) throws BusinessException, PersistenceException, RemoteException;

    public Candidato pesquisar(long CPF) throws PersistenceException, RemoteException;
}
