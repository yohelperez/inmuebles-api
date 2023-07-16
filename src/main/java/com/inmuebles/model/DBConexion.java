package com.inmuebles.model;
import java.sql.*;
public class DBConexion {
    private static final String URL = "jdbc:mysql://localhost/inmuebles_db?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "system";

    /**
     * Retorna una conexión a la base de datos.
     */
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }


    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }


    public static void close(Connection connection) throws SQLException {
        connection.close();
    }
}
