package com.prueba.ms_banking.domain.usecase;

import com.prueba.ms_banking.domain.api.IMovimientoServicePort;
import com.prueba.ms_banking.domain.model.Movimiento;
import com.prueba.ms_banking.domain.spi.IMovimientoPersistencePort;
import com.prueba.ms_banking.domain.util.MovimientoConstantes;

import java.util.List;
import java.util.Optional;

public class MovimientoUseCase implements IMovimientoServicePort {

    private final IMovimientoPersistencePort port;

    public MovimientoUseCase(IMovimientoPersistencePort port) {
        this.port = port;
    }

    @Override
    public void saveModel(Movimiento model) {
        // Obtener el último movimiento de la cuenta
        Optional<Movimiento> movimiento = port.getUltimoMovimiento(model.getNumeroCuenta());

        double saldoAnterior = movimiento.map(Movimiento::getSaldoDisponible).orElse(0.0);

        // Ajustar el saldo disponible según el tipo de movimiento
        if (MovimientoConstantes.DEPOSITO.equalsIgnoreCase(model.getTipoMovimiento())) {
            model.setSaldoDisponible(saldoAnterior + model.getValor());
        } else if (MovimientoConstantes.RETIRO.equalsIgnoreCase(model.getTipoMovimiento())) {
            if (saldoAnterior >= model.getValor()) {
                model.setSaldoDisponible(saldoAnterior - model.getValor());
            } else {
                throw new IllegalArgumentException("Saldo insuficiente para el retiro.");
            }
        } else {
            throw new IllegalArgumentException("Tipo de movimiento no válido.");
        }

        // Guardar el modelo con el saldo actualizado
        port.saveModel(model);
    }

    @Override
    public List<Movimiento> getAllModel() {
        return port.getAllModel();
    }

    @Override
    public Movimiento getModel(Long id) {
        return port.getModel(id);
    }

    @Override
    public void updateModel(Movimiento model) {
        port.updateModel(model);
    }

    @Override
    public void deleteModel(Long id) {
        port.deleteModel(id);
    }

    @Override
    public List<Movimiento> getNumeroCuentaModelos(String numeroCuenta) {
        return port.getNumeroCuentaModelos(numeroCuenta);
    }
}