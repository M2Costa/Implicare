package br.cefetmg.implicare.model.serviceImpl;


import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import br.cefetmg.implicare.model.service.FormacaoAcademicaIdManagement;
import br.cefetmg.implicare.dao.FormacaoAcademicaIdDao;
import br.cefetmg.implicare.model.domain.jpa.relacionamentos.FormacaoAcademicaId;

public class FormacaoAcademicaIdImpl implements FormacaoAcademicaIdManagement {

    private final FormacaoAcademicaIdDao dao;

    public FormacaoAcademicaIdImpl(FormacaoAcademicaIdDao dao) throws RemoteException{
        this.dao = dao;
    }

    @Override
    public void insert(FormacaoAcademicaId formacaoAcademicaId) throws BusinessException, PersistenceException, RemoteException {
        if(formacaoAcademicaId == null)
            throw new BusinessException("O cargo de interesse não pode ser nulo!");
        dao.insert(formacaoAcademicaId);
    }

    @Override
    public void delete(FormacaoAcademicaId formacaoAcademicaId) throws BusinessException, PersistenceException, RemoteException {
        if(formacaoAcademicaId == null)
            throw new BusinessException("O cargo de interesse não pode ser nulo!");
        dao.delete(formacaoAcademicaId);
    }

    @Override
    public ArrayList<FormacaoAcademicaId> listar(long cpf) throws PersistenceException, RemoteException {
        return dao.listar(cpf);
    }

}
