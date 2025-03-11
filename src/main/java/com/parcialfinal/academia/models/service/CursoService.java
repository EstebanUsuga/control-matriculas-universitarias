package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.Curso;
import com.parcialfinal.academia.models.entity.Estudiante;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> obtenerCursos();
    Optional<Curso> obtenerCursoPorId(Long id);
    void guardar(Curso curso);
    void eliminarCursoPorId(Long id);

    List<Curso> obtenerCursosPorEstudiante(Estudiante estudiante);
}
