package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.CandidatoVaga;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CandidatoVagaDao {

    public void insert(CandidatoVaga sanidatoVaga) throws PersistenceException;

    public void update(CandidatoVaga sanidatoVaga) throws PersistenceException;

    public ArrayList<CandidatoVaga> listarAceitos(int seqVaga) throws PersistenceException;

    public ArrayList<CandidatoVaga> listar(int seqVaga) throws PersistenceException;
}
