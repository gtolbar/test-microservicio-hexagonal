package com.prueba.ms_banking.domain.spi;

import com.prueba.ms_banking.domain.model.Movimiento;

import java.util.List;
import java.util.Optional;

public interface IMovimientoPersistencePort extends IGenericPersistencePort<Movimiento,Long>{

    List<Movimiento> getNumeroCuentaModelos(String numeroCuenta);
    Optional<Movimiento> getUltimoMovimiento(String numeroCuenta);


}