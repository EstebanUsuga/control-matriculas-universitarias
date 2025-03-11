package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByAsignaturaId(Long asignaturaId);

//    @Query("SELECT a.cursos FROM #{#entityName} e JOIN e.programa p JOIN p.planesEstudio pe JOIN pe.planesAsignatura pa JOIN pa.asignatura a WHERE e.id = :estudianteId")
//    @Query("SELECT c from #{#entityName} c JOIN FETCH c.asignatura a JOIN FETCH a.asignaturaPlanes ap JOIN FETCH ap.plan p JOIN FETCH p.programa pro WHERE pro.id = :programaId")
//    List<Curso> obtenerCursosPorEstudiante(@Param("programaId") Long programaId);

    //JOIN FETCH toma en cuenta los atributos de la asignatura también. Trae info de ambas tablas.
    //Los JOIN normales, sólo hacen los enlaces para encajar los WHERE
    @Query("SELECT c from #{#entityName} c " +
            "JOIN FETCH c.asignatura a " +
            "JOIN a.asignaturaPlanes ap " +
            "JOIN ap.plan p " +
            "JOIN p.programa pro " +
            "WHERE  pro.id = :programaId " + //El programa debe corresponder al id que le pasamos
            "       AND (ap.preAsignatura.id IS NULL OR ap.preAsignatura.id IN :asignaturasCursadasIds) " + //Qué asignaturas tienen prerrequisitos
            "       AND c.asignatura.id NOT IN :asignaturasCursadasIds " + //Descarta materias ya cursadas
            "       AND ap.semestreNivel <= :semestre") //Muestra materias según el semestre
    List<Curso> obtenerCursosPorEstudiante(@Param("programaId") Long programaId,
                                           @Param("asignaturasCursadasIds") List<Long> asignaturasCursadasIds,
                                           @Param("semestre") int semestre);
    }
