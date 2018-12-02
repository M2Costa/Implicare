package br.cefetmg.implicare.model.service;


import br.cefetmg.implicare.model.domain.jpa.ExperienciaProfissional;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ExperienciaProfissionalManagement extends Remote{

    public void insert(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException, RemoteException;

    public void update(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException, RemoteException;

    public void delete(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException, RemoteException;

    public ExperienciaProfissional pesquisar(int seqExperiencia) throws PersistenceException, RemoteException;

    public ArrayList<ExperienciaProfissional> listar(long cpf) throws PersistenceException, RemoteException;
}