package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "asignatura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String nombre;

    @NotNull
    @Column(name = "numero_creditos")
    private int numeroCreditos;

    @NotEmpty
    private String departamento;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="asignatura")
    private List<AsignaturaPlan> asignaturaPlanes;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "asignatura")
    private List<Curso> cursos;
}
