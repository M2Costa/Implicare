package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.model.domain.jpa.Usuario;
import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UsuarioManagementImpl extends UnicastRemoteObject implements UsuarioManagement {
    
    private final UsuarioDao dao;

    public UsuarioManagementImpl(UsuarioDao dao) throws RemoteException {
        this.dao = dao;
    }
    
    @Override
    public Usuario login(long cpfCnpj, String senha) throws BusinessException, PersistenceException, RemoteException {
        if(senha == null)
            throw new BusinessException("A senha não pode ser nula!");
        if(senha.isEmpty())
            throw new BusinessException("A senha não pode estar vazia!");
        return dao.login(cpfCnpj, senha);
    }
}
