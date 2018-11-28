package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.TelefoneDao;
import br.cefetmg.implicare.model.daoImpl.TelefoneDaoImpl;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.TelefoneManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefoneManagementImpl implements TelefoneManagement {

    private final TelefoneDao TelefoneDao;

    public TelefoneManagementImpl() {
        TelefoneDao = new TelefoneDaoImpl();
    }

    @Override
    public boolean insert(Telefone Telefone) throws BusinessException, PersistenceException {
        if(Telefone == null)
            throw new BusinessException("Telefone não pode ser nulo");
        return TelefoneDao.insert(Telefone);
        
    }

    @Override
    public boolean update(Telefone Telefone) throws BusinessException, PersistenceException {
        if(Telefone == null)
            throw new BusinessException("Telefone não pode ser nulo");
        return TelefoneDao.update(Telefone);
    }

    @Override
    public boolean delete(Telefone Telefone) throws PersistenceException {
        if(Telefone == null)
            throw new BusinessException("Telefone não pode ser nulo");
        return TelefoneDao.delete(Telefone);
            
    }

    @Override
    public Telefone pesquisar(int Seq_Telefone) throws PersistenceException {
        return TelefoneDao.pesquisar(Seq_Telefone);
            
    }

    @Override
    public ArrayList<Telefone> listar(long CPF_CNPJ) throws PersistenceException {
        return TelefoneDao.listar(CPF_CNPJ);
            
    }

}
