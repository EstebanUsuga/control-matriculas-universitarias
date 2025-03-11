package com.parcialfinal.academia.controller;

import com.parcialfinal.academia.models.entity.Curso;
import com.parcialfinal.academia.models.entity.Estudiante;
import com.parcialfinal.academia.models.service.CursoMatriculadoService;
import com.parcialfinal.academia.models.service.CursoService;
import com.parcialfinal.academia.models.service.EstudianteService;
import com.parcialfinal.academia.models.service.ProgramaAcademicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/academia")
@RequiredArgsConstructor
@SessionAttributes("estudiantes")
public class MatriculaController {

    private final EstudianteService estudianteService;
    private final CursoMatriculadoService cursoMatriculadoService;
    private final CursoService cursoService;

    @GetMapping("/matriculanueva/{id}")
    public String nuevoEstudianteForm(@PathVariable Long id, Model model) {
        Optional<Estudiante> estudianteOptional = estudianteService.obtenerEstudiantePorId(id);
        if (estudianteOptional.isEmpty()) {
            throw new IllegalArgumentException("Estudiante no encontrado");
        }

        Estudiante estudiante = estudianteOptional.get();
        List<Curso> cursosDisponibles = cursoService.obtenerCursosPorEstudiante(estudiante);

        // Log para ver si cursos disponibles están siendo correctamente asignados
        System.out.println("Cursos disponibles para el estudiante " + estudiante.getId() + ": " + cursosDisponibles.size());

        model.addAttribute("accion", "Crear");
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("cursos", cursosDisponibles);
        return "vistas/matricula/matricular_materias";
    }

    @PostMapping("/matriculaguardar")
    public String guardarMateriasMatriculadas(@RequestParam("cursoIds") List<Curso> cursoIds,
                                              @RequestParam("estudianteId") Long estudianteId,
                                              RedirectAttributes flash) {
        // Validar que se seleccionaron materias
        if (cursoIds.isEmpty()) {
            flash.addFlashAttribute("error", "Debe seleccionar al menos una materia.");
            return "redirect:/academia/matriculanueva/" + estudianteId;
        }

        // Guardar las materias seleccionadas
        cursoMatriculadoService.matricularCursos(cursoIds, estudianteId);

        flash.addFlashAttribute("success", "Materias matriculadas con éxito.");
        return "redirect:/academia/estudianteslistar";
    }

}
