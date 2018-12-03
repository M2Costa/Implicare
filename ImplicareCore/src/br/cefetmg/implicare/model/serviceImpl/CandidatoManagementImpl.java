package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.Candidato;
import br.cefetmg.implicare.dao.CandidatoDao;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CandidatoManagementImpl extends UnicastRemoteObject implements CandidatoManagement {

    private final CandidatoDao dao;

    public CandidatoManagementImpl(CandidatoDao dao) throws RemoteException{
        this.dao = dao;
    }
    

    @Override
    public void insert(Candidato candidato) throws BusinessException, PersistenceException, RemoteException {
        if(candidato == null)
            throw new BusinessException("O candidato não pode ser nulo!");
        if(candidato.getNome() == null)
            throw new BusinessException("O candidato tem que ter um nome!");
        if(candidato.getNome().isEmpty())
            throw new BusinessException("O nome do candidato não pode estar vazio!");
        if(candidato.getDataNascimento() == null)
            throw new BusinessException("O candidato tem que ter uma data de nascimento!");
        dao.insert(candidato);
    }

    @Override
    public void update(Candidato candidato) throws BusinessException, PersistenceException, RemoteException {
        if(candidato == null)
            throw new BusinessException("O candidato não pode ser nulo!");
        if(candidato.getNome() == null)
            throw new BusinessException("O candidato tem que ter um nome!");
        if(candidato.getNome().isEmpty())
            throw new BusinessException("O nome do candidato não pode estar vazio!");
        if(candidato.getDataNascimento() == null)
            throw new BusinessException("O candidato tem que ter uma data de nascimento!");
        dao.update(candidato);
    }

    @Override
    public void delete(Candidato candidato) throws BusinessException, PersistenceException, RemoteException {
        dao.delete(candidato);
    }

    @Override
    public Candidato pesquisar(long cpf) throws PersistenceException, RemoteException {
        return dao.pesquisar(cpf);
    }

}
