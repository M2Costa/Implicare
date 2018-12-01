package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.model.domain.jpa.AreaEstudo;
import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("Implicare");
            EntityManager manager = factory.createEntityManager();
            Query query = manager.createNativeQuery("SELECT * FROM cidade");

            ArrayList<AreaEstudo> listAll = (ArrayList<AreaEstudo>) query.getResultList();

            return listAll;

        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(e);
        }
    }

    @Override
    public AreaEstudo pesquisar(int codAreaEstudo) throws PersistenceException {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("Implicare");
            EntityManager manager = factory.createEntityManager();

            AreaEstudo cidade = manager.find(AreaEstudo.class, codAreaEstudo);

            return cidade;

        } catch (PersistenceException e) {
            e.printStackTrace();
            throw new PersistenceException(e);
        }
    }

}
