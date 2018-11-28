package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.exception.PersistenceException;

public interface CandidatoDao {

    public boolean insert(Candidato Candidato) throws PersistenceException;

    public boolean update(Candidato Candidato) throws PersistenceException;

    public boolean delete(Candidato Candidato) throws PersistenceException;

    public Candidato pesquisar(long CPF_CNPJ) throws PersistenceException;
}
