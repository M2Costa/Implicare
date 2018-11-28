package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface VagaManagement {

    public void insert(Vaga Vaga) throws BusinessException, PersistenceException;

    public void update(Vaga Vaga) throws BusinessException, PersistenceException;

    public void delete(Vaga Vaga) throws PersistenceException;

    public Vaga pesquisar(int Seq_Vaga) throws PersistenceException;

    public ArrayList<Vaga> listarVagaEmpresa(long CNPJ) throws PersistenceException;

    public ArrayList<Vaga> listarVagaCandidato(long CPF) throws PersistenceException;
}
