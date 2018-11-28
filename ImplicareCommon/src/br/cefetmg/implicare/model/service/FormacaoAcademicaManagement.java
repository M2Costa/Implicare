package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FormacaoAcademicaManagement extends Remote{

    public boolean insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException;

    public boolean update(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException;

    public boolean delete(FormacaoAcademica FormacaoAcademica) throws PersistenceException, RemoteException;

    public FormacaoAcademica pesquisar(int Seq_Formacao) throws PersistenceException, RemoteException;

    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException, RemoteException;
}
