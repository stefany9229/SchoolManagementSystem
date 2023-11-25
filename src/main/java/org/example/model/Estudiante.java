package org.example.model;

import java.time.LocalDate;
import java.util.Date;

public class Estudiante extends Persona {

    private Estado estado;

    public Estudiante() {
    }

    public Estudiante( String nombre, String apellido, LocalDate fechaDeNacimiento,Estado estado) {
        super( nombre, apellido, fechaDeNacimiento);
        this.estado= estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +super.toString()  +
                " estado=" + estado +"}";
    }
}
