package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "estudiante")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Estudiante {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String identificacion;

    @NotEmpty
    private String apellidos;

    @NotEmpty
    private String nombres;

    @NotNull
    private int semestre_actual;

    @NotNull
    private boolean estado;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "programa_id")
    private ProgramaAcademico programa;
}
