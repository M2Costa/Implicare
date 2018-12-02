package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.jpa.relacionamentos.FormacaoAcademicaId;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface FormacaoAcademicaIdDao {

    public void insert(FormacaoAcademicaId formacaoAcademicaId) throws PersistenceException;

    public void delete(FormacaoAcademicaId formacaoAcademicaId) throws PersistenceException;

    public ArrayList<FormacaoAcademicaId> listar(long cpf) throws PersistenceException;
}
