package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CandidatoVagaDao;
import static br.cefetmg.implicare.dao.GenericDao.UP;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.CandidatoVaga;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CandidatoVagaDaoImpl implements CandidatoVagaDao {
    
    private static CandidatoVagaDaoImpl candidatoVagaDao;
    
    private CandidatoVagaDaoImpl(){}
    
    public static CandidatoVagaDaoImpl getInstance() {
        if (candidatoVagaDao == null) {
            candidatoVagaDao = new CandidatoVagaDaoImpl();
        }
        return candidatoVagaDao;
    }

    @Override
    public void insert(CandidatoVaga candidatoVaga) throws PersistenceException {
        if (candidatoVaga == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.persist(candidatoVaga);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(CandidatoVaga candidatoVaga) throws PersistenceException {
        if (candidatoVaga == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.refresh(candidatoVaga);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<CandidatoVaga> listarAceitos(int seqVaga) throws PersistenceException {
        try {
            return (ArrayList<CandidatoVaga>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM candidato_vaga WHERE status_candidato = 'A' AND seq_vaga=?")
                    .setParameter(1, seqVaga)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<CandidatoVaga> listar(int seqVaga) throws PersistenceException {
        try {
            return (ArrayList<CandidatoVaga>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM candidato_vaga WHERE seq_vaga=?")
                    .setParameter(1, seqVaga)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }
}