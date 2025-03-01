package com.prueba.ms_banking.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CuentaRequest {

    private Long id;
    private String numeroCuenta; // Identificador único de la cuenta
    private String tipoCuenta; // Ahorro, Corriente, etc.
    private Double saldoInicial;
    private Boolean estado;
    private Long clienteId;

}