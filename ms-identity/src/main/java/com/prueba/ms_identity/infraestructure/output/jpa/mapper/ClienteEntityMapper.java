package com.prueba.ms_identity.infraestructure.output.jpa.mapper;

import com.prueba.ms_identity.domain.model.Cliente;
import com.prueba.ms_identity.infraestructure.output.jpa.entity.ClienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface ClienteEntityMapper {

    ClienteEntity toEntity(Cliente model);
    Cliente toModel(ClienteEntity entity);
    List<Cliente> toModelList(List<ClienteEntity> listEntity);

}
