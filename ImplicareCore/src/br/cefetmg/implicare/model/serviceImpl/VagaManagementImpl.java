package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.VagaDao;
import br.cefetmg.implicare.model.daoImpl.VagaDaoImpl;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class VagaManagementImpl implements VagaManagement {
    
    private final VagaDao dao;

    public VagaManagementImpl(VagaDao dao) throws RemoteException {
        this.dao = dao;
    }

    @Override
    public void insert(Vaga vaga) throws BusinessException, PersistenceException {
        if(vaga == null)
            throw new BusinessException("A vaga não pode ser nula!");
        if(vaga.getDataPublicacao() == null)
            throw new BusinessException("A data de publicação não pode ser nula!");
        VagaDaoImpl.getInstance().insert(vaga);
    }

    @Override
    public void update(Vaga vaga) throws BusinessException, PersistenceException {
        if(vaga == null)
            throw new BusinessException("A vaga não pode ser nula!");
        if(vaga.getDataPublicacao() == null)
            throw new BusinessException("A data de publicação não pode ser nula!");
        VagaDaoImpl.getInstance().update(vaga);
    }

    @Override
    public void delete(Vaga vaga) throws PersistenceException {
        if(vaga == null)
            throw new BusinessException("A vaga não pode ser nula!");
        VagaDaoImpl.getInstance().delete(vaga);
    }

    @Override
    public Vaga pesquisar(int seqVaga) throws PersistenceException {
        return VagaDaoImpl.getInstance().pesquisar(seqVaga);
    }
    
    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long cnpj) throws PersistenceException {
        return VagaDaoImpl.getInstance().listarVagaEmpresa(cnpj);
    }

    @Override
    public ArrayList<Vaga> listarVagaCandidato(long cpf) throws PersistenceException {
        return VagaDaoImpl.getInstance().listarVagaCandidato(cpf);
    }
}