package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.AsignaturaCursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AsignaturaCursadaRepository extends JpaRepository<AsignaturaCursada, Long> {
    List<AsignaturaCursada> findByEstudianteId(Long estudianteId);
    List<AsignaturaCursada> findByAsignaturaId(Long asignaturaId);

    @Query("SELECT ac.asignatura.id FROM #{#entityName} ac " +
            "WHERE ac.estudiante.id = :estudianteId")
    List<Long> findAllByEstudianteId(@Param("estudianteId") Long estudianteId);
}
