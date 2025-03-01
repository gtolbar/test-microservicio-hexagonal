package com.prueba.ms_banking.infraestructure.output.jpa.mapper;

import com.prueba.ms_banking.domain.model.Movimiento;
import com.prueba.ms_banking.infraestructure.output.jpa.entity.MovimientoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface MovimientoEntityMapper {

    MovimientoEntity toEntity(Movimiento model);
    Movimiento toModel(MovimientoEntity entity);
    List<Movimiento> toModelList(List<MovimientoEntity> listEntity);

}