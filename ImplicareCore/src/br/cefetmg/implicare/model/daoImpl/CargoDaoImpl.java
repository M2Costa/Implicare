package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Cargo;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoDaoImpl implements CargoDao {
    
    private static CargoDaoImpl cargoDao = null;
    
    private CargoDaoImpl(){}
    
    public static CargoDaoImpl getInstance() {
        if (cargoDao == null) {
            cargoDao = new CargoDaoImpl();
        }
        return cargoDao;
    }

    @Override
    public ArrayList<Cargo> listar() throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(long cpf) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cargo pesquisar(int codCargo) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
