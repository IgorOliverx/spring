package webapp.newsletterjdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String usuario = "postgres"; //Nome do root banco
    private static final String senha = "postgres";// Nome do user banco


    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter conexão com o banco de dados", e);
        }
    }

    public static void closeConnection(Connection connection){
        try {
            if(connection != null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para fechar a conexão e o objeto PreparedStatement
    public static void closeConnection(Connection connection, PreparedStatement stmt) {
        closeConnection(connection);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

     // Método para fechar a conexão, o objeto PreparedStatement e o ResultSet
    public static void closeConnection(Connection connection, PreparedStatement stmt, ResultSet rs) {
        closeConnection(connection, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
