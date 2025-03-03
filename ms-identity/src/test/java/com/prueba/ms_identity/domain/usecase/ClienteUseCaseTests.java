package com.prueba.ms_identity.domain.usecase;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.prueba.ms_identity.domain.model.Cliente;
import com.prueba.ms_identity.domain.spi.IClientePersistenePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ClienteUseCaseTests {

    @Mock
    private IClientePersistenePort port;

    @InjectMocks
    private ClienteUseCase clienteUseCase;

    private Cliente clienteDummy;

    @BeforeEach
    void setUp() {
        clienteDummy = new Cliente(
                "0987654321", "Calle Falsa 123", "1234567890",
                30, "Masculino", "Juan Pérez"
        );
    }

    @Test
    void testGetAllModel(){

        List<Cliente> clientes = Arrays.asList(clienteDummy);
        when(port.getAllModel()).thenReturn(clientes);

        List<Cliente> resultado = clienteUseCase.getAllModel();

        assertEquals(1, resultado.size());
        assertEquals("Juan Pérez", resultado.get(0).getNombre());
        verify(port, times(1)).getAllModel();

    }

}
