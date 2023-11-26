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
        Curso curso3 = new Curso(102, "Matemáticas Avanzadas II", "Curso avanzado de matemáticas aplicadas", 4, 2);

        GestorAcademico gestorAcademico=new GestorAcademico();

        // inscribir estudiante
        gestorAcademico.matricularEstudiante(estudiante1);
        gestorAcademico.matricularEstudiante(estudiante2);

        // inscribir curso

        gestorAcademico.agregarCurso(curso1);
        gestorAcademico.agregarCurso(curso2);
        gestorAcademico.agregarCurso(curso3);

        // inscribir estudiante curso

        try {
            // Inscripción de estudiantes en cursos
            gestorAcademico.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestorAcademico.inscribirEstudianteCurso(estudiante2, curso2.getId());
            gestorAcademico.inscribirEstudianteCurso(estudiante2, curso1.getId());

            // Recorrido de todos los cursos y sus estudiantes inscritos
            gestorAcademico.getEstudiantesInscritos().forEach((curso, estudiantes) -> {
                System.out.println("\n" + curso + "\nEstudiantes inscritos:");
                estudiantes.forEach(estudiante -> System.out.println(estudiante));
            });

            // Desinscripción de un estudiante de un curso (los IDs deberían ser reemplazados por valores concretos)
            gestorAcademico.desinscribirEstudianteCurso(1, 1);

            System.out.println("probando una de las excpeciones");
            gestorAcademico.inscribirEstudianteCurso(estudiante2, curso1.getId());


        } catch (Exception e) {
            e.getMessage();
            }
        finally {
            System.out.println("finaliza la ejecucion");

        }

        }





    }
