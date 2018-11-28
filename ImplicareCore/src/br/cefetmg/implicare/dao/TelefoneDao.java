package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface TelefoneDao {

    public boolean insert(Telefone Telefone) throws PersistenceException;

    public boolean update(Telefone Telefone) throws PersistenceException;

    public boolean delete(Telefone Telefone) throws PersistenceException;

    public Telefone pesquisar(int Seq_Telefone) throws PersistenceException;

    public ArrayList<Telefone> listar(long CPF_CNPJ) throws PersistenceException;
}
