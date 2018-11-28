package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.model.daoImpl.FormacaoAcademicaDaoImpl;
import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormacaoAcademicaManagementImpl implements FormacaoAcademicaManagement {

    private final FormacaoAcademicaDao FormacaoAcademicaDao;

    public FormacaoAcademicaManagementImpl() throws RemoteException {
        FormacaoAcademicaDao = new FormacaoAcademicaDaoImpl();
    }

    @Override
    public boolean insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        if(FormacaoAcademica == null)
            throw new BusinessException("FormacaoAcademica não pode ser nulo");
        return FormacaoAcademicaDao.insert(FormacaoAcademica);
            
    }

    @Override
    public boolean update(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        if(FormacaoAcademica == null)
            throw new BusinessException("FormacaoAcademica não pode ser nulo");
        return FormacaoAcademicaDao.update(FormacaoAcademica);
            
    }

    @Override
    public boolean delete(FormacaoAcademica FormacaoAcademica) throws PersistenceException, RemoteException {
        if(FormacaoAcademica == null)
            throw new BusinessException("FormacaoAcademica não pode ser nulo");
        return FormacaoAcademicaDao.delete(FormacaoAcademica);
           
    }

    @Override
    public FormacaoAcademica pesquisar(int Seq_Formacao) throws PersistenceException, RemoteException {
        return FormacaoAcademicaDao.pesquisar(Seq_Formacao);
    }

    @Override
    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException, RemoteException {
        return FormacaoAcademicaDao.listar(CPF);
    }

}
