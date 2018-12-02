package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.EmpresaDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Empresa;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaDaoImpl implements EmpresaDao {
    
    private static EmpresaDaoImpl empresaDao = null;
    
    private EmpresaDaoImpl(){}
    
    public static EmpresaDaoImpl getInstance() {
        if (empresaDao == null) {
            empresaDao = new EmpresaDaoImpl();
        }
        return empresaDao;
    }

    @Override
    public void insert(Empresa empresa) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Empresa empresa) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Empresa empresa) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empresa pesquisar(long cnpj) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
