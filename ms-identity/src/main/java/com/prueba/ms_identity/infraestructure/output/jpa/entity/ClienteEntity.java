package com.prueba.ms_identity.infraestructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cliente")
public class ClienteEntity extends PersonaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private Boolean estado;

}
