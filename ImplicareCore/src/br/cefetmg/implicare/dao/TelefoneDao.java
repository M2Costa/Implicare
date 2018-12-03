package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.Telefone;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface TelefoneDao extends GenericDao {

    public void insert(Telefone telefone) throws PersistenceException;

    public void update(Telefone telefone) throws PersistenceException;

    public void delete(Telefone telefone) throws PersistenceException;

    public Telefone pesquisar(int seqTelefone) throws PersistenceException;

    public ArrayList<Telefone> listar(long cpfCnpj) throws PersistenceException;
}
