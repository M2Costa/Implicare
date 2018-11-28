package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface ExperienciaProfissionalDao {

    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;

    public boolean update(ExperienciaProfissional ExperienciaProfssional) throws PersistenceException;

    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;

    public ExperienciaProfissional pesquisar(int Seq_Experiencia) throws PersistenceException;

    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException;
}
