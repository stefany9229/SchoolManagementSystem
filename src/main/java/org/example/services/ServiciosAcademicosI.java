package org.example.services;

import org.example.model.Curso;
import org.example.model.Estudiante;

public interface ServiciosAcademicosI {

    void matricularEstudiante(Estudiante estudiante);
    void agregarCurso(Curso curso);

    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Exception;

    void  desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws Exception;
}
