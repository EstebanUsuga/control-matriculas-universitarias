package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.dao.AsignaturaCursadaRepository;
import com.parcialfinal.academia.models.entity.AsignaturaCursada;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AsignaturaCursadaServiceImpl implements AsignaturaCursadaService{

    private final AsignaturaCursadaRepository asignaturaCursadaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaCursada> obtenerAsignaturasCursadas() {
        return asignaturaCursadaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AsignaturaCursada> obtenerAsignaturaCursadaPorId(Long id) {
        return asignaturaCursadaRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(AsignaturaCursada asignaturaCursada) {
        asignaturaCursadaRepository.save(asignaturaCursada);
    }

    @Override
    @Transactional
    public void eliminarAsignaturaCursadaPorId(Long id) {
        asignaturaCursadaRepository.deleteById(id);
    }
}
