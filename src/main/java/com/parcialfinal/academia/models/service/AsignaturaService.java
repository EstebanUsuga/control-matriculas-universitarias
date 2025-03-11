package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.Asignatura;

import java.util.List;
import java.util.Optional;

public interface AsignaturaService {

    List<Asignatura> obtenerAsignaturas();
    Optional<Asignatura> obtenerAsignaturaPorId(Long id);
    void guardar(Asignatura asignatura);
    void eliminarAsignaturaPorId(Long id);

    // Nuevo método
    List<Asignatura> obtenerAsignaturasPorDepartamento(String departamento);
}
