package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.FormacaoAcademica;
import br.cefetmg.implicare.dao.FormacaoAcademicaDao;

import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.FormacaoAcademicaManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class FormacaoAcademicaManagementImpl implements FormacaoAcademicaManagement {

    private final FormacaoAcademicaDao dao;

    public FormacaoAcademicaManagementImpl(FormacaoAcademicaDao dao)
            throws RemoteException{
        this.dao = dao;
    }

    @Override
    public void insert(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        if(formacaoAcademica == null)
            throw new BusinessException("A formação acadêmica dada não pode ser nula!");
        if(formacaoAcademica.getDataInicio() == null)
            throw new BusinessException("Uma formação acadêmica tem que ter uma data de início!");
        if(formacaoAcademica.getDataTermino() == null)
            throw new BusinessException("Uma formação acadêmica tem que ter uma data de término!");
        if(formacaoAcademica.getInstituicaoEnsino() == null)
            throw new BusinessException("Uma formação acadêmica tem que ter uma instituição de ensino!");
        if(formacaoAcademica.getInstituicaoEnsino().isEmpty())
            throw new BusinessException("O campo instituição de ensino não pode estar vazio!");
        dao.insert(formacaoAcademica);
    }

    @Override
    public void update(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        if(formacaoAcademica == null)
            throw new BusinessException("A formação acadêmica dada não pode ser nula!");
        if(formacaoAcademica.getDataInicio() == null)
            throw new BusinessException("Uma formação acadêmica tem que ter uma data de início!");
        if(formacaoAcademica.getDataTermino() == null)
            throw new BusinessException("Uma formação acadêmica tem que ter uma data de término!");
        if(formacaoAcademica.getInstituicaoEnsino() == null)
            throw new BusinessException("Uma formação acadêmica tem que ter uma instituição de ensino!");
        if(formacaoAcademica.getInstituicaoEnsino().isEmpty())
            throw new BusinessException("O campo instituição de ensino não pode estar vazio!");
        dao.update(formacaoAcademica);
    }

    @Override
    public void delete(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException, RemoteException {
        if(formacaoAcademica == null)
            throw new BusinessException("A formação acadêmica dada não pode ser nula!");
        dao.delete(formacaoAcademica);
    }

    @Override
    public FormacaoAcademica pesquisar(int seqFormacao) throws PersistenceException, RemoteException {
        return dao.pesquisar(seqFormacao);
    }

    @Override
    public ArrayList<FormacaoAcademica> listar(long cpf) throws PersistenceException, RemoteException {
        return dao.listar(cpf);
    }

}
