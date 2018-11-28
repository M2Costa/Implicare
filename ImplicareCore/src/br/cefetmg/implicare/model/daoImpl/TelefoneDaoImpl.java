package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.TelefoneDao;
import br.cefetmg.implicare.model.domain.Telefone;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String sql = "INSERT INTO Telefone "
                    + "(CPF_CNPJ, Num_Telefone, Tipo_Telefone, DDD, Ramal) "
                    + "VALUES (?,?,?,?,?)";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                
                ps.setLong(1, telefone.getCPF_CNPJ());
                ps.setString(2, telefone.getNum_Telefone());
                ps.setString(3, telefone.getTipo_Telefone());
                ps.setInt(4, telefone.getDDD());
                ps.setInt(5, telefone.getRamal());

                ResultSet rs = ps.executeQuery();

                rs.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TelefoneDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível inserir o telefone: " + telefone);
        }
    }

    @Override
    public void update(Telefone telefone) throws PersistenceException {
        
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String SQL = "UPDATE Telefone "
                    + "SET Num_Telefone = ?, Tipo_Telefone = ?, DDD = ?, Ramal = ? "
                    + "WHERE Seq_Telefone = ?";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                
                ps.setString(1, telefone.getNum_Telefone());
                ps.setString(2, telefone.getTipo_Telefone());
                ps.setInt(3, telefone.getDDD());
                ps.setInt(4, telefone.getRamal());
                ps.setInt(5, telefone.getSeq_Telefone());

                ps.executeQuery();
            }
        }catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(TelefoneDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível atualizar o telefone: " + telefone);
        }
    }

    @Override
    public void delete(Telefone telefone) throws PersistenceException {
        
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String SQL = "DELETE FROM Telefone "
                    + "WHERE Seq_Telefone = ?";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                
                ps.setInt(1, telefone.getSeq_Telefone());
                ps.executeQuery();
            }
        }catch (SQLException | ClassNotFoundException ex) {
            
            Logger.getLogger(TelefoneDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível deletar o telefone: " + telefone);
        }
    }

    @Override
    public Telefone pesquisar(int seqTelefone) throws PersistenceException {
        
        Telefone Tel;
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String SQL = "SELECT * FROM Telefone "
                    + "WHERE Seq_Telefone = ?";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                
                ps.setLong(1, seqTelefone);
                try (ResultSet rs = ps.executeQuery(SQL)) {
                    
                    Tel = new Telefone(
                            rs.getLong("CPF_CNPJ"),
                            rs.getInt("Seq_Telefone"),
                            rs.getString("Num-Telefone"),
                            rs.getString("Tipo_Telfone"),
                            rs.getInt("DDD"),
                            rs.getInt("Ramal")
                    );
                }
            }
        }catch (ClassNotFoundException| SQLException ex) {
            
            Logger.getLogger(TelefoneDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível encontrar o telefone com: seqTelefone = " + seqTelefone);
        }
        
        return Tel;
    }

    @Override
    public ArrayList<Telefone> listar(long cpfCnpj) throws PersistenceException {
        
        ArrayList<Telefone> lista;
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String SQL = "SELECT * FROM Telefone "
                    + "WHERE CPF_CNPJ = ?";
            try (PreparedStatement ps = connection.prepareStatement(SQL)) {
                
                ps.setLong(1, cpfCnpj);
                try (ResultSet rs = ps.executeQuery()) {
                    
                    lista = new ArrayList();
                    while (rs.next()) {
                        
                        lista.add(
                            new Telefone(
                                rs.getLong("CPF_CNPJ"),
                                rs.getInt("Seq_Telefone"),
                                rs.getString("Num-Telefone"),
                                rs.getString("Tipo_Telfone"),
                                rs.getInt("DDD"),
                                rs.getInt("Ramal")
                            )
                        );
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TelefoneDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new PersistenceException("Não foi possível encontrar telefones com: CpfCnpj = " + cpfCnpj);
        }
        return lista;
    }
}