package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "plan_estudio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanEstudio {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String descripcion;

    @NotBlank
    @Column(name = "ano_vigencia")
    private int anoVigencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "programa_id")
    private ProgramaAcademico programa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "plan")
    private List<AsignaturaPlan> planesAsignatura;

}
