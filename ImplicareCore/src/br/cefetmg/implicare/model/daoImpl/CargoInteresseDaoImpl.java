package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;
import br.cefetmg.implicare.dao.FormacaoAcademicaIdDao;
import br.cefetmg.implicare.model.domain.jpa.relacionamentos.FormacaoAcademicaId;

public class CargoInteresseDaoImpl implements FormacaoAcademicaIdDao {
    
    private static CargoInteresseDaoImpl cargoInteresseDao = null;
    
    private CargoInteresseDaoImpl(){}
    
    public static CargoInteresseDaoImpl getInstance() {
        if (cargoInteresseDao == null) {
            cargoInteresseDao = new CargoInteresseDaoImpl();
        }
        return cargoInteresseDao;
    }

    @Override
    public void insert(FormacaoAcademicaId formacaoAcademicaId) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(FormacaoAcademicaId formacaoAcademicaId) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<FormacaoAcademicaId> listar(long cpf) throws PersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
