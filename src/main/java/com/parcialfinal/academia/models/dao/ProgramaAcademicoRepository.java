package com.parcialfinal.academia.models.dao;

import com.parcialfinal.academia.models.entity.ProgramaAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgramaAcademicoRepository extends JpaRepository<ProgramaAcademico, Long> {
    Optional<ProgramaAcademico> findByNombrePrograma(String nombrePrograma);
    List<ProgramaAcademico> findByFacultad(String facultad);
}
