package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.TelefoneDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Telefone;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelefoneDaoImpl implements TelefoneDao {
    
    private static TelefoneDao telefoneDao;

    private TelefoneDaoImpl() {}
    
    public static TelefoneDao getInstance() {
        if (telefoneDao == null) {
            telefoneDao = new TelefoneDaoImpl();
        }
        return telefoneDao;
    }

    @Override
    public void insert(Telefone telefone) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Telefone telefone) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Telefone telefone) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Telefone pesquisar(int seqTelefone) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Telefone> listar(long cpfCnpj) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}