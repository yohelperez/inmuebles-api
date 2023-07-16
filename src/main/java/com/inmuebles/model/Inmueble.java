package com.inmuebles.model;

public class Inmueble {
    private int id;
    private String direccion;

    public Inmueble() {
    }

    public Inmueble(int id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id=" + id +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
