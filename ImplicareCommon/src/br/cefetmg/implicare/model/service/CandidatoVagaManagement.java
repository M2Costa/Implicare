package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CandidatoVagaManagement {

    public boolean insert(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException;

    public boolean update(CandidatoVaga CandidatoVaga) throws BusinessException, PersistenceException;

    public ArrayList<CandidatoVaga> listar(int Seq_Vaga) throws PersistenceException;
}
