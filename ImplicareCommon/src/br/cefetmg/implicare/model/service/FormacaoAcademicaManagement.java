package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface FormacaoAcademicaManagement {

    public boolean insert(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException;

    public boolean update(FormacaoAcademica FormacaoAcademica) throws BusinessException, PersistenceException;

    public boolean delete(FormacaoAcademica FormacaoAcademica) throws PersistenceException;

    public FormacaoAcademica pesquisar(int Seq_Formacao) throws PersistenceException;

    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException;
}
