package br.cefetmg.inf.util.db;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBCConnectionManager {

    private static JDBCConnectionManager conexao;

    private JDBCConnectionManager() {}

    public static JDBCConnectionManager getInstance() {
        if (conexao == null) {
            conexao = new JDBCConnectionManager();
        }
        return conexao;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return JDBCPostgresqlFactory.getInstance().getConnection();
    }
}
