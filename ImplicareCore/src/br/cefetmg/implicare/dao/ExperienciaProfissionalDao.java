package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.ExperienciaProfissional;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface ExperienciaProfissionalDao extends GenericDao {

    public void insert(ExperienciaProfissional experienciaProfissional) throws PersistenceException;

    public void update(ExperienciaProfissional experienciaProfissional) throws PersistenceException;

    public void delete(ExperienciaProfissional experienciaProfissional) throws PersistenceException;

    public ExperienciaProfissional pesquisar(int seqExperiencia) throws PersistenceException;

    public ArrayList<ExperienciaProfissional> listar(long cpf) throws PersistenceException;
}