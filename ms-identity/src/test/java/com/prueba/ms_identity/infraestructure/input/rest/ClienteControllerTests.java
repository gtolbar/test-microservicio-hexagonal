package com.prueba.ms_identity.infraestructure.input.rest;

import com.prueba.ms_identity.application.dto.ClienteRequest;
import com.prueba.ms_identity.application.dto.ClienteResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class ClienteControllerTests {

    @Autowired
    private TestRestTemplate restTemplate;

    private ClienteRequest clienteRequest;

    @BeforeEach
    void setUp() {
        clienteRequest = new ClienteRequest();
        clienteRequest.setId(1L);  // Opcional, si la BD genera el ID automáticamente puedes omitirlo
        clienteRequest.setNombre("Juan Pérez");
        clienteRequest.setGenero("Masculino");
        clienteRequest.setEdad(30);
        clienteRequest.setIdentificacion("123456789");
        clienteRequest.setDireccion("Calle 123, Ciudad");
        clienteRequest.setTelefono("987654321");
        clienteRequest.setContrasena("secreta123"); // Este dato podría omitirse si no se usa en la API de lectura
        clienteRequest.setEstado(true);
    }


    @Test
    void testSaveAndGetAllClientes() {
        ResponseEntity<Void> saveResponse = restTemplate.postForEntity("/clientes/", clienteRequest, Void.class);
        assertEquals(HttpStatus.CREATED, saveResponse.getStatusCode());

        ResponseEntity<ClienteResponse[]> getAllResponse = restTemplate.getForEntity("/clientes/", ClienteResponse[].class);
        assertEquals(HttpStatus.OK, getAllResponse.getStatusCode());

        List<ClienteResponse> clientes = List.of(getAllResponse.getBody());

        assertFalse(clientes.isEmpty(), "La lista de clientes no debe estar vacía");

        ClienteResponse clienteGuardado = clientes.stream()
                .filter(cliente -> "123456789".equals(cliente.getIdentificacion()))
                .findFirst()
                .orElse(null);

        assertNotNull(clienteGuardado, "El cliente guardado debe estar en la lista");
        assertEquals("Juan Pérez", clienteGuardado.getNombre());
        assertEquals("Masculino", clienteGuardado.getGenero());
        assertEquals(30, clienteGuardado.getEdad());
        assertEquals("Calle 123, Ciudad", clienteGuardado.getDireccion());
        assertEquals("987654321", clienteGuardado.getTelefono());
        assertEquals(true, clienteGuardado.getEstado());
    }

}
