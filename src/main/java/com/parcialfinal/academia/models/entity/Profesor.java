package com.parcialfinal.academia.models.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "profesor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @NotEmpty
    @Column(name = "nombres")
    private String nombre;

    @NotEmpty
    @Column(name = "apellidos")
    private String apellido;

    @NotEmpty
    private String especializacion;

    @NotEmpty
    private String departamento;

}
