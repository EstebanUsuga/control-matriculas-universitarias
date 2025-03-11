package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.PlanEstudio;

import java.util.List;
import java.util.Optional;

public interface PlanEstudioService {

    List<PlanEstudio> obtenerPlanesEstudio();
    Optional<PlanEstudio> obtenerPlanEstudioPorId(Long id);
    void guardar(PlanEstudio planEstudio);
    void eliminarPlanEstudioPorId(Long id);


}
