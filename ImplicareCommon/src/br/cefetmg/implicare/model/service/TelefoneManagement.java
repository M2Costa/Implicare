package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface TelefoneManagement {

    public void insert(Telefone telefone) throws BusinessException, PersistenceException;

    public void update(Telefone telefone) throws BusinessException, PersistenceException;

    public void delete(Telefone telefone) throws BusinessException, PersistenceException;

    public Telefone pesquisar(int seqTelefone) throws PersistenceException;

    public ArrayList<Telefone> listar(long cpjCnpj) throws PersistenceException;
}
