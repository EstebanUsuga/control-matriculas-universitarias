package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.entity.ProgramaAcademico;

import java.util.List;
import java.util.Optional;

public interface ProgramaAcademicoService {

    List<ProgramaAcademico> obtenerProgramasAcademicos();
    Optional<ProgramaAcademico> obtenerProgramaAcademicoPorId(Long id);
    void guardar(ProgramaAcademico programaAcademico);
    void eliminarProgramaAcademicoPorId(Long id);
}
