package com.prueba.ms_identity.infraestructure.output.jpa.adapter;

import com.prueba.ms_identity.domain.model.Cliente;
import com.prueba.ms_identity.domain.spi.IClientePersistenePort;
import com.prueba.ms_identity.infraestructure.exception.PersonaAlreadyExistsException;
import com.prueba.ms_identity.infraestructure.exception.PersonaNotFoundException;
import com.prueba.ms_identity.infraestructure.output.jpa.entity.ClienteEntity;
import com.prueba.ms_identity.infraestructure.output.jpa.mapper.ClienteEntityMapper;
import com.prueba.ms_identity.infraestructure.output.jpa.repository.IClienteRepository;

import java.util.List;

public class ClienteJpaAdapter implements IClientePersistenePort {

    private final IClienteRepository respository;
    private final ClienteEntityMapper entityMapper;

    public ClienteJpaAdapter(IClienteRepository respository, ClienteEntityMapper entityMapper) {
        this.respository = respository;
        this.entityMapper = entityMapper;
    }

    @Override
    public void saveModel(Cliente model) {
        if (respository.findById(model.getId()).isPresent()){
            throw new PersonaAlreadyExistsException();
        }
        respository.save(entityMapper.toEntity(model));
    }

    @Override
    public List<Cliente> getAllModel() {
        List<ClienteEntity> listPersona = respository.findAll();
        if (listPersona.isEmpty()){
            throw new PersonaNotFoundException();
        }
        return entityMapper.toModelList(listPersona);
    }

    @Override
    public Cliente getModel(Long id) {
        return entityMapper.toModel(respository.findById(id).orElseThrow(PersonaNotFoundException::new));
    }

    @Override
    public void updateModel(Cliente model) {
        respository.save(entityMapper.toEntity(model));
    }

    @Override
    public void deleteModel(Long id) {
        respository.deleteById(id);
    }
}
