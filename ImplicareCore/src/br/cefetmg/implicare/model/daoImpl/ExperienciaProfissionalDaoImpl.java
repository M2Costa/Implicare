package br.cefetmg.implicare.model.daoImpl;

import br.cefetmg.implicare.dao.ExperienciaProfissionalDao;
import br.cefetmg.implicare.model.domain.ExperienciaProfissional;
import br.cefetmg.implicare.exception.PersistenceException;
import br.cefetmg.inf.util.db.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExperienciaProfissionalDaoImpl implements ExperienciaProfissionalDao {
    private static ExperienciaProfissionalDao ExperienciaProfissionalDao;
    
    private ExperienciaProfissionalDaoImpl(){}

    public static ExperienciaProfissionalDao getInstance() {
        if (ExperienciaProfissionalDao == null) {
            ExperienciaProfissionalDao = new ExperienciaProfissionalDaoImpl();
        }
        return ExperienciaProfissionalDao;
    }

    @Override
    public void insert(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        try(Connection connection = JDBCConnectionManager.getInstance().getConnection()) {

            String sql = "INSERT INTO Experiencia_Profissional (CPF, Seq_Experiencia, Nom_Empresa, Cod_Cargo, "
                    + "Data_Inicio, Data_Termino, Desc_Experiencia_Profissional) "
                    + "VALUES(?,?,?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setLong(1, ExperienciaProfissional.getCPF());
            ps.setInt(2, ExperienciaProfissional.getSeq_Experiencia());
            ps.setString(3, ExperienciaProfissional.getNom_Empresa());
            ps.setInt(4, ExperienciaProfissional.getCod_Cargo());
            ps.setDate(5, ExperienciaProfissional.getData_Inicio());
            ps.setDate(6, ExperienciaProfissional.getData_Termino());
            ps.setString(7, ExperienciaProfissional.getDesc_Experiencia_Profissional());

            ResultSet rs = ps.executeQuery();

            rs.close();
            ps.close();
            connection.close();

            return true;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public void update(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        try(Connection connection = JDBCConnectionManager.getInstance().getConnection()) {

            String SQL = "UPDATE Experiencia_Profissional SET Nom_Empresa = ?, Cod_Cargo = ?, "
                    + "Data_Inicio = ?, Data_Termino = ?, Desc_Experiencia_Profissional = ?"
                    + "WHERE Seq_Experiencia = ?";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setString(1, ExperienciaProfissional.getNom_Empresa());
            ps.setInt(2, ExperienciaProfissional.getCod_Cargo());
            ps.setDate(3, ExperienciaProfissional.getData_Inicio());
            ps.setDate(4, ExperienciaProfissional.getData_Termino());
            ps.setString(5, ExperienciaProfissional.getDesc_Experiencia_Profissional());
            ps.setLong(6, ExperienciaProfissional.getSeq_Experiencia());

            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public void delete(ExperienciaProfissional ExperienciaProfissional) throws PersistenceException {
        try(Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            String SQL = "DELETE FROM Experiencia_Profissional"
                    + "WHERE Seq_Experiencia = ?";

            PreparedStatement ps = connection.prepareStatement(SQL);

            ps.setLong(1, ExperienciaProfissional.getSeq_Experiencia());

            ps.executeQuery(SQL);
            ps.close();
            connection.close();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public ExperienciaProfissional pesquisar(int Seq_Experiencia) throws PersistenceException {
        try(Connection connection = JDBCConnectionManager.getInstance().getConnection()) {
            String sql = "SELECT * FROM Experiencia_Profissional WHERE Seq_Experiencia = ?;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Seq_Experiencia);
            ResultSet rs = ps.executeQuery();

            ExperienciaProfissional Exp = new ExperienciaProfissional();

            Exp.setCPF(rs.getLong("CPF"));
            Exp.setSeq_Experiencia(rs.getInt("Seq_Experiencia"));
            Exp.setNom_Empresa(rs.getString("Nom_Empresa"));
            Exp.setCod_Cargo(rs.getInt("Cod_Cargo"));
            Exp.setData_Inicio(rs.getDate("Data_Inicio"));
            Exp.setData_Termino(rs.getDate("Data_Termino"));
            Exp.setDesc_Experiencia_Profissional(rs.getString("Desc_Experiencia_Profissional"));

            rs.close();
            ps.close();
            connection.close();

            return Exp;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ArrayList<ExperienciaProfissional> listar(long CPF) throws PersistenceException {
        try(Connection connection = JDBCConnectionManager.getInstance().getConnection()) {

            String sql = "SELECT * FROM Experiencia_Profissional WHERE CPF = ? ORDER BY Seq_Experiencia;";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, CPF);
            ResultSet rs = ps.executeQuery();

            ArrayList<ExperienciaProfissional> lista = new ArrayList<>();

            if (rs.next()) {
                do {
                    ExperienciaProfissional Exp = new ExperienciaProfissional();

                    Exp.setCPF(rs.getLong("CPF"));
                    Exp.setSeq_Experiencia(rs.getInt("Seq_Experiencia"));
                    Exp.setNom_Empresa(rs.getString("Nom_Empresa"));
                    Exp.setCod_Cargo(rs.getInt("Cod_Cargo"));
                    Exp.setData_Inicio(rs.getDate("Data_Inicio"));
                    Exp.setData_Termino(rs.getDate("Data_Termino"));
                    Exp.setDesc_Experiencia_Profissional(rs.getString("Desc_Experiencia_Profissional"));

                    lista.add(Exp);
                } while (rs.next());
            }

            rs.close();
            ps.close();
            connection.close();

            return lista;

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

}
