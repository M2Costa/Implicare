package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.EmpresaDao;
import static br.cefetmg.implicare.dao.GenericDao.UP;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Empresa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmpresaDaoImpl implements EmpresaDao {
    
    private static EmpresaDaoImpl empresaDao = null;
    
    private EmpresaDaoImpl(){}
    
    public static EmpresaDaoImpl getInstance() {
        if (empresaDao == null) {
            empresaDao = new EmpresaDaoImpl();
        }
        return empresaDao;
    }

    @Override
    public void insert(Empresa empresa) throws PersistenceException {
        if (empresa == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.persist(empresa);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(Empresa empresa) throws PersistenceException {
        if (empresa == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.refresh(empresa);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(Empresa empresa) throws PersistenceException {
        if (empresa == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.remove(empresa);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public Empresa pesquisar(long cnpj) throws PersistenceException {
        try {
            return Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .find(Empresa.class, cnpj);
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }
}
