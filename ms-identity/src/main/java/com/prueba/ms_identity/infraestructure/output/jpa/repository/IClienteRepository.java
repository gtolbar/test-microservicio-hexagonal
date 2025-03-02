package com.prueba.ms_identity.infraestructure.output.jpa.repository;

import com.prueba.ms_identity.infraestructure.output.jpa.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<ClienteEntity,Long> {

    Optional<ClienteEntity> findByIdentificacion(String identificacion);

}
