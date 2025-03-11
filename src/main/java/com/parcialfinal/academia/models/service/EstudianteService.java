package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    List<Estudiante> obtenerEstudiantes();
    Optional<Estudiante> obtenerEstudiantePorId(Long id);
    void guardar(Estudiante estudiante);
    void eliminarEstudiantePorId(Long id);

    List<Estudiante> obtenerEstudiantePorEstado(boolean estado);

    void borradoLogico(Long id);
}
