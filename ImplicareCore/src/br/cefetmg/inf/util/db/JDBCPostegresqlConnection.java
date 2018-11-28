package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBCPostegresqlConnection implements JDBCConnectionFactory {

    private final static String dbDriver = "org.postgresql.Driver";

    public JDBCPostegresqlConnection() {
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dbDriver);
        return DriverManager.getConnection(JDBCPassword.URL, JDBCPassword.USER, JDBCPassword.PASS);
    }

    public static void main(String[] args) {
        try {
            JDBCConnectionFactory cf = new JDBCPostegresqlConnection();
            cf.getConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCPostegresqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
