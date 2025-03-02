package com.prueba.ms_banking.infraestructure.input.rest;

import com.prueba.ms_banking.application.dto.MovimientoRequest;
import com.prueba.ms_banking.application.dto.MovimientoResponse;
import com.prueba.ms_banking.application.handler.IMovimientoHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class MovimientoController {

    private final IMovimientoHandler handler;

    public MovimientoController(IMovimientoHandler handler) {
        this.handler = handler;
    }

    @PostMapping("/")
    public ResponseEntity<Void> saveIn(@RequestBody MovimientoRequest request){
        handler.saveModelIn(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<MovimientoResponse>> getAllFrom(){
        return ResponseEntity.ok(handler.getAllModelFrom());
    }

    @GetMapping("/{number}")
    public ResponseEntity<MovimientoResponse> getFrom(@PathVariable(name = "number") Long id){
        return ResponseEntity.ok(handler.getModelFrom(id));
    }

    @PutMapping("/")
    public ResponseEntity<Void> updateIn(@RequestBody MovimientoRequest request){
        handler.updateModelIn(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deletesIn(@PathVariable(name = "number") Long id){
        handler.deleteModelFrom(id);
        return ResponseEntity.ok().build();
    }

}