package com.parcialfinal.academia.models.service;

import com.parcialfinal.academia.models.dao.CursoMatriculadoRepository;
import com.parcialfinal.academia.models.entity.Curso;
import com.parcialfinal.academia.models.entity.CursoMatriculado;
import com.parcialfinal.academia.models.entity.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CursoMatriculadoServiceImpl implements CursoMatriculadoService{

    private final CursoMatriculadoRepository cursoMatriculadoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CursoMatriculado> obtenerCursosMatriculados() {
        return cursoMatriculadoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CursoMatriculado> obtenerCursoMatriculadoPorId(Long id) {
        return cursoMatriculadoRepository.findById(id);
    }

    @Override
    @Transactional
    public void guardar(CursoMatriculado cursoMatriculado) {
        cursoMatriculadoRepository.save(cursoMatriculado);
    }

    @Override
    @Transactional
    public void eliminarCursoMatriculadoPorId(Long id) {
        cursoMatriculadoRepository.deleteById(id);
    }

    public List<CursoMatriculado> matricularCursos(List<Curso> cursos, Long estudianteId) {
        List<CursoMatriculado> cursosAMatricular = new ArrayList<>();
        for(Curso curso : cursos) {
            cursosAMatricular.add(
                    CursoMatriculado.builder()
                            .estado("Cursando")
                            .periodo("2024-2")
                            .notaFinal(0)
                            .curso(Curso.builder().id(curso.getId()).build())
                            .estudiante(Estudiante.builder().id(estudianteId).build())
                            .build()
            );
        }
        return cursoMatriculadoRepository.saveAll(cursosAMatricular);
    }
}
