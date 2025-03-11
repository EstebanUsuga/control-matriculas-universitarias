package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "asignatura_cursada")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaCursada {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asignatura_id")
    private Asignatura asignatura;

    @NotBlank
	@DecimalMin(value = "0.0", inclusive = true)
	@DecimalMax(value = "5.0", inclusive = true)
    private Double nota_final;

}
