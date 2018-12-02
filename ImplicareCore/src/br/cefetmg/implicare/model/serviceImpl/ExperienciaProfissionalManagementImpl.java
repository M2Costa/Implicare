package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.ExperienciaProfissional;
import br.cefetmg.implicare.dao.ExperienciaProfissionalDao;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.ExperienciaProfissionalManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ExperienciaProfissionalManagementImpl implements ExperienciaProfissionalManagement {
    private final ExperienciaProfissionalDao dao;

    public ExperienciaProfissionalManagementImpl(ExperienciaProfissionalDao dao)
            throws RemoteException{
        this.dao = dao;
    }
    
    @Override
    public void insert(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException, RemoteException {
        if(experienciaProfissional == null)
            throw new BusinessException("A experiência profissional não pode ser nula!");
        if(experienciaProfissional.getNomEmpresa() == null)
            throw new BusinessException("O nome da empresa não pode ser nulo!");
        if(experienciaProfissional.getNomEmpresa().isEmpty())
            throw new BusinessException("O nome da empresa não pode estar vazio!");
        if(experienciaProfissional.getDataInicio() == null)
            throw new BusinessException("Uma experiência profissional tem que ter uma data de início!");
        dao.insert(experienciaProfissional);
    }

    @Override
    public void update(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException, RemoteException {
        if(experienciaProfissional == null)
            throw new BusinessException("A experiência profissional não pode ser nula!");
        if(experienciaProfissional.getNomEmpresa() == null)
            throw new BusinessException("O nome da empresa não pode ser nulo!");
        if(experienciaProfissional.getNomEmpresa().isEmpty())
            throw new BusinessException("O nome da empresa não pode estar vazio!");
        if(experienciaProfissional.getDataInicio() == null)
            throw new BusinessException("Uma experiência profissional tem que ter uma data de início!");
        dao.update(experienciaProfissional);
    }

    @Override
    public void delete(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException, RemoteException {
        if(experienciaProfissional == null)
            throw new BusinessException("A experiência profissional não pode ser nula!");
        dao.delete(experienciaProfissional);
    }

    @Override
    public ExperienciaProfissional pesquisar(int seqExperiencia) throws PersistenceException, RemoteException {
        return dao.pesquisar(seqExperiencia);
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long cpf) throws PersistenceException, RemoteException {
        return dao.listar(cpf);
    }
}