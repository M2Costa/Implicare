package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ExperienciaProfissionalManagement extends Remote{

    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException, RemoteException;

    public boolean update(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException, RemoteException;

    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException, RemoteException;
  
    public ExperienciaProfissional pesquisar(int Seq_Experiencia) throws PersistenceException, RemoteException;

    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException, RemoteException;
}
