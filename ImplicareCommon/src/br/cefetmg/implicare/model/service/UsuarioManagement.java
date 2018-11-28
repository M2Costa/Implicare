package br.cefetmg.implicare.model.service;

import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.exception.PersistenceException;

public interface UsuarioManagement {

    public Usuario login(long CPF_CNPJ, String Senha) throws PersistenceException;
}
