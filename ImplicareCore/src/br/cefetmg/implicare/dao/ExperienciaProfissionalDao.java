package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface ExperienciaProfissionalDao {

    public void insert(ExperienciaProfissional experienciaProfissional) throws PersistenceException;

    public void update(ExperienciaProfissional experienciaProfssional) throws PersistenceException;

    public void delete(ExperienciaProfissional experienciaProfissional) throws PersistenceException;

    public ExperienciaProfissional pesquisar(int seqExperiencia) throws PersistenceException;

    public ArrayList<ExperienciaProfissional> listar(long cpf) throws PersistenceException;
}