package com.prueba.ms_banking.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovimientoRequest {

    private Long id;
    private String numeroCuenta; // Se usa para asociar el movimiento con una cuenta existente
    private String tipoMovimiento; // Retiro o Depósito
    private Double valor;

}