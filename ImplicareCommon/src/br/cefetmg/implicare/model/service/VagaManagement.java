package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface VagaManagement {

    public boolean insert(Vaga Vaga) throws BusinessException, PersistenceException;

    public boolean update(Vaga Vaga) throws BusinessException, PersistenceException;

    public boolean delete(Vaga Vaga) throws PersistenceException;

    public Vaga pesquisar(int Seq_Vaga) throws PersistenceException;

    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException;

    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException;
}
