-- Crear la base de datos si no existe
DO $$
BEGIN
   IF NOT EXISTS (SELECT 1 FROM pg_database WHERE datname = 'bd_banking') THEN
      CREATE DATABASE bd_banking;
   END IF;
END $$;

-- Seleccionar la base de datos
\c bd_banking;

-- Creación de la tabla cliente (si no existe)
CREATE TABLE IF NOT EXISTS cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(50) UNIQUE NOT NULL
);

-- Creación de la tabla cuentas
CREATE TABLE IF NOT EXISTS cuentas (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(50) NOT NULL UNIQUE,
    tipo_cuenta VARCHAR(50) NOT NULL CHECK (tipo_cuenta IN ('Ahorro', 'Corriente')),
    saldo_inicial NUMERIC(15,2) NOT NULL CHECK (saldo_inicial >= 0),
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    cliente_id INT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

-- Creación de la tabla movimientos
CREATE TABLE IF NOT EXISTS movimientos (
    id SERIAL PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tipo_movimiento VARCHAR(50) NOT NULL CHECK (tipo_movimiento IN ('Retiro', 'Depósito')),
    valor NUMERIC(15,2) NOT NULL CHECK (valor > 0),
    saldo_disponible NUMERIC(15,2) NOT NULL,
    numero_cuenta VARCHAR(50) NOT NULL,
    transaccion_id UUID NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    CONSTRAINT fk_movimiento_cuenta FOREIGN KEY (numero_cuenta) REFERENCES cuentas(numero_cuenta) ON DELETE CASCADE
);
