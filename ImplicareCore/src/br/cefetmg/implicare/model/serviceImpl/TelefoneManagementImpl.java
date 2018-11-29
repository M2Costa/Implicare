package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.TelefoneDao;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class TelefoneManagementImpl implements TelefoneManagement {
    
    private final TelefoneDao dao;

    public TelefoneManagementImpl(TelefoneDao dao) throws RemoteException{
        this.dao = dao;
    }
    
    @Override
    public void insert(Telefone telefone) throws BusinessException, PersistenceException {
        if(telefone == null)
            throw new BusinessException("O telefone dado não pode ser nulo!");
        if(telefone.getNumTelefone() == null)
            throw new BusinessException("O número do telefone dado não pode ser nulo!");
        if(telefone.getNumTelefone().isEmpty())
            throw new BusinessException("O número do telefone dado não pode estar vazio!");
        dao.insert(telefone);
    }

    @Override
    public void update(Telefone telefone) throws BusinessException, PersistenceException {
        if(telefone == null)
            throw new BusinessException("O telefone dado não pode ser nulo!");
        if(telefone.getNumTelefone() == null)
            throw new BusinessException("O número do telefone dado não pode ser nulo!");
        if(telefone.getNumTelefone().isEmpty())
            throw new BusinessException("O número do telefone dado não pode estar vazio!");
        dao.update(telefone);
    }

    @Override
    public void delete(Telefone telefone) throws BusinessException, PersistenceException {
        if(telefone == null)
            throw new BusinessException("O telefone dado não pode ser nulo!");
        if(telefone.getNumTelefone() == null)
            throw new BusinessException("O número do telefone dado não pode ser nulo!");
        if(telefone.getNumTelefone().isEmpty())
            throw new BusinessException("O número do telefone dado não pode estar vazio!");
        dao.delete(telefone);
    }

    @Override
    public Telefone pesquisar(int seqTelefone) throws PersistenceException {
        return dao.pesquisar(seqTelefone);
    }

    @Override
    public ArrayList<Telefone> listar(long cpfCnpj) throws PersistenceException {
        return dao.listar(cpfCnpj);
    }
}
