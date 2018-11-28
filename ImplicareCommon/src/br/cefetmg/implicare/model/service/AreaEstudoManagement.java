package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;

public interface AreaEstudoManagement {

    public ArrayList<AreaEstudo> listar() throws PersistenceException;

    public AreaEstudo pesquisar(int Cod_Area_Estudo) throws PersistenceException;
}
