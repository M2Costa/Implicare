package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.jpa.Usuario;
import br.cefetmg.implicare.exception.BusinessException;

import br.cefetmg.implicare.exception.PersistenceException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UsuarioManagement extends Remote{

	public Usuario login(long cpfCnpj, String senha) throws BusinessException, PersistenceException, RemoteException;
}
