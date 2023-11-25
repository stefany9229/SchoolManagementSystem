package org.example.model;

import java.util.Arrays;

public enum Estado {

    MATRICULADO("Matriculado"),
    INACTIVO("Inactivo"),
    GRADUADO("Graduado");

    private final String descripcion;

    Estado(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public static Estado getEstadoPorDescripcion(String descripcion) {
        return Arrays.stream(Estado.values())
                .filter(e -> e.getDescripcion().equalsIgnoreCase(descripcion))
                .findFirst()
                .orElse(null);
    }
}
