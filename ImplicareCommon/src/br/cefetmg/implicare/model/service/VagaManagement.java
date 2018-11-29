package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Vaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface VagaManagement {

    public void insert(Vaga vaga) throws BusinessException, PersistenceException;

    public void update(Vaga vaga) throws BusinessException, PersistenceException;

    public void delete(Vaga vaga) throws BusinessException, PersistenceException;

    public Vaga pesquisar(int seqVaga) throws PersistenceException;

    public ArrayList<Vaga> listarVagaEmpresa(long cnpj) throws PersistenceException;

    public ArrayList<Vaga> listarVagaCandidato(long cpf) throws PersistenceException;
}
