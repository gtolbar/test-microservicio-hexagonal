package com.prueba.ms_banking.domain.usecase;

import com.prueba.ms_banking.domain.api.ICuentaServicePort;
import com.prueba.ms_banking.domain.model.Cuenta;
import com.prueba.ms_banking.domain.spi.ICuentaPersistencePort;

import java.util.List;

public class CuentaUseCase implements ICuentaServicePort {

    private final ICuentaPersistencePort port;

    public CuentaUseCase(ICuentaPersistencePort port) {
        this.port = port;
    }

    @Override
    public void saveModel(Cuenta model) {
        port.saveModel(model);
    }

    @Override
    public List<Cuenta> getAllModel() {
        return port.getAllModel();
    }

    @Override
    public Cuenta getModel(Long id) {
        return port.getModel(id);
    }

    @Override
    public void updateModel(Cuenta model) {
        port.updateModel(model);
    }

    @Override
    public void deleteModel(Long id) {
        port.deleteModel(id);
    }
}