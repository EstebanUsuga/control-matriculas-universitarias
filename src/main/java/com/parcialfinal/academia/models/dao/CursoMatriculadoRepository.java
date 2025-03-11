package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.CursoMatriculado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CursoMatriculadoRepository extends JpaRepository<CursoMatriculado, Long> {
    List<CursoMatriculado> findByEstudianteId(Long estudianteId);
    List<CursoMatriculado> findByPeriodo(String periodo);

    @Query("SELECT cm.curso.id FROM #{#entityName} cm " +
            "WHERE cm.estudiante.id = :estudianteId")
    List<Long> findAllByEstudianteId(Long estudianteId);

}
