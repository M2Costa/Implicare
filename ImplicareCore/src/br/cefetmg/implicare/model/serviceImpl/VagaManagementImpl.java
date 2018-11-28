package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.daoImpl.VagaDaoImpl;
import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.VagaManagement;
import java.util.ArrayList;

public class VagaManagementImpl implements VagaManagement {

    @Override
    public void insert(Vaga Vaga) throws BusinessException, PersistenceException {
        VagaDaoImpl.getInstance().insert(Vaga);
    }

    @Override
    public void update(Vaga Vaga) throws BusinessException, PersistenceException {
        VagaDaoImpl.getInstance().update(Vaga);
    }

    @Override
    public void delete(Vaga Vaga) throws PersistenceException {
        VagaDaoImpl.getInstance().delete(Vaga);
    }

    @Override
    public Vaga pesquisar(int Seq_Vaga) throws PersistenceException {
        return VagaDaoImpl.getInstance().pesquisar(Seq_Vaga);
    }
    
    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException {
        return VagaDaoImpl.getInstance().listarVagaEmpresa(CNPJ);
    }

    @Override
    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException {
        return VagaDaoImpl.getInstance().listarVagaCandidato(CPF);
    }
}