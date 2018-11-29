package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface FormacaoAcademicaManagement {

    public void insert(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException;

    public void update(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException;

    public void delete(FormacaoAcademica formacaoAcademica) throws BusinessException, PersistenceException;

    public FormacaoAcademica pesquisar(int seqFormacao) throws PersistenceException;

    public ArrayList<FormacaoAcademica> listar(long cpf) throws PersistenceException;
}
