package com.example.inmueblesapi.dao;


import com.example.inmueblesapi.model.Registro;
import com.google.gson.Gson;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.inmueblesapi.model.DBConexion.cerrar;
import static com.example.inmueblesapi.model.DBConexion.getConexion;


public class RegistroDao {
    private Connection conexionDB = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private Registro registro;

    public String select(String consulta) throws ClassNotFoundException{
        String sql = "SELECT p.nombre, p.apellido, p.correo, i.direccion, i.ciudad, i.departamento, i.barrio, c.fecha, c.estado " +
                "FROM persona as p " +
                "INNER JOIN contrato as c on c.idPersona = p.id " +
                "INNER JOIN inmueble as i on i.id = c.idInmueble " +
                "WHERE p.nombre LIKE ? OR p.apellido LIKE ? OR p.correo LIKE ?";

        List<Registro> registros = new ArrayList<>();   //Arreglo de registros de la base de datos
        Gson g = new Gson();    //gson para convertir la la lista registros a json

        try {
            this.conexionDB = getConexion();
            this.ps = this.conexionDB.prepareStatement(sql);
            ps.setString(1, "%" + consulta + "%");
            ps.setString(2, "%" + consulta + "%");
            ps.setString(3, "%" + consulta + "%");
            this.rs = this.ps.executeQuery();

            //Recorre todos los registros de la BD
            while (this.rs.next()){
                String nombre = this.rs.getString("nombre");
                String apellido = this.rs.getString("apellido");
                String correo = this.rs.getString("correo");
                String direccion = this.rs.getString("direccion");
                String ciudad = this.rs.getString("ciudad");
                String departamento= this.rs.getString("departamento");
                String barrio= this.rs.getString("barrio");
                String fecha= this.rs.getString("fecha");
                String estado= this.rs.getString("estado");

                this.registro = new Registro(nombre, apellido, correo, direccion, ciudad, departamento, barrio, fecha, estado);
                registros.add(registro);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                cerrar(this.rs);
                cerrar(this.ps);
                cerrar(this.conexionDB);
            } catch (SQLException ex){
                ex.printStackTrace(System.out);
            }
        }


        return g.toJson(registros);
    }
}
