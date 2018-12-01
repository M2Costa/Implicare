package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.model.domain.jpa.Vaga;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface VagaDao {

    public void insert(Vaga vaga) throws PersistenceException;

    public void update(Vaga vaga) throws PersistenceException;

    public void delete(Vaga vaga) throws PersistenceException;

    public Vaga pesquisar(int seqVaga) throws PersistenceException;

    public ArrayList<Vaga> listarVagaEmpresa(long cnpj) throws PersistenceException;

    public ArrayList<Vaga> listarVagaCandidato(long cpf) throws PersistenceException;

    public ArrayList<Vaga> listarVagaAceito(long cpf) throws PersistenceException;

}
