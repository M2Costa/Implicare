package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CandidatoVagaDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.CandidatoVaga;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidatoVagaDaoImpl implements CandidatoVagaDao {
    
    private static CandidatoVagaDaoImpl candidatoVagaDao = null;
    
    private CandidatoVagaDaoImpl(){}
    
    public static CandidatoVagaDaoImpl getInstance() {
        if (candidatoVagaDao == null) {
            candidatoVagaDao = new CandidatoVagaDaoImpl();
        }
        return candidatoVagaDao;
    }

    @Override
    public void insert(CandidatoVaga sanidatoVaga) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(CandidatoVaga sanidatoVaga) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CandidatoVaga> listarAceitos(int seqVaga) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<CandidatoVaga> listar(int seqVaga) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
