package com.prueba.ms_banking.infraestructure.output.jpa.mapper;

import com.prueba.ms_banking.domain.model.Cuenta;
import com.prueba.ms_banking.infraestructure.output.jpa.entity.CuentaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface CuentaEntityMapper {

    CuentaEntity toEntity(Cuenta model);
    Cuenta toModel(CuentaEntity entity);
    List<Cuenta> toModelList(List<CuentaEntity> listEntity);

}