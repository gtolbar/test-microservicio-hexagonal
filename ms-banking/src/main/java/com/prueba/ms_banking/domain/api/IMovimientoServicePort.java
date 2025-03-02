package com.prueba.ms_banking.domain.api;

import com.prueba.ms_banking.domain.model.Movimiento;

import java.util.List;

public interface IMovimientoServicePort extends IGenericServicePort<Movimiento,Long>{

    List<Movimiento> getNumeroCuentaModelos(String numeroCuenta);

}