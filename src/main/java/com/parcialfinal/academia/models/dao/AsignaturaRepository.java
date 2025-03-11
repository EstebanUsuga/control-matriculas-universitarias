package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
    List<Asignatura> findByDepartamento(String departamento);
}