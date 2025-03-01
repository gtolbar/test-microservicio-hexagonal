package com.prueba.ms_banking.application.mapper;

import com.prueba.ms_banking.application.dto.MovimientoResponse;
import com.prueba.ms_banking.domain.model.Movimiento;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface MovimientoResponseMapper {

    MovimientoResponse toResponse(Movimiento model);

    List<MovimientoResponse> toResponseList(List<Movimiento> personas);


}