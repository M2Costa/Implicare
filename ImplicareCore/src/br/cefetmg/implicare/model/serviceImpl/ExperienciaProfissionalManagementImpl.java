package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.daoImpl.ExperienciaProfissionalDaoImpl;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExperienciaProfissionalManagementImpl implements ExperienciaProfissionalManagement {

    private final ExperienciaProfissionalDao ExperienciaProfissionalDao;

    public ExperienciaProfissionalManagementImpl() throws RemoteException {
        ExperienciaProfissionalDao = new ExperienciaProfissionalDaoImpl();
    }

    @Override
    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException, RemoteException {
       if(ExperienciaProfissional == null)
            throw new BusinessException("ExperienciaProficional não pode ser nulo");
       return ExperienciaProfissionalDao.insert(ExperienciaProfissional);
    }

    @Override
    public boolean update(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException, RemoteException {
        if(ExperienciaProfissional == null)
            throw new BusinessException("ExperienciaProficional não pode ser nulo");
        
        return ExperienciaProfissionalDao.update(ExperienciaProfissional);
        
    }

    @Override
    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException, RemoteException {
        if(ExperienciaProfissional == null)
            throw new BusinessException("ExperienciaProficional não pode ser nulo");
        
        return ExperienciaProfissionalDao.delete(ExperienciaProfissional);
            
    }

    @Override
    public ExperienciaProfissional pesquisar(int Seq_Experiencia) throws PersistenceException, RemoteException {
        return ExperienciaProfissionalDao.pesquisar(Seq_Experiencia);
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException, RemoteException {
        return ExperienciaProfissionalDao.listar(CPF);
            
    }
}