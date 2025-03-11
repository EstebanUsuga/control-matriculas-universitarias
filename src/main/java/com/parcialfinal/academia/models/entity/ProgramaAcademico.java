package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "programa_academico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaAcademico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "nombre_programa", length = 60, nullable = false)
    private String nombrePrograma;

    @NotEmpty
    private String facultad;

    @NotEmpty
    private String titulo_otorgado;

    @NotNull
    private int duracion;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "programa")
    private List<PlanEstudio> planesEstudio;
    
}
