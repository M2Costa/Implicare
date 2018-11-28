package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface ExperienciaProfissionalManagement {

    public boolean insert(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException;

    public boolean update(ExperienciaProfissional ExperienciaProfissional) throws BusinessException, PersistenceException;

    public boolean delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException;

    public ExperienciaProfissional pesquisar(int SeqExperiencia) throws PersistenceException;

    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException;
}
