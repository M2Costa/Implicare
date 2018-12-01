package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.FormacaoAcademica;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface FormacaoAcademicaDao {

    public void insert(FormacaoAcademica formacaoAcademica) throws PersistenceException;

    public void update(FormacaoAcademica formacaoAcademica) throws PersistenceException;

    public void delete(FormacaoAcademica formacaoAcademica) throws PersistenceException;

    public FormacaoAcademica pesquisar(int seqFormacao) throws PersistenceException;

    public ArrayList<FormacaoAcademica> listar(long cpf) throws PersistenceException;
}
