-- Crear la base de datos si no existe
CREATE DATABASE bd_banking;

-- Creación de la tabla cliente con ID corregido
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    edad INT NOT NULL CHECK (edad > 0),  -- Asegura que la edad sea positiva
    identificacion VARCHAR(50) NOT NULL UNIQUE,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    contraseña TEXT NOT NULL,  -- Se recomienda hashear la contraseña
    estado BOOLEAN NOT NULL DEFAULT TRUE
);

-- Creación de la tabla cuentas
CREATE TABLE cuentas (
    id SERIAL PRIMARY KEY,
    numero_cuenta VARCHAR(50) NOT NULL UNIQUE,
    tipo_cuenta VARCHAR(50) NOT NULL CHECK (tipo_cuenta IN ('Ahorro', 'Corriente')),  -- Solo permite estos valores
    saldo_inicial NUMERIC(15,2) NOT NULL CHECK (saldo_inicial >= 0),  -- No permitir saldo negativo
    estado BOOLEAN NOT NULL DEFAULT TRUE,
    cliente_id INT NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id) ON DELETE CASCADE
);

-- Creación de la tabla movimientos
CREATE TABLE movimientos (
    id SERIAL PRIMARY KEY,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  -- Fecha automática si no se proporciona
    tipo_movimiento VARCHAR(50) NOT NULL CHECK (tipo_movimiento IN ('Retiro', 'Depósito')),  -- Solo permite estos valores
    valor NUMERIC(15,2) NOT NULL CHECK (valor > 0),  -- No permitir valores negativos
    saldo_disponible NUMERIC(15,2) NOT NULL,
    numero_cuenta VARCHAR(50) NOT NULL,
    transaccion_id UUID NOT NULL UNIQUE DEFAULT gen_random_uuid()  -- Generar UUID automático
);