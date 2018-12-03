package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.model.domain.jpa.AreaEstudo;
import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class AreaEstudoDaoImpl implements AreaEstudoDao {
    
    private static AreaEstudoDaoImpl areaEstudoDao;
    
    private AreaEstudoDaoImpl(){}
    
    public static AreaEstudoDaoImpl getInstance() {
        if (areaEstudoDao == null) {
            areaEstudoDao = new AreaEstudoDaoImpl();
        }
        return areaEstudoDao;
    }

    @Override
    public ArrayList<AreaEstudo> listar() throws PersistenceException {
        try {
            return (ArrayList<AreaEstudo>)
                    Persistence
                        .createEntityManagerFactory("Implicare")
                        .createEntityManager()
                        .createNativeQuery("SELECT * FROM area_estudo")
                        .getResultList();
        } catch (PersistenceException e) {
            Logger.getLogger(AreaEstudoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public AreaEstudo pesquisar(int codAreaEstudo) throws PersistenceException {
        try {
            return Persistence
                        .createEntityManagerFactory("Implicare")
                        .createEntityManager()
                        .find(AreaEstudo.class, codAreaEstudo);
        } catch (PersistenceException e) {
            Logger.getLogger(AreaEstudoDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

}
