package com.prueba.ms_banking.infraestructure.output.jpa.adapter;

import com.prueba.ms_banking.domain.model.Cuenta;
import com.prueba.ms_banking.domain.spi.ICuentaPersistencePort;
import com.prueba.ms_banking.infraestructure.exception.PersonaAlreadyExistsException;
import com.prueba.ms_banking.infraestructure.exception.PersonaNotFoundException;
import com.prueba.ms_banking.infraestructure.output.jpa.entity.CuentaEntity;
import com.prueba.ms_banking.infraestructure.output.jpa.mapper.CuentaEntityMapper;
import com.prueba.ms_banking.infraestructure.output.jpa.repository.ICuentaRepository;

import java.util.List;

public class CuentaJpaAdapter implements ICuentaPersistencePort {

    private final ICuentaRepository respository;
    private final CuentaEntityMapper entityMapper;

    public CuentaJpaAdapter(ICuentaRepository respository, CuentaEntityMapper entityMapper) {
        this.respository = respository;
        this.entityMapper = entityMapper;
    }

    @Override
    public void saveModel(Cuenta model) {
        if (respository.findById(model.getId()).isPresent()){
            throw new PersonaAlreadyExistsException();
        }
        respository.save(entityMapper.toEntity(model));
    }

    @Override
    public List<Cuenta> getAllModel() {
        List<CuentaEntity> listPersona = respository.findAll();
        if (listPersona.isEmpty()){
            throw new PersonaNotFoundException();
        }
        return entityMapper.toModelList(listPersona);
    }

    @Override
    public Cuenta getModel(Long id) {
        return entityMapper.toModel(respository.findById(id).orElseThrow(PersonaNotFoundException::new));
    }

    @Override
    public void updateModel(Cuenta model) {
        respository.save(entityMapper.toEntity(model));
    }

    @Override
    public void deleteModel(Long id) {
        respository.deleteById(id);
    }
}