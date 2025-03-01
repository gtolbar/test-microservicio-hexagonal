package com.prueba.ms_identity.infraestructure.configuration;

import com.prueba.ms_identity.domain.api.IClienteServicePort;
import com.prueba.ms_identity.domain.spi.IClientePersistenePort;
import com.prueba.ms_identity.domain.usecase.ClienteUseCase;
import com.prueba.ms_identity.infraestructure.output.jpa.adapter.ClienteJpaAdapter;
import com.prueba.ms_identity.infraestructure.output.jpa.mapper.ClienteEntityMapper;
import com.prueba.ms_identity.infraestructure.output.jpa.repository.IClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final IClienteRepository repository;
    private final ClienteEntityMapper entityMapper;

    public BeanConfiguration(IClienteRepository repository, ClienteEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }

    @Bean
    public IClientePersistenePort personaPersistenePort(){
        return new ClienteJpaAdapter(repository,entityMapper);
    }

    @Bean
    public IClienteServicePort personaServicePort(){
        return new ClienteUseCase(personaPersistenePort());
    }

}
