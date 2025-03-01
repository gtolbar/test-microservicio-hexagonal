package com.prueba.ms_banking.application.handler;

import com.prueba.ms_banking.application.dto.CuentaRequest;
import com.prueba.ms_banking.application.dto.CuentaResponse;
import com.prueba.ms_banking.application.mapper.CuentaRequestMapper;
import com.prueba.ms_banking.application.mapper.CuentaResponseMapper;
import com.prueba.ms_banking.domain.api.ICuentaServicePort;

import java.util.List;

public class CuentaHandler implements ICuentaHandler{

    private final ICuentaServicePort servicePort;
    private final CuentaRequestMapper requestMapper;
    private final CuentaResponseMapper responseMapper;

    public CuentaHandler(ICuentaServicePort servicePort, CuentaRequestMapper requestMapper, CuentaResponseMapper responseMapper) {
        this.servicePort = servicePort;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public void saveModelIn(CuentaRequest model) {
        servicePort.saveModel(requestMapper.toModel(model));
    }

    @Override
    public List<CuentaResponse> getAllModelFrom() {
        return responseMapper.toResponseList(servicePort.getAllModel());
    }

    @Override
    public CuentaResponse getModelFrom(Long id) {
        return responseMapper.toResponse(servicePort.getModel(id));
    }

    @Override
    public void updateModelIn(CuentaRequest model) {
        servicePort.updateModel(requestMapper.toModel(model));
    }

    @Override
    public void deleteModelFrom(Long id) {
        servicePort.deleteModel(id);
    }
}