package br.cefetmg.implicare.model.service;



import br.cefetmg.implicare.model.domain.jpa.relacionamentos.FormacaoAcademicaId;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface FormacaoAcademicaIdManagement extends Remote{

    public void insert(FormacaoAcademicaId formacaoAcademicaId) throws BusinessException, PersistenceException, RemoteException;

    public void delete(FormacaoAcademicaId formacaoAcademicaId) throws BusinessException, PersistenceException, RemoteException;

    public ArrayList<FormacaoAcademicaId> listar(long cpf) throws PersistenceException, RemoteException;
}
