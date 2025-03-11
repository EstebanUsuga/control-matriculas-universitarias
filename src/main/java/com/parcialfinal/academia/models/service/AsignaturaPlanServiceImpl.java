package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.dao.AsignaturaPlanRepository;
import com.parcialfinal.academia.models.entity.AsignaturaPlan;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AsignaturaPlanServiceImpl implements AsignaturaPlanService{

    private final AsignaturaPlanRepository asignaturaPlanRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaPlan> obtenerAsignaturasPlan() {
        return asignaturaPlanRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsignaturaPlan> obtenerAsignaturaPlanPorId(Long id) {
        return asignaturaPlanRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(AsignaturaPlan asignaturaPlan) {
        asignaturaPlanRepository.save(asignaturaPlan);
    }

    @Override
    @Transactional
    public void eliminarAsignaturaPlanPorId(Long id) {
        asignaturaPlanRepository.deleteById(id);
    }
}
