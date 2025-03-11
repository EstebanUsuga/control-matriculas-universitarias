package com.parcialfinal.academia.controller;

import com.parcialfinal.academia.models.entity.Estudiante;
import com.parcialfinal.academia.models.entity.ProgramaAcademico;
import com.parcialfinal.academia.models.service.EstudianteService;
import com.parcialfinal.academia.models.service.ProgramaAcademicoService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
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
public class EstudianteController {

    private final EstudianteService estudianteService;
    private final ProgramaAcademicoService programaAcademicoService;


    @GetMapping("/estudianteslistar")
    public String listarEstudiantes(Model model) {
        List<Estudiante> estudiantes = estudianteService.obtenerEstudiantePorEstado(true);
        model.addAttribute("titulo", "Listado de Estudiantes");
        model.addAttribute("estudiantes", estudiantes);
        return "vistas/estudiante/listado_estudiantes";
    }

    @GetMapping("/estudiantenuevo")
    public String nuevoEstudianteForm(Model model) {
        model.addAttribute("titulo", "Nuevo Estudiante");
        model.addAttribute("accion", "Crear");
        model.addAttribute("programas", programaAcademicoService.obtenerProgramasAcademicos());
        model.addAttribute("estudiante", new Estudiante());
        return "vistas/estudiante/formulario_estudiante";
    }

    @PostMapping("/estudianteguardar")
    public String guardarEstudiante(@Valid @ModelAttribute Estudiante estudiante, BindingResult result,
                                    Model model, RedirectAttributes flash) {
        String accion = (estudiante.getId() == null) ? "Guardar" : "Modificar";

        if (result.hasErrors()) {
            model.addAttribute("titulo", accion + " Estudiante");
            model.addAttribute("accion", accion);
            model.addAttribute("info", "Corrija los campos del formulario");
            return "vistas/estudiante/formulario_estudiante";
        }

        // Si el estudiante tiene ID, lo buscamos en la base de datos
        if (estudiante.getId() != null) {
            Optional<Estudiante> estudianteExistente = estudianteService.obtenerEstudiantePorId(estudiante.getId());
            if (estudianteExistente.isPresent()) {
                // Si existe, actualizamos los datos del estudiante
                Estudiante estudianteDb = estudianteExistente.get();
                estudianteDb.setIdentificacion(estudiante.getIdentificacion());
                estudianteDb.setApellidos(estudiante.getApellidos());
                estudianteDb.setNombres(estudiante.getNombres());
                estudianteDb.setSemestre_actual(estudiante.getSemestre_actual());
                estudianteDb.setPrograma(estudiante.getPrograma());
                estudianteService.guardar(estudianteDb);
                flash.addFlashAttribute("success", "El estudiante fue modificado con éxito");
            } else {
                flash.addFlashAttribute("error", "Estudiante no encontrado");
                return "redirect:/academia/estudianteslistar";
            }
        } else {

            estudiante.setEstado(true);
            // Si el estudiante no tiene ID, creamos uno nuevo
            estudianteService.guardar(estudiante);
            flash.addFlashAttribute("success", "El estudiante fue agregado con éxito");
        }

        return "redirect:/academia/estudianteslistar";
    }


    @GetMapping("/estudianteconsultar/{id}")
    public String consultarEstudiante(@PathVariable Long id, RedirectAttributes flash, Model model) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id)
                .orElse(null);

        if (estudiante == null) {
            flash.addFlashAttribute("warning", "El estudiante no fue hallado en la base de datos");
            return "redirect:/academia/estudianteslistar";
        }

        model.addAttribute("titulo", "Detalle del Estudiante: " + estudiante.getNombres());
        model.addAttribute("estudiante", estudiante);
        return "vistas/estudiante/consulta_estudiante";
    }

    @GetMapping("/estudiantemodificar/{id}")
    public String modificarEstudianteForm(@PathVariable Long id, RedirectAttributes flash, Model model) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id)
                .orElse(null);

        if (estudiante == null) {
            flash.addFlashAttribute("warning", "El estudiante no fue hallado en la base de datos");
            return "redirect:/academia/estudianteslistar";
        }

        model.addAttribute("titulo", "Modificar Estudiante");
        model.addAttribute("accion", "Modificar");
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("programas", programaAcademicoService.obtenerProgramasAcademicos());
        return "vistas/estudiante/formulario_estudiante";
    }

    @GetMapping("/estudianteeliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id, RedirectAttributes flash) {
        Estudiante estudiante = estudianteService.obtenerEstudiantePorId(id)
                .orElse(null);

        if (estudiante != null) {
            estudianteService.borradoLogico(id);
            flash.addFlashAttribute("success", "El estudiante fue eliminado de la base de datos");
        } else {
            flash.addFlashAttribute("error", "Error: el estudiante no existe o el ID no es válido");
        }
        return "redirect:/academia/estudianteslistar";
    }

}
