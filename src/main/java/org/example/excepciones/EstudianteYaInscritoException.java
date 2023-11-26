package org.example.excepciones;

public class EstudianteYaInscritoException extends Exception {


    public EstudianteYaInscritoException() {
        super("El estudiante ya está inscrito en este curso");
    }
}