package org.example;

import org.example.model.Curso;
import org.example.model.Estudiante;
import java.time.LocalDate;
import org.example.model.Estado;
import org.example.services.GestorAcademico;
import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        // Creación isntancias estudiantes

        Estudiante estudiante1 = new Estudiante("Juan", "Pérez", LocalDate.of(1998, 8, 5), Estado.MATRICULADO);
        Estudiante estudiante2 = new Estudiante("Ana", "García", LocalDate.of(1989, 9, 6), Estado.GRADUADO);

        // creacion cursos

        Curso curso1 = new Curso(101, "Introducción a la Programación", "Curso básico de programación", 3, 1);
        Curso curso2 = new Curso(102, "Matemáticas Avanzadas", "Curso avanzado de matemáticas aplicadas", 4, 2);

        GestorAcademico gestorAcademico=new GestorAcademico();

        // inscribir estudiante
        gestorAcademico.matricularEstudiante(estudiante1);
        gestorAcademico.matricularEstudiante(estudiante2);

        // inscribir curso

        gestorAcademico.agregarCurso(curso1);
        gestorAcademico.agregarCurso(curso2);

        // inscribir estudiante curso
        try {
            gestorAcademico.inscribirEstudianteCurso(estudiante1,curso1.getId());
            gestorAcademico.inscribirEstudianteCurso(estudiante2,curso2.getId());
            gestorAcademico.inscribirEstudianteCurso(estudiante2,curso1.getId());
            gestorAcademico.getEstudiantesInscritos().forEach((curso, estudiantes) -> {
                System.out.println("");
                System.out.println( curso + "\nEstudiantes inscritos:");
                estudiantes.forEach(estudiante -> System.out.println( estudiante));

            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}