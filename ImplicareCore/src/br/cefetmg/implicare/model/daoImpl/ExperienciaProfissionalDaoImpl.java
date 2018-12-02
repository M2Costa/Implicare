package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.ExperienciaProfissionalDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.ExperienciaProfissional;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExperienciaProfissionalDaoImpl implements ExperienciaProfissionalDao {
    private static ExperienciaProfissionalDao ExperienciaProfissionalDao;
    
    private ExperienciaProfissionalDaoImpl(){}

    public static ExperienciaProfissionalDao getInstance() {
        if (ExperienciaProfissionalDao == null) {
            ExperienciaProfissionalDao = new ExperienciaProfissionalDaoImpl();
        }
        return ExperienciaProfissionalDao;
    }

    @Override
    public void insert(ExperienciaProfissional experienciaProfissional) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ExperienciaProfissional experienciaProfssional) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(ExperienciaProfissional experienciaProfissional) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ExperienciaProfissional pesquisar(int seqExperiencia) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long cpf) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
