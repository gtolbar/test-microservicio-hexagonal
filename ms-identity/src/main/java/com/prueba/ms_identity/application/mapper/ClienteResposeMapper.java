package com.prueba.ms_identity.application.mapper;

import com.prueba.ms_identity.application.dto.ClienteResponse;
import com.prueba.ms_identity.domain.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface ClienteResposeMapper {

    ClienteResponse toResponse(Cliente model);

}
