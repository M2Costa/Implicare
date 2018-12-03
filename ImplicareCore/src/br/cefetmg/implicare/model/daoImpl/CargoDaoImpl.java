package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Cargo;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class CargoDaoImpl implements CargoDao {
    
    private static CargoDaoImpl cargoDao = null;
    
    private CargoDaoImpl(){}
    
    public static CargoDaoImpl getInstance() {
        if (cargoDao == null) {
            cargoDao = new CargoDaoImpl();
        }
        return cargoDao;
    }

    @Override
    public ArrayList<Cargo> listar() throws PersistenceException {
        try {
            return (ArrayList<Cargo>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * FROM cargo")
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(int codAreaEstudo) throws PersistenceException {
        try {
            return (ArrayList<Cargo>) Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .createNativeQuery("SELECT * "
                            + "FROM cargo AS C "
                            + "JOIN cargo_areaestudo AS CAE "
                            + "ON C.cod_cargo = CAE.cod_cargo "
                            + "JOIN area_estudo AS AE "
                            + "ON CAE.cod_area_estudo = AE.cod_area_estudo "
                            + "AND AE.cod_area_estudo = ?")
                    .setParameter(1, codAreaEstudo)
                    .getResultList();
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

    @Override
    public Cargo pesquisar(int codCargo) throws PersistenceException {
        try {
            return Persistence
                    .createEntityManagerFactory(UP)
                    .createEntityManager()
                    .find(Cargo.class, codCargo);
        } catch(PersistenceException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }

}