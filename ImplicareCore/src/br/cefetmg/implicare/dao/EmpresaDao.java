package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Empresa;
import br.cefetmg.implicare.exception.PersistenceException;

public interface EmpresaDao {

    public boolean insert(Empresa Empresa) throws PersistenceException;

    public boolean update(Empresa Empresa) throws PersistenceException;

    public boolean delete(Empresa Empresa) throws PersistenceException;

    public Empresa pesquisar(long CNPJ) throws PersistenceException;
}
