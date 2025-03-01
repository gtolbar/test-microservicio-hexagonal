package com.prueba.ms_identity.application.handler;

import com.prueba.ms_identity.application.dto.ClienteRequest;
import com.prueba.ms_identity.application.dto.ClienteResponse;
import com.prueba.ms_identity.application.mapper.ClienteRequestMapper;
import com.prueba.ms_identity.application.mapper.ClienteResposeMapper;
import com.prueba.ms_identity.domain.api.IClienteServicePort;

import java.util.List;

public class ClienteHandler implements IClienteHandler{

    private final IClienteServicePort servicePort;
    private final ClienteRequestMapper requestMapper;
    private final ClienteResposeMapper responseMapper;

    public ClienteHandler(IClienteServicePort servicePort, ClienteRequestMapper requestMapper, ClienteResposeMapper responseMapper) {
        this.servicePort = servicePort;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public void saveModelIn(ClienteRequest model) {
        servicePort.saveModel(requestMapper.toModel(model));
    }

    @Override
    public List<ClienteResponse> getAllModelFrom() {
        return responseMapper.toResponseList(servicePort.getAllModel());
    }

    @Override
    public ClienteResponse getModelFrom(Long id) {
        return responseMapper.toResponse(servicePort.getModel(id));
    }

    @Override
    public void updateModelIn(ClienteRequest model) {
        servicePort.updateModel(requestMapper.toModel(model));
    }

    @Override
    public void deleteModelFrom(Long id) {
        servicePort.deleteModel(id);
    }
}
