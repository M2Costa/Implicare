package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.FormacaoAcademica;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FormacaoAcademicaDaoImpl implements FormacaoAcademicaDao {
    
    private static FormacaoAcademicaDaoImpl formacaoAcademicaDao = null;
    
    private FormacaoAcademicaDaoImpl(){}
    
    public static FormacaoAcademicaDaoImpl getInstance() {
        if (formacaoAcademicaDao == null) {
            formacaoAcademicaDao = new FormacaoAcademicaDaoImpl();
        }
        return formacaoAcademicaDao;
    }

    @Override
    public void insert(FormacaoAcademica formacaoAcademica) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(FormacaoAcademica formacaoAcademica) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(FormacaoAcademica formacaoAcademica) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FormacaoAcademica pesquisar(int seqFormacao) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FormacaoAcademica> listar(long cpf) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
