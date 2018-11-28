package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CandidatoVagaManagement extends Remote{

    public boolean insert(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException, RemoteException;

    public boolean update(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException, RemoteException;

    public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException, RemoteException;
}
