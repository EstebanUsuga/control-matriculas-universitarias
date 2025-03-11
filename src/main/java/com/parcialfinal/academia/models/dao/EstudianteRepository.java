package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.Curso;
import com.parcialfinal.academia.models.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
    Optional<Estudiante> findByIdentificacion(String identificacion);
    List<Estudiante> findByEstado(boolean estado);



}
