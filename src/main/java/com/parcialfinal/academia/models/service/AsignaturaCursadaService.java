package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.AsignaturaCursada;

import java.util.List;
import java.util.Optional;

public interface AsignaturaCursadaService {
    List<AsignaturaCursada> obtenerAsignaturasCursadas();
    Optional<AsignaturaCursada> obtenerAsignaturaCursadaPorId(Long id);
    void guardar(AsignaturaCursada asignaturaCursada);
    void eliminarAsignaturaCursadaPorId(Long id);
}
