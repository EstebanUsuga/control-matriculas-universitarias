package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.AsignaturaPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaPlanRepository extends JpaRepository<AsignaturaPlan, Long> {
    List<AsignaturaPlan> findByPlanId(Long planId);
    List<AsignaturaPlan> findBySemestreNivel(Integer semestreNivel);
}
