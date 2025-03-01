package com.prueba.ms_identity.application.mapper;

import com.prueba.ms_identity.application.dto.ClienteRequest;
import com.prueba.ms_identity.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface ClienteRequestMapper {

    Cliente toModel(ClienteRequest request);

}
