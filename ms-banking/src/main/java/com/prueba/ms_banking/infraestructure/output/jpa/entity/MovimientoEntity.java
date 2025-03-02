package com.prueba.ms_banking.infraestructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "movimientos")
public class MovimientoEntity {

    @Id
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(name = "tipo_movimiento", nullable = false)
    private String tipoMovimiento; // Retiro, Depósito

    @Column(nullable = false)
    private Double valor;

    @Column(name = "saldo_disponible", nullable = false)
    private Double saldoDisponible;

    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta; // Relación referencial, no con JPA

    @Column(name = "transaccion_id", unique = true, nullable = false, updatable = false)
    private String transaccionId;

    @PrePersist
    protected void prePersist() {
        this.transaccionId = UUID.randomUUID().toString();
        this.fecha = LocalDateTime.now();
    }

}