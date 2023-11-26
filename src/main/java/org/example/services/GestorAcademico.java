package org.example.services;

import org.example.excepciones.EstudianteNoInscritoEnCursoException;
import org.example.excepciones.EstudianteYaInscritoException;
import org.example.model.Curso;
import org.example.model.Estudiante;



import java.util.*;

public class GestorAcademico implements ServiciosAcademicosI {

    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    private HashMap<Curso, Set<Estudiante>> estudiantesInscritos;
    private int contadorIdEstudiante;
    private int contadorIdCurso;

    public GestorAcademico() {
        this.estudiantes= new ArrayList<>();
        this.cursos= new ArrayList<>() ;
        this.estudiantesInscritos= new HashMap<>();
        contadorIdCurso=1;
        contadorIdEstudiante=1;
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        estudiante.setId(contadorIdEstudiante);
        contadorIdEstudiante++;
        this.estudiantes.add(estudiante);


    }

    @Override
    public void agregarCurso(Curso curso) {
        curso.setId(contadorIdCurso);
        contadorIdCurso++;
        this.cursos.add(curso);
        estudiantesInscritos.put(curso,  new HashSet<>());

    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws Exception {

        Curso curso = this.cursos.stream()
                .filter(curso_ -> curso_.getId() == idCurso)
                .findFirst()
                .orElseThrow(() -> new Exception("el curso al que intenta escribir al estudiante no existe"));

        if(!this.estudiantes.contains(estudiante)){
            throw new Exception("el estudiante no se ecuentra en sistema");
        }
        if(estudiantesInscritos.get(curso).contains(estudiante)){
            throw new EstudianteYaInscritoException();
        }


        Set<Estudiante> estudiantes = estudiantesInscritos.get(curso);
        estudiantes.add(estudiante);



    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws Exception {

        Curso curso = this.cursos.stream()
                .filter(curso_ -> curso_.getId() == idCurso)
                .findFirst()
                .orElseThrow(() -> new EstudianteNoInscritoEnCursoException("el curso al que intenta insscribir al estudiante no existe"));
        Estudiante estudiante = this.estudiantes.stream()
                .filter(estudia ->estudia.getId()==idEstudiante)
                .findFirst()
                .orElseThrow(() -> new Exception("el id ingresado no corresponde a ningun estudiante"));


        Set<Estudiante> estudiantes = estudiantesInscritos.get(curso);
        estudiantes.remove(estudiante);

    }

    public HashMap<Curso, Set<Estudiante>> getEstudiantesInscritos() {
        return new HashMap<>(estudiantesInscritos);
    }
}
