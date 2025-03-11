package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.dao.ProfesorRepository;
import com.parcialfinal.academia.models.entity.Profesor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ProfesorServiceImpl implements ProfesorService{

    private final ProfesorRepository profesorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> obtenerProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Profesor> obtenerProfesorPorId(Long id) {
        return profesorRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    @Override
    @Transactional
    public void eliminarProfesorPorId(Long id) {
        profesorRepository.deleteById(id);
    }
}
