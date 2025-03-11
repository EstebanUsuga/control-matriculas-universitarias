package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.dao.EstudianteRepository;
import com.parcialfinal.academia.models.entity.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EstudianteServiceImpl implements EstudianteService{

    private final EstudianteRepository estudianteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Estudiante> obtenerEstudiantePorId(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    @Transactional
    public void eliminarEstudiantePorId(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public List<Estudiante> obtenerEstudiantePorEstado(boolean estado) {
        return estudianteRepository.findByEstado(estado);
    }

    @Override
    public void borradoLogico(Long id) {
        Optional<Estudiante> estudiantes = estudianteRepository.findById(id);
        if (estudiantes.isPresent()) {
            Estudiante entidad = estudiantes.get();
            entidad.setEstado(false);
            estudianteRepository.save(entidad);
        }
    }
}
