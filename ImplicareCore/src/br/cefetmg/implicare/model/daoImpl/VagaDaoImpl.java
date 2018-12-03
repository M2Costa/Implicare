package br.cefetmg.implicare.model.daoImpl;

import static br.cefetmg.implicare.dao.GenericDao.UP;
import br.cefetmg.implicare.dao.VagaDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Vaga;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class VagaDaoImpl implements VagaDao {
    
    private static VagaDao VagaDao;

    private VagaDaoImpl() {}
    
    public static VagaDao getInstance() {
        if (VagaDao == null) {
            VagaDao = new VagaDaoImpl();
        }
        return VagaDao;
    }

    @Override
    public void insert(Vaga vaga) throws PersistenceException {
        if (vaga == null)
            throw new PersistenceException("Domínio não pode ser nulo.");


        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.persist(vaga);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(Vaga vaga) throws PersistenceException {
        if (vaga == null)
            throw new PersistenceException("Domínio não pode ser nulo.");


        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.refresh(vaga);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(Vaga vaga) throws PersistenceException {
        if (vaga == null)
            throw new PersistenceException("Domínio não pode ser nulo.");


        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.remove(vaga);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public Vaga pesquisar(int seqVaga) throws PersistenceException {
        try {
            return Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .find(Vaga.class, seqVaga);
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Vaga> listarVagaEmpresa(long cnpj) throws PersistenceException {
        try {
            return (ArrayList<Vaga>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM vaga WHERE cnpj=?")
                    .setParameter(1, cnpj)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Vaga> listarVagaCandidato(long cpf) throws PersistenceException {
        try {
            return (ArrayList<Vaga>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM vaga WHERE cpf=?")
                    .setParameter(1, cpf)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Vaga> listarVagaAceito(long cpf) throws PersistenceException {
        try {
            return (ArrayList<Vaga>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM vaga WHERE cpf=? AND status_vaga='1'::bit(1)")
                    .setParameter(1, cpf)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }
 
}
