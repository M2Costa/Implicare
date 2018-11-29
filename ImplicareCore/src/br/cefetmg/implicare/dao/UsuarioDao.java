package br.cefetmg.implicare.dao;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.exception.PersistenceException;

public interface UsuarioDao {
    public Usuario login(long cpfCnpj, String senha) throws PersistenceException;
}
