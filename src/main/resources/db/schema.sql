-- Drop existing tables if they exist
DROP TABLE IF EXISTS employee CASCADE;
DROP TABLE IF EXISTS role CASCADE;

-- Create role table
CREATE TABLE role (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Create employee table
CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    faceID VARCHAR(255),
    role_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_employee_role FOREIGN KEY (role_id) REFERENCES role(id) ON DELETE SET NULL
);

-- Insert initial roles
INSERT INTO role (nombre) VALUES ('Empleado'), ('Administrador');

-- Insert initial employees
INSERT INTO employee (nombre, correo, faceID, role_id) VALUES
('Carlos Pérez', 'carlos@empresa.com', 'faceid011', 1),
('Ana López', 'ana@empresa.com', 'faceid012', 1),
('Jorge Campos', 'jorge@empresa.com', 'faceid013', 2);
