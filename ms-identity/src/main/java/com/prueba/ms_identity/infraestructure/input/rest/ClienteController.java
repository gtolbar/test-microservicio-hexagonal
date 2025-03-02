package com.prueba.ms_identity.infraestructure.input.rest;

import com.prueba.ms_identity.application.dto.ClienteRequest;
import com.prueba.ms_identity.application.dto.ClienteResponse;
import com.prueba.ms_identity.application.handler.IClienteHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final IClienteHandler handler;

    public ClienteController(IClienteHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/")
    public ResponseEntity<Void> saveIn(@RequestBody ClienteRequest request){
        handler.saveModelIn(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteResponse>> getAllFrom(){
        return ResponseEntity.ok(handler.getAllModelFrom());
    }

    @GetMapping("/{number}")
    public ResponseEntity<ClienteResponse> getFrom(@PathVariable(name = "number") Long id){
        return ResponseEntity.ok(handler.getModelFrom(id));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateIn(@RequestBody ClienteRequest request){
        handler.updateModelIn(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deletesIn(@PathVariable(name = "number") Long id){
        handler.deleteModelFrom(id);
        return ResponseEntity.ok().build();
    }

}
