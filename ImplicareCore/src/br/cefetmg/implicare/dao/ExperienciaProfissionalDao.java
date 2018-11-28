package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface ExperienciaProfissionalDao {

    public void insert(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;

    public void update(ExperienciaProfissional ExperienciaProfssional) throws PersistenceException;

    public void delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;

    public ExperienciaProfissional pesquisar(int Seq_Experiencia) throws PersistenceException;

    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException;
}
