package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgresqlFactory implements JDBCConnectionFactory {

    private final static String DBDRIVER = "org.postgresql.Driver";
    private  static JDBCPostgresqlFactory fabrica; 

    private JDBCPostgresqlFactory() throws ClassNotFoundException{
        Class.forName(DBDRIVER);
    }
    
    public static JDBCConnectionFactory getInstance() throws ClassNotFoundException
    {
        if(fabrica == null)
            fabrica = new JDBCPostgresqlFactory();
        return fabrica;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBCPassword.URL, JDBCPassword.USER, JDBCPassword.PASS);
    }
}