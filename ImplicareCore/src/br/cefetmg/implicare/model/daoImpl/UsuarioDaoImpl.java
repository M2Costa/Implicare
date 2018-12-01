package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Usuario;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDaoImpl implements UsuarioDao {
    
    private static UsuarioDao UsuarioDao;

    private UsuarioDaoImpl() {}
    
    public static UsuarioDao getInstance() {
        if (UsuarioDao == null) {
            UsuarioDao = new UsuarioDaoImpl();
        }
        return UsuarioDao;
    }

    @Override
    public Usuario login(long cpfCnpj, String senha) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}