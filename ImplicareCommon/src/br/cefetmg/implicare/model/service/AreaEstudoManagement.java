package br.cefetmg.implicare.model.service;


import br.cefetmg.implicare.model.domain.jpa.AreaEstudo;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface AreaEstudoManagement extends Remote{

    public ArrayList<AreaEstudo> listar() throws PersistenceException, RemoteException, RemoteException;

    public AreaEstudo pesquisar(int codAreaEstudo) throws PersistenceException, RemoteException;
}
