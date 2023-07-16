package com.inmuebles;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection conectar = DriverManager.getConnection(
                "jdbc:mysql://localhost/inmuebles_db?serverTimezone=UTC",
                "root",
                "system");

        System.out.println("conexion exitosa");

        String sql = "SELECT * FROM persona";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String correo = rs.getString("correo");

            System.out.printf("%d %s %s %s\n", id, nombre, apellido, correo);
        }
        rs.close();
        ps.close();
    }
}
