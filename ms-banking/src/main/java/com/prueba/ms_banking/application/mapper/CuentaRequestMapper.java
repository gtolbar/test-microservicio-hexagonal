package com.prueba.ms_banking.application.mapper;

import com.prueba.ms_banking.application.dto.CuentaRequest;
import com.prueba.ms_banking.domain.model.Cuenta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface CuentaRequestMapper {

    Cuenta toModel(CuentaRequest request);

}