package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FormacaoAcademicaManagement extends Remote{

    public void insert(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException, RemoteException;

    public void update(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException, RemoteException;

    public void delete(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException, RemoteException;

    public FormacaoAcademica pesquisar(int seqFormacao) throws PersistenceException, RemoteException;

    public ArrayList<FormacaoAcademica> listar(long cpf) throws PersistenceException, RemoteException;
}
