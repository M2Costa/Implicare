package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.Empresa;
import br.cefetmg.implicare.exception.PersistenceException;

public interface EmpresaDao extends GenericDao {

    public void insert(Empresa empresa) throws PersistenceException;

    public void update(Empresa empresa) throws PersistenceException;

    public void delete(Empresa empresa) throws PersistenceException;

    public Empresa pesquisar(long cnpj) throws PersistenceException;
}
