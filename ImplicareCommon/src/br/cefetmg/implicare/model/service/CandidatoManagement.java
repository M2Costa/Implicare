package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Candidato;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;

public interface CandidatoManagement {

    public void insert(Candidato candidato) throws BusinessException, PersistenceException;

    public void update(Candidato candidato) throws BusinessException, PersistenceException;

    public void delete(Candidato candidato) throws BusinessException, PersistenceException;

    public Candidato pesquisar(long cpf) throws PersistenceException;
}
