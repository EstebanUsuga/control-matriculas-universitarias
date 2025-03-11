package com.parcialfinal.academia.models.service;


import com.parcialfinal.academia.models.dao.AsignaturaCursadaRepository;
import com.parcialfinal.academia.models.dao.CursoMatriculadoRepository;
import com.parcialfinal.academia.models.dao.CursoRepository;
import com.parcialfinal.academia.models.dao.EstudianteRepository;
import com.parcialfinal.academia.models.entity.Curso;
import com.parcialfinal.academia.models.entity.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CursoServiceImpl implements CursoService{

    private final CursoRepository cursoRepository;
    private final CursoMatriculadoRepository cursoMatriculadoRepository;
    private final AsignaturaCursadaRepository asignaturaCursadaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> obtenerCursos() {
        return cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void eliminarCursoPorId(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public List<Curso> obtenerCursosPorEstudiante(Estudiante estudiante) {
        List<Long> asignaturaCursadaIds = asignaturaCursadaRepository.findAllByEstudianteId(estudiante.getId());
        List<Long> cursosMatriculadoIds = cursoMatriculadoRepository.findAllByEstudianteId(estudiante.getId());
        return cursoRepository.obtenerCursosPorEstudiante(
                        estudiante.getPrograma().getId(),
                        asignaturaCursadaIds,
                        estudiante.getSemestre_actual()).stream()
                .peek(curso -> curso.setEstaMatriculado(cursosMatriculadoIds.contains(curso.getId())))
                .toList();
    }


}
