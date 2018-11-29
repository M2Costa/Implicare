package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.CargoDao;
import br.cefetmg.implicare.model.domain.Cargo;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CargoDaoImpl implements CargoDao {

    @Override
    public ArrayList<Cargo> listar() throws PersistenceException {
        
        ArrayList<Cargo> lista;
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String sql = "SELECT * FROM Cargo ORDER BY Nom_Cargo;";
            try (PreparedStatement ps = connection.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery()) {
                
                lista = new ArrayList<>();
                while (rs.next()) {
                    lista.add(
                        new Cargo(
                            rs.getInt("Cod_Cargo"),
                            rs.getString("Nom_Cargo")
                        )
                    );
                }
                return lista;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CargoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);            
            throw new PersistenceException("Não foi possível listar os cargos!");
        }
    }

    @Override
    public ArrayList<Cargo> listarCargoAreaEstudo(long CPF) throws PersistenceException {
        ArrayList<Cargo> lista = new ArrayList<>();
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {

            String sql = "SELECT * FROM Cargo A"
                    + "JOIN Cargo_AreaEstudo B ON "
                    + "A.Cod_Cargo = B.Cod_Cargo"
                    + "JOIN Formacao_Academica C"
                    + "B.Cod_Area_Estudo = C.Cod_Area_Estudo"
                    + "WHERE C.CPF = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setLong(1, CPF);
                try (ResultSet rs = ps.executeQuery()) {

                    while (rs.next()) {
                        lista.add(
                            new Cargo(
                                rs.getInt("A.Cod_Cargo"),
                                rs.getString("A.Nom_Cargo")
                            )
                        );
                    }
                    return lista;
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CargoDaoImpl.class.getName()).log(Level.SEVERE, null, ex);            
            throw new PersistenceException("Não foi possível listar os cargos!");            
        }
    }

    @Override
    public Cargo pesquisar(int codCargo) throws PersistenceException {
        
        try (Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            
            String sql = "SELECT * FROM Cargo WHERE Cod_Cargo = ?";
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                
                ps.setInt(1, codCargo);
                try (ResultSet rs = ps.executeQuery()) {

                    if(rs.first())
                        return new Cargo(
                            rs.getInt("Cod_Cargo"),
                            rs.getString("Nom_Cargo")
                        );
                    else
                        throw new PersistenceException("Não foi possível encotrar o cargo com: codCargo = " + codCargo);
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            
            throw new PersistenceException("Não foi possível encotrar o cargo com: codCargo = " + codCargo);
        }
    }
}
