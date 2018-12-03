package br.cefetmg.implicare.dao;


import br.cefetmg.implicare.exception.BusinessException;
import br.cefetmg.implicare.model.domain.jpa.Usuario;
import br.cefetmg.implicare.exception.PersistenceException;

public interface UsuarioDao extends GenericDao {
    public Usuario login(long cpfCnpj, String senha) throws PersistenceException, BusinessException;
}
