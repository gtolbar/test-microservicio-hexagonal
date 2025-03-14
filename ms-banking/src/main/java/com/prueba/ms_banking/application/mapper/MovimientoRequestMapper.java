package com.prueba.ms_banking.application.mapper;

import com.prueba.ms_banking.application.dto.MovimientoRequest;
import com.prueba.ms_banking.domain.model.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface MovimientoRequestMapper {

    Movimiento toModel(MovimientoRequest request);

}