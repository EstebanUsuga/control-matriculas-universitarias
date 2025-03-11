package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.Profesor;

import java.util.List;
import java.util.Optional;

public interface ProfesorService {

    List<Profesor> obtenerProfesores();
    Optional<Profesor> obtenerProfesorPorId(Long id);
    void guardar(Profesor profesor);
    void eliminarProfesorPorId(Long id);
}
