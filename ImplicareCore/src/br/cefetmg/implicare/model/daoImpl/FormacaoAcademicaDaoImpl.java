package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.FormacaoAcademicaDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.FormacaoAcademica;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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
        if (formacaoAcademica == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.persist(formacaoAcademica);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(FormacaoAcademica formacaoAcademica) throws PersistenceException {
        if (formacaoAcademica == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.refresh(formacaoAcademica);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(FormacaoAcademica formacaoAcademica) throws PersistenceException {
        if (formacaoAcademica == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.remove(formacaoAcademica);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public FormacaoAcademica pesquisar(int seqFormacao) throws PersistenceException {
        try {
            return Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .find(FormacaoAcademica.class, seqFormacao);
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<FormacaoAcademica> listar(long cpf) throws PersistenceException {
        try {
            return (ArrayList<FormacaoAcademica>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM formacao_acdemica WHERE cpf=?")
                    .setParameter(1, cpf)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

}
