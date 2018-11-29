package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.CandidatoDao;
import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.CandidatoManagement;
import java.rmi.RemoteException;

public class CandidatoManagementImpl implements CandidatoManagement {

    private final CandidatoDao dao;

    public CandidatoManagementImpl(CandidatoDao dao) throws RemoteException{
        this.dao = dao;
    }
    

    @Override
    public void insert(Candidato candidato) throws BusinessException, PersistenceException {
        if(candidato == null)
            throw new BusinessException("O candidato não pode ser nulo!");
        if(candidato.getEmail() == null)
            throw new BusinessException("Um candidato tem que ter um e-mail!");
        if(candidato.getEmail().isEmpty())
            throw new BusinessException("O e-mail do candidato não pode estar vazio!");
        if(candidato.getSenha() == null)
            throw new BusinessException("Um candidato tem que ter uma senha!");
        if(candidato.getSenha().isEmpty())
            throw new BusinessException("A senha do candidato não pode estar vazia!");
        if(candidato.getEndereco() == null)
            throw new BusinessException("O candidato tem que ter um endereço!");
        if(candidato.getEndereco().isEmpty())
            throw new BusinessException("O endereço do candidato não pode estar vazio!");
        if(candidato.getNome() == null)
            throw new BusinessException("O candidato tem que ter um nome!");
        if(candidato.getNome().isEmpty())
            throw new BusinessException("O nome do candidato não pode estar vazio!");
        if(candidato.getDataNascimento() == null)
            throw new BusinessException("O candidato tem que ter uma data de nascimento!");
        dao.insert(candidato);
    }

    @Override
    public void update(Candidato candidato) throws BusinessException, PersistenceException {
        if(candidato == null)
            throw new BusinessException("O candidato não pode ser nulo!");
        if(candidato.getEmail() == null)
            throw new BusinessException("Um candidato tem que ter um e-mail!");
        if(candidato.getEmail().isEmpty())
            throw new BusinessException("O e-mail do candidato não pode estar vazio!");
        if(candidato.getSenha() == null)
            throw new BusinessException("Um candidato tem que ter uma senha!");
        if(candidato.getSenha().isEmpty())
            throw new BusinessException("A senha do candidato não pode estar vazia!");
        if(candidato.getEndereco() == null)
            throw new BusinessException("O candidato tem que ter um endereço!");
        if(candidato.getEndereco().isEmpty())
            throw new BusinessException("O endereço do candidato não pode estar vazio!");
        if(candidato.getNome() == null)
            throw new BusinessException("O candidato tem que ter um nome!");
        if(candidato.getNome().isEmpty())
            throw new BusinessException("O nome do candidato não pode estar vazio!");
        if(candidato.getDataNascimento() == null)
            throw new BusinessException("O candidato tem que ter uma data de nascimento!");
        dao.update(candidato);
    }

    @Override
    public void delete(Candidato candidato) throws BusinessException, PersistenceException {
        dao.delete(candidato);
    }

    @Override
    public Candidato pesquisar(long cpf) throws PersistenceException {
        return dao.pesquisar(cpf);
    }

}
