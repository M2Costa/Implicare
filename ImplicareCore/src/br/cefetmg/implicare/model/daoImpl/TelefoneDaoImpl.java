package br.cefetmg.implicare.model.daoImpl;

import static br.cefetmg.implicare.dao.GenericDao.UP;
import br.cefetmg.implicare.dao.TelefoneDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Telefone;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class TelefoneDaoImpl implements TelefoneDao {
    
    private static TelefoneDao telefoneDao;

    private TelefoneDaoImpl() {}
    
    public static TelefoneDao getInstance() {
        if (telefoneDao == null) {
            telefoneDao = new TelefoneDaoImpl();
        }
        return telefoneDao;
    }

    @Override
    public void insert(Telefone telefone) throws PersistenceException {
        if (telefone == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.persist(telefone);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void update(Telefone telefone) throws PersistenceException {
        if (telefone == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.refresh(telefone);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public void delete(Telefone telefone) throws PersistenceException {
        if (telefone == null)
            throw new PersistenceException("Domínio não pode ser nulo.");
        
        try {
            EntityManager manager = Persistence.createEntityManagerFactory(UP).createEntityManager();

            manager.getTransaction().begin();
            manager.remove(telefone);
            manager.getTransaction().commit();
            
            manager.close();
        } catch (PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public Telefone pesquisar(int seqTelefone) throws PersistenceException {
        try {
            return Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .find(Telefone.class, seqTelefone);
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Telefone> listar(long cpfCnpj) throws PersistenceException {
        try {
            return (ArrayList<Telefone>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM telefone WHERE cpf_cnpj=?")
                    .setParameter(1, cpfCnpj)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

}