package com.prueba.ms_gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fallback")
public class FallbackController {

    @GetMapping("/identity")
    public ResponseEntity<String> identityFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("El servicio de identidad no está disponible. Inténtalo más tarde.");
    }

    @GetMapping("/banking")
    public ResponseEntity<String> bankingFallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("El servicio de banking no está disponible. Inténtalo más tarde.");
    }
}
