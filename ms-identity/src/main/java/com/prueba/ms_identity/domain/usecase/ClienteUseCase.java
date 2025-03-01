package com.prueba.ms_identity.domain.usecase;

import com.prueba.ms_identity.domain.api.IClienteServicePort;
import com.prueba.ms_identity.domain.model.Cliente;
import com.prueba.ms_identity.domain.spi.IClientePersistenePort;

import java.util.List;

public class ClienteUseCase implements IClienteServicePort {

    private final IClientePersistenePort port;

    public ClienteUseCase(IClientePersistenePort port) {
        this.port = port;
    }

    @Override
    public void saveModel(Cliente model) {
        port.saveModel(model);
    }

    @Override
    public List<Cliente> getAllModel() {
        return port.getAllModel();
    }

    @Override
    public Cliente getModel(Long id) {
        return port.getModel(id);
    }

    @Override
    public void updateModel(Cliente model) {
        port.updateModel(model);
    }

    @Override
    public void deleteModel(Long id) {
        port.deleteModel(id);
    }
}
