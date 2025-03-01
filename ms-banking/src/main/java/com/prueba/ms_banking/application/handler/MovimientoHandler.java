package com.prueba.ms_banking.application.handler;

import com.prueba.ms_banking.application.dto.MovimientoRequest;
import com.prueba.ms_banking.application.dto.MovimientoResponse;
import com.prueba.ms_banking.application.mapper.MovimientoRequestMapper;
import com.prueba.ms_banking.application.mapper.MovimientoResponseMapper;
import com.prueba.ms_banking.domain.api.IMovimientoServicePort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //ACID principios
public class MovimientoHandler implements IMovimientoHandler{

    private final IMovimientoServicePort servicePort;
    private final MovimientoRequestMapper requestMapper;
    private final MovimientoResponseMapper responseMapper;

    public MovimientoHandler(IMovimientoServicePort servicePort, MovimientoRequestMapper requestMapper, MovimientoResponseMapper responseMapper) {
        this.servicePort = servicePort;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @Override
    public void saveModelIn(MovimientoRequest model) {
        servicePort.saveModel(requestMapper.toModel(model));
    }

    @Override
    public List<MovimientoResponse> getAllModelFrom() {
        return responseMapper.toResponseList(servicePort.getAllModel());
    }

    @Override
    public MovimientoResponse getModelFrom(Long id) {
        return responseMapper.toResponse(servicePort.getModel(id));
    }

    @Override
    public void updateModelIn(MovimientoRequest model) {
        servicePort.updateModel(requestMapper.toModel(model));
    }

    @Override
    public void deleteModelFrom(Long id) {
        servicePort.deleteModel(id);
    }
}