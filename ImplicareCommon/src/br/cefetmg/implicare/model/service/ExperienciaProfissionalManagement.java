package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface ExperienciaProfissionalManagement {

    public void insert(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException;

    public void update(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException;

    public void delete(ExperienciaProfissional experienciaProfissional) throws BusinessException, PersistenceException;

    public ExperienciaProfissional pesquisar(int seqExperiencia) throws PersistenceException;

    public ArrayList<ExperienciaProfissional> listar(long cpf) throws PersistenceException;
}
