package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "curso_matriculado")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CursoMatriculado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @NotBlank
    @Column(length = 50)
    private String periodo;

    @NotBlank
    @Column(name = "estado_curso", length = 20)
    private String estado;

    @Min(value = 0)
    @Column(name = "nota_final")
    private double notaFinal;


}
