package com.prueba.ms_banking.domain.usecase;

import com.prueba.ms_banking.domain.api.IMovimientoServicePort;
import com.prueba.ms_banking.domain.model.Movimiento;
import com.prueba.ms_banking.domain.spi.IMovimientoPersistencePort;

import java.util.List;

public class MovimientoUseCase implements IMovimientoServicePort {

    private final IMovimientoPersistencePort port;

    public MovimientoUseCase(IMovimientoPersistencePort port) {
        this.port = port;
    }

    @Override
    public void saveModel(Movimiento model) {
        port.saveModel(model);
    }

    @Override
    public List<Movimiento> getAllModel() {
        return port.getAllModel();
    }

    @Override
    public Movimiento getModel(Long id) {
        return port.getModel(id);
    }

    @Override
    public void updateModel(Movimiento model) {
        port.updateModel(model);
    }

    @Override
    public void deleteModel(Long id) {
        port.deleteModel(id);
    }
}