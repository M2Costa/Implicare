package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;

public interface EmpresaManagement {

    public boolean insert(Empresa Empresa) throws BusinessException, PersistenceException;

    public boolean update(Empresa Empresa) throws BusinessException, PersistenceException;

    public boolean delete(Empresa Empresa) throws BusinessException, PersistenceException;

    public Empresa pesquisar(long CNPJ) throws PersistenceException;
}
