package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;

public interface EmpresaManagement {

    public void insert(Empresa empresa) throws BusinessException, PersistenceException;

    public void update(Empresa empresa) throws BusinessException, PersistenceException;

    public void delete(Empresa empresa) throws BusinessException, PersistenceException;

    public Empresa pesquisar(long cnpj) throws PersistenceException;
}
