package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;

public interface CandidatoManagement {

    public boolean insert(Candidato Candidato) throws BusinessException, PersistenceException;

    public boolean update(Candidato Candidato) throws BusinessException, PersistenceException;

    public boolean delete(Candidato Candidato) throws BusinessException, PersistenceException;

    public Candidato pesquisar(long CPF) throws PersistenceException;
}
