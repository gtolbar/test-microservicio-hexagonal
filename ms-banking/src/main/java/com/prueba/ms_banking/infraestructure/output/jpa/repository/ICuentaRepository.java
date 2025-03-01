package com.prueba.ms_banking.infraestructure.output.jpa.repository;

import com.prueba.ms_banking.infraestructure.output.jpa.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaRepository extends JpaRepository<CuentaEntity,Long> {}