package com.prueba.ms_banking.application.handler;

import com.prueba.ms_banking.application.dto.MovimientoRequest;
import com.prueba.ms_banking.application.dto.MovimientoResponse;

import java.util.List;

public class MovimientoHandler implements IMovimientoHandler{
    @Override
    public void saveModelIn(MovimientoRequest movimientoRequest) {

    }

    @Override
    public List<MovimientoResponse> getAllModelFrom() {
        return List.of();
    }

    @Override
    public MovimientoResponse getModelFrom(Long aLong) {
        return null;
    }

    @Override
    public void updateModelIn(MovimientoRequest movimientoRequest) {

    }

    @Override
    public void deleteModelFrom(Long aLong) {

    }
}