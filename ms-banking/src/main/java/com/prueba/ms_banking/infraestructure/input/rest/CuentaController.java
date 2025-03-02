package com.prueba.ms_banking.infraestructure.input.rest;

import com.prueba.ms_banking.application.dto.CuentaRequest;
import com.prueba.ms_banking.application.dto.CuentaResponse;
import com.prueba.ms_banking.application.handler.ICuentaHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final ICuentaHandler handler;

    public CuentaController(ICuentaHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/")
    public ResponseEntity<Void> saveIn(@RequestBody CuentaRequest request){
        handler.saveModelIn(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<CuentaResponse>> getAllFrom(){
        return ResponseEntity.ok(handler.getAllModelFrom());
    }

    @GetMapping("/{number}")
    public ResponseEntity<CuentaResponse> getFrom(@PathVariable(name = "number") Long id){
        return ResponseEntity.ok(handler.getModelFrom(id));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateIn(@RequestBody CuentaRequest request){
        handler.updateModelIn(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deletesIn(@PathVariable(name = "number") Long id){
        handler.deleteModelFrom(id);
        return ResponseEntity.ok().build();
    }


}