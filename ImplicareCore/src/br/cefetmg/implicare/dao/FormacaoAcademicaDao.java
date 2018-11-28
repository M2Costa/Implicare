package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.FormacaoAcademica;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface FormacaoAcademicaDao {

    public boolean insert(FormacaoAcademica FormacaoAcademica) throws PersistenceException;

    public boolean update(FormacaoAcademica FormacaoAcademica) throws PersistenceException;

    public boolean delete(FormacaoAcademica FormacaoAcademica) throws PersistenceException;

    public FormacaoAcademica pesquisar(int Seq_Formacao) throws PersistenceException;

    public ArrayList<FormacaoAcademica> listar(long CPF) throws PersistenceException;
}
