package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByNombre(String nombre);
    List<Profesor> findByDepartamento(String departamento);
}
