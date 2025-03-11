package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.AsignaturaPlan;

import java.util.List;
import java.util.Optional;

public interface AsignaturaPlanService {

    List<AsignaturaPlan> obtenerAsignaturasPlan();
    Optional<AsignaturaPlan> obtenerAsignaturaPlanPorId(Long id);
    void guardar(AsignaturaPlan asignaturaPlan);
    void eliminarAsignaturaPlanPorId(Long id);
}
