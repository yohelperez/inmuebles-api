package com.inmuebles.model;

import java.time.LocalDate;

public class Contrato {
    private int idPersona;
    private int idInmueble;
    private int numeroContrato;
    private LocalDate fecha;

    public Contrato() {
    }

    public Contrato(int idPersona, int idInmueble, int numeroContrato, LocalDate fecha) {
        this.idPersona = idPersona;
        this.idInmueble = idInmueble;
        this.numeroContrato = numeroContrato;
        this.fecha = fecha;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(int idInmueble) {
        this.idInmueble = idInmueble;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "idPersona=" + idPersona +
                ", idInmueble=" + idInmueble +
                ", numeroContrato=" + numeroContrato +
                ", fecha=" + fecha +
                '}';
    }
}
