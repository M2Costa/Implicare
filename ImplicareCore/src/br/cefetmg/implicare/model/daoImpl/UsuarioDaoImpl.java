package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.implicare.model.domain.jpa.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class UsuarioDaoImpl implements UsuarioDao {
    
    private static UsuarioDao UsuarioDao;

    private UsuarioDaoImpl() {}
    
    public static UsuarioDao getInstance() {
        if (UsuarioDao == null) {
            UsuarioDao = new UsuarioDaoImpl();
        }
        return UsuarioDao;
    }

    @Override
    public Usuario login(long cpfCnpj, String senha) throws PersistenceException, BusinessException {
        if(senha == null)
                throw new BusinessException("A senha dada não pode ser nula!");
        try {
            Usuario temp = Persistence
                            .createEntityManagerFactory(UP)
                            .createEntityManager()
                            .find(Usuario.class, cpfCnpj);
            if(temp.getSenha() == null)
                throw new PersistenceException("A senha recebida pelo banco de dados é inválida, contate o apoio técnico imediatamente!");
            if(temp.getSenha().equals(senha))
                return temp;
            else
                throw new BusinessException("As senhas são incompatíveis!");
        } catch(PersistenceException e) {
            Logger.getLogger(UsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, e);
            throw new PersistenceException(e);
        }
    }
}