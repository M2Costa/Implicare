package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.CandidatoVaga;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface CandidatoVagaManagement {

    public void insert(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException;

    public void update(CandidatoVaga candidatoVaga) throws BusinessException, PersistenceException;

    public ArrayList<CandidatoVaga> listar(int seqVaga) throws PersistenceException;
}
