package com.parcialfinal.academia.models.entity;

import jdk.jshell.Snippet;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity(name = "curso")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 10)
    private String periodo;

    @NotEmpty
    @Column(length = 20)
    private String horario;

    @NotNull
    @Column(name = "cupo_maximo")
    private int cupoM;

    @NotEmpty
    @Column(length = 30)
    private String aula;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @Transient
    private boolean estaMatriculado;
}
