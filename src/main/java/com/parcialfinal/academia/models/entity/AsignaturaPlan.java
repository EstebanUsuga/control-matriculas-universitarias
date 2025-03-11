package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "asignatura_plan")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @NotBlank
    @Column(name = "semestre_nivel")
    private int semestreNivel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prerrequisito")
    private Asignatura preAsignatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private PlanEstudio plan;
}
