package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.model.daoImpl.UsuarioDaoImpl;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.service.UsuarioManagement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioManagementImpl implements UsuarioManagement {

    private final UsuarioDao UsuarioDao;

    public UsuarioManagementImpl() {
        UsuarioDao = new UsuarioDaoImpl();
    }

    @Override
    public Usuario login(long CPF_CNPJ, String Senha) throws PersistenceException {
        return UsuarioDao.login(CPF_CNPJ, Senha);
            
    }
}
