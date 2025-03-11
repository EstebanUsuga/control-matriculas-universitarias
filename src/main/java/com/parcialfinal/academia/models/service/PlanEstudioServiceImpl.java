package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.dao.PlanEstudioRepository;
import com.parcialfinal.academia.models.entity.PlanEstudio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PlanEstudioServiceImpl implements PlanEstudioService{

    private final PlanEstudioRepository planEstudioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PlanEstudio> obtenerPlanesEstudio() {
        return planEstudioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PlanEstudio> obtenerPlanEstudioPorId(Long id) {
        return planEstudioRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(PlanEstudio planEstudio) {
        planEstudioRepository.save(planEstudio);
    }

    @Override
    @Transactional
    public void eliminarPlanEstudioPorId(Long id) {
        planEstudioRepository.deleteById(id);
    }
}
