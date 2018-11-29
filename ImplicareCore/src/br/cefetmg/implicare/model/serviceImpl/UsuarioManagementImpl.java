package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import java.rmi.RemoteException;

public class UsuarioManagementImpl implements UsuarioManagement {
    
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
