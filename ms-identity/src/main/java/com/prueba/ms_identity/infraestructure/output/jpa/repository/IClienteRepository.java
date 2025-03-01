package com.prueba.ms_identity.infraestructure.output.jpa.repository;

import com.prueba.ms_identity.infraestructure.output.jpa.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<ClienteEntity,Long> {
}
