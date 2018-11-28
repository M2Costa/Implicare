package br.cefetmg.implicare.model.serviceImpl;

import br.cefetmg.implicare.dao.AreaEstudoDao;
import br.cefetmg.implicare.model.daoImpl.AreaEstudoDaoImpl;
import br.cefetmg.implicare.model.domain.AreaEstudo;
import br.cefetmg.implicare.exception.PersistenceException;

import br.cefetmg.implicare.model.service.AreaEstudoManagement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaEstudoManagementImpl implements AreaEstudoManagement {

    private final AreaEstudoDao AreaEstudoDao;

    public AreaEstudoManagementImpl() {
        AreaEstudoDao = new AreaEstudoDaoImpl();
    }

    @Override
    public ArrayList<AreaEstudo> listar() throws PersistenceException {
        ArrayList<AreaEstudo> result = null;
        try {
            result = AreaEstudoDao.listar();
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(AreaEstudoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public AreaEstudo pesquisar(int Cod_Area_Estudo) throws PersistenceException {
        AreaEstudo result = null;
        try {
            result = AreaEstudoDao.pesquisar(Cod_Area_Estudo);
            return result;
        } catch (br.cefetmg.implicare.exception.PersistenceException ex) {
            Logger.getLogger(AreaEstudoManagementImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}