package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CandidatoDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Candidato;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CandidatoDaoImpl implements CandidatoDao {
    
    private static CandidatoDaoImpl candidatoDao = null;
    
    private CandidatoDaoImpl(){}
    
    public static CandidatoDaoImpl getInstance() {
        if (candidatoDao == null) {
            candidatoDao = new CandidatoDaoImpl();
        }
        return candidatoDao;
    }

    @Override
    public void insert(Candidato candidato) throws PersistenceException {
       if (candidato == null)
            throw new PersistenceException("Domínio não pode ser nulo.");


        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.persist(candidato);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(Candidato candidato) throws PersistenceException {
        if (candidato == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.refresh(candidato);
            manager.getTransaction().commit();

            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(Candidato candidato) throws PersistenceException {
        if (candidato == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = 
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.remove(candidato);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public Candidato pesquisar(long cpfCnpj) throws PersistenceException {
        try {
            return Persistence
                        .createEntityManagerFactory(UP)
                        .createEntityManager()
                        .find(Candidato.class, cpfCnpj);
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }
}