package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    private static Connection conexao = null;
    private static final String URL = "jdbc:sqlite:petshop.db"; // O arquivo do banco

    public static Connection getConnection() throws SQLException {
        if (conexao == null || conexao.isClosed()) {
            conexao = DriverManager.getConnection(URL);
        }
        return conexao;
    }
}
