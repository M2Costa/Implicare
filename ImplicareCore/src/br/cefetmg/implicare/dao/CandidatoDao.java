package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.Candidato;
import br.cefetmg.implicare.exception.PersistenceException;

public interface CandidatoDao {

    public void insert(Candidato candidato) throws PersistenceException;
    
    public void update(Candidato candidato) throws PersistenceException;

    public void delete(Candidato candidato) throws PersistenceException;

    public Candidato pesquisar(long cpfCnpj) throws PersistenceException;
}
