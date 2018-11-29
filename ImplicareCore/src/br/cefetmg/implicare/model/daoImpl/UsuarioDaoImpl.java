package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.UsuarioDao;
import br.cefetmg.implicare.model.domain.Usuario;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public Usuario login(long cpfCnpj, String senha) throws PersistenceException {
        
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String sql = "SELECT * FROM Usuario WHERE CPF_CNPJ = ? AND Senha = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                
                ps.setLong(1, cpfCnpj);
                ps.setString(2, senha);
                try (ResultSet rs = ps.executeQuery()) {
                    
                    if(rs.first())
                        return new Usuario(
                            rs.getLong("CPF_CNPJ"),
                            rs.getString("Email"),
                            rs.getString("Senha"),
                            rs.getString("Foto"),
                            rs.getLong("Cod_CEP"),
                            rs.getString("Endereco"),
                            rs.getString("Desc_Usuario")
                        );
                    else
                        throw new PersistenceException("Não foi possível de encontrar o usuário com o cadastro: " + cpfCnpj);
                }
            }
        }catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelefoneDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível de encontrar o usuário com o cadastro: " + cpfCnpj);
        }
    }
}