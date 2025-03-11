package com.parcialfinal.academia.models.service;


import com.parcialfinal.academia.models.dao.ProgramaAcademicoRepository;
import com.parcialfinal.academia.models.entity.ProgramaAcademico;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProgramaAcademicoServiceImpl implements ProgramaAcademicoService{

    private final ProgramaAcademicoRepository programaAcademicoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProgramaAcademico> obtenerProgramasAcademicos() {
        return programaAcademicoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProgramaAcademico> obtenerProgramaAcademicoPorId(Long id) {
        return programaAcademicoRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(ProgramaAcademico programaAcademico) {
        programaAcademicoRepository.save(programaAcademico);
    }

    @Override
    @Transactional
    public void eliminarProgramaAcademicoPorId(Long id) {
        programaAcademicoRepository.deleteById(id);
    }
}
