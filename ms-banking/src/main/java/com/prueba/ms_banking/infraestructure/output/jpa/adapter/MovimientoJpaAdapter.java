package com.prueba.ms_banking.infraestructure.output.jpa.adapter;

import com.prueba.ms_banking.domain.model.Movimiento;
import com.prueba.ms_banking.domain.spi.IMovimientoPersistencePort;
import com.prueba.ms_banking.infraestructure.exception.PersonaAlreadyExistsException;
import com.prueba.ms_banking.infraestructure.exception.PersonaNotFoundException;
import com.prueba.ms_banking.infraestructure.output.jpa.entity.MovimientoEntity;
import com.prueba.ms_banking.infraestructure.output.jpa.mapper.MovimientoEntityMapper;
import com.prueba.ms_banking.infraestructure.output.jpa.repository.IMovimientoRepository;

import java.util.List;

public class MovimientoJpaAdapter implements IMovimientoPersistencePort {

    private final IMovimientoRepository respository;
    private final MovimientoEntityMapper entityMapper;

    public MovimientoJpaAdapter(IMovimientoRepository respository, MovimientoEntityMapper entityMapper) {
        this.respository = respository;
        this.entityMapper = entityMapper;
    }

    @Override
    public void saveModel(Movimiento model) {
        if (respository.findById(model.getId()).isPresent()){
            throw new PersonaAlreadyExistsException();
        }
        respository.save(entityMapper.toEntity(model));
    }

    @Override
    public List<Movimiento> getAllModel() {
        List<MovimientoEntity> listPersona = respository.findAll();
        if (listPersona.isEmpty()){
            throw new PersonaNotFoundException();
        }
        return entityMapper.toModelList(listPersona);
    }

    @Override
    public Movimiento getModel(Long id) {
        return entityMapper.toModel(respository.findById(id).orElseThrow(PersonaNotFoundException::new));
    }

    @Override
    public void updateModel(Movimiento model) {
        respository.save(entityMapper.toEntity(model));
    }

    @Override
    public void deleteModel(Long id) {
        respository.deleteById(id);
    }
}