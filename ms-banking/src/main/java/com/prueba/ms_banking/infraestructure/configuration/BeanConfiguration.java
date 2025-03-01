package com.prueba.ms_banking.infraestructure.configuration;

import com.prueba.ms_banking.domain.api.ICuentaServicePort;
import com.prueba.ms_banking.domain.api.IMovimientoServicePort;
import com.prueba.ms_banking.domain.spi.ICuentaPersistencePort;
import com.prueba.ms_banking.domain.spi.IMovimientoPersistencePort;
import com.prueba.ms_banking.domain.usecase.CuentaUseCase;
import com.prueba.ms_banking.domain.usecase.MovimientoUseCase;
import com.prueba.ms_banking.infraestructure.output.jpa.adapter.CuentaJpaAdapter;
import com.prueba.ms_banking.infraestructure.output.jpa.adapter.MovimientoJpaAdapter;
import com.prueba.ms_banking.infraestructure.output.jpa.mapper.CuentaEntityMapper;
import com.prueba.ms_banking.infraestructure.output.jpa.mapper.MovimientoEntityMapper;
import com.prueba.ms_banking.infraestructure.output.jpa.repository.ICuentaRepository;
import com.prueba.ms_banking.infraestructure.output.jpa.repository.IMovimientoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    private final ICuentaRepository repositoryCuenta;
    private final CuentaEntityMapper entityMapperCuenta;
    private final IMovimientoRepository repositoryMovimiento;
    private final MovimientoEntityMapper entityMapperMovimiento;

    public BeanConfiguration(ICuentaRepository repository, CuentaEntityMapper entityMapper, ICuentaRepository repositoryCuenta, CuentaEntityMapper entityMapperCuenta, IMovimientoRepository repositoryMovimiento, MovimientoEntityMapper entityMapperMovimiento) {
        this.repositoryCuenta = repositoryCuenta;
        this.entityMapperCuenta = entityMapperCuenta;
        this.repositoryMovimiento = repositoryMovimiento;
        this.entityMapperMovimiento = entityMapperMovimiento;

    }

    @Bean
    public ICuentaPersistencePort persistencePortCuenta(){
        return new CuentaJpaAdapter(repositoryCuenta,entityMapperCuenta);
    }

    @Bean
    public ICuentaServicePort servicePortCuenta(){
        return new CuentaUseCase(persistencePortCuenta());
    }

    @Bean
    public IMovimientoPersistencePort persistencePortMovimiento(){
        return new MovimientoJpaAdapter(repositoryMovimiento,entityMapperMovimiento);
    }

    @Bean
    public IMovimientoServicePort servicePortMovimiento(){
        return new MovimientoUseCase(persistencePortMovimiento());
    }

}