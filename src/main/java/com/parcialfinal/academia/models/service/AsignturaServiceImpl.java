package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.dao.AsignaturaRepository;
import com.parcialfinal.academia.models.entity.Asignatura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AsignturaServiceImpl implements AsignaturaService{

    private final AsignaturaRepository asignaturaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> obtenerAsignaturas() {
        return asignaturaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Asignatura> obtenerAsignaturaPorId(Long id) {
        return asignaturaRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
    }

    @Override
    @Transactional
    public void eliminarAsignaturaPorId(Long id) {
        asignaturaRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Asignatura> obtenerAsignaturasPorDepartamento(String departamento) {
        return asignaturaRepository.findByDepartamento(departamento);
    }
}
