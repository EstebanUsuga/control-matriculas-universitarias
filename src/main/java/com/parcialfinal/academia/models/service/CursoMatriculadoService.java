package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.Curso;
import com.parcialfinal.academia.models.entity.CursoMatriculado;

import java.util.List;
import java.util.Optional;

public interface CursoMatriculadoService {


    List<CursoMatriculado> obtenerCursosMatriculados();
    Optional<CursoMatriculado> obtenerCursoMatriculadoPorId(Long id);
    void guardar(CursoMatriculado cursoMatriculado);
    void eliminarCursoMatriculadoPorId(Long id);

    List<CursoMatriculado> matricularCursos(List<Curso> cursos, Long estudianteId);
}
