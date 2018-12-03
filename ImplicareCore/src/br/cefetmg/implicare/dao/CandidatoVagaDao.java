package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.CandidatoVaga;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CandidatoVagaDao extends GenericDao {

    public void insert(CandidatoVaga candidatoVaga) throws PersistenceException;

    public void update(CandidatoVaga candidatoVaga) throws PersistenceException;

    public ArrayList<CandidatoVaga> listarAceitos(int seqVaga) throws PersistenceException;

    public ArrayList<CandidatoVaga> listar(int seqVaga) throws PersistenceException;
}
