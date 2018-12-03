package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.exception.PersistenceException;
import java.util.ArrayList;
import br.cefetmg.implicare.dao.FormacaoAcademicaIdDao;
import br.cefetmg.implicare.model.domain.jpa.relacionamentos.FormacaoAcademicaId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FormacaoAcademicaIdDaoImpl implements FormacaoAcademicaIdDao {
    
    private static FormacaoAcademicaIdDaoImpl cargoInteresseDao = null;
    
    private FormacaoAcademicaIdDaoImpl(){}
    
    public static FormacaoAcademicaIdDaoImpl getInstance() {
        if (cargoInteresseDao == null) {
            cargoInteresseDao = new FormacaoAcademicaIdDaoImpl();
        }
        return cargoInteresseDao;
    }

    @Override
    public void insert(FormacaoAcademicaId formacaoAcademicaId) throws PersistenceException {
        if (formacaoAcademicaId == null)
            throw new PersistenceException("Domínio não pode ser nulo.");


        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.persist(formacaoAcademicaId);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(FormacaoAcademicaId formacaoAcademicaId) throws PersistenceException {
        if (formacaoAcademicaId == null)
            throw new PersistenceException("Domínio não pode ser nulo.");


        try {
            EntityManager manager =
                        Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager();

            manager.getTransaction().begin();
            manager.remove(formacaoAcademicaId);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<FormacaoAcademicaId> listar(long cpf) throws PersistenceException {
        try {
            return (ArrayList<FormacaoAcademicaId>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM formacao_academica WHERE cpf=?")
                    .setParameter(1, cpf)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

}
