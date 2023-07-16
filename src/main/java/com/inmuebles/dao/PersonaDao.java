package com.inmuebles.dao;

import com.inmuebles.model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static com.inmuebles.model.DBConexion.getConexion;

public class PersonaDao {
    private Connection conexionDB = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private Persona persona;

    public List<Persona> select() throws ClassNotFoundException{
        String sql = "SELECT * FROM Persona";
        List<Persona> personas = new ArrayList<>();
        try {
            this.conexionDB = getConexion();
            this.ps = this.conexionDB.prepareStatement(sql);
            this.rs = this.ps.executeQuery();

            //Recorre todos los registros de la BD
            while (this.rs.next()){
                int id = this.rs.getInt("id");
                String nombre = this.rs.getString("nombre");
                String apellido = this.rs.getString("apellido");
                String correo = this.rs.getString("correo");

                this.persona = new Persona(id,nombre, apellido, correo);
                personas.add(this.persona);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return personas;
    }
}
