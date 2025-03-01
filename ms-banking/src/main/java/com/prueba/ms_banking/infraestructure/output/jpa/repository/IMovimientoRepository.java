package com.prueba.ms_banking.infraestructure.output.jpa.repository;

import com.prueba.ms_banking.infraestructure.output.jpa.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientoRepository extends JpaRepository<MovimientoEntity,Long> {}