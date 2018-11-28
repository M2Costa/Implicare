package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CandidatoVagaDao {

    public boolean insert(CandidatoVaga CandidatoVaga) throws PersistenceException;

    public boolean update(CandidatoVaga CandidatoVaga) throws PersistenceException;

    public ArrayList<CandidatoVaga> listarAceitos(int Seq_Vaga) throws PersistenceException;

    public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException;
}
