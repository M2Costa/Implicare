package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.ExperienciaProfissionalDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.ExperienciaProfissional;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
        if (experienciaProfissional == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.persist(experienciaProfissional);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(ExperienciaProfissional experienciaProfissional) throws PersistenceException {
        if (experienciaProfissional == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.refresh(experienciaProfissional);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(ExperienciaProfissional experienciaProfissional) throws PersistenceException {
        if (experienciaProfissional == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.remove(experienciaProfissional);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ExperienciaProfissional pesquisar(int seqExperiencia) throws PersistenceException {
        try {
            return Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .find(ExperienciaProfissional.class, seqExperiencia);
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long cpf) throws PersistenceException {
        try {
            return (ArrayList<ExperienciaProfissional>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM experiencia_profissional WHERE cpf=?")
                    .setParameter(1, cpf)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

}
