package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.VagaDao;
import br.cefetmg.implicare.model.daoImpl.VagaDaoImpl;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VagaManagementImpl implements VagaManagement {

    private final VagaDao VagaDao;

    public VagaManagementImpl() throws RemoteException {
        VagaDao = new VagaDaoImpl();
    }

    @Override
    public boolean insert(Vaga Vaga) throws BusinessException, PersistenceException, RemoteException {
        if(Vaga == null)
            throw new BusinessException("VAga não pode ser nulo");
        return VagaDao.insert(Vaga);
            
    }

    @Override
    public boolean update(Vaga Vaga) throws BusinessException, PersistenceException, RemoteException {
        if(Vaga == null)
            throw new BusinessException("VAga não pode ser nulo");
        return VagaDao.update(Vaga);
            
    }

    @Override
    public boolean delete(Vaga Vaga) throws PersistenceException, RemoteException {
        if(Vaga == null)
            throw new BusinessException("VAga não pode ser nulo");
        return VagaDao.delete(Vaga);
            
    }

    @Override
    public Vaga pesquisar(int Seq_Vaga) throws PersistenceException, RemoteException {
        return VagaDao.pesquisar(Seq_Vaga);
            
    }

    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException, RemoteException {
        return VagaDao.listarVagaEmpresa(CNPJ);
           
    }

    @Override
    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException, RemoteException{
        return VagaDao.listarVagaCandidato(CPF);
    }
}
