package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.PlanEstudio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlanEstudioRepository extends JpaRepository<PlanEstudio, Long> {
    List<PlanEstudio> findByDescripcion(String descripcion);

}
