package com.prueba.ms_banking.infraestructure.output.jpa.repository;

import com.prueba.ms_banking.infraestructure.output.jpa.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMovimientoRepository extends JpaRepository<MovimientoEntity,Long> {

    List<MovimientoEntity> findByNumeroCuentaOrderByFechaDesc(String numeroCuenta);
    MovimientoEntity findFirstByNumeroCuentaOrderByFechaDesc(String numeroCuenta);


}