package br.cefetmg.implicare.model.service;


import br.cefetmg.implicare.model.domain.jpa.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CargoManagement extends Remote{

    public ArrayList<Cargo> listar() throws PersistenceException, RemoteException;
    
    public ArrayList<Cargo> listarCargoAreaEstudo(long cpf) throws PersistenceException, RemoteException;

    public Cargo pesquisar(int codCargo) throws PersistenceException, RemoteException;
}