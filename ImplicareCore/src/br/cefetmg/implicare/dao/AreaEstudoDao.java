package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface AreaEstudoDao {

    public ArrayList<AreaEstudo> listar() throws PersistenceException;

    public AreaEstudo pesquisar(int Cod_Area_Estudo) throws PersistenceException;
}
