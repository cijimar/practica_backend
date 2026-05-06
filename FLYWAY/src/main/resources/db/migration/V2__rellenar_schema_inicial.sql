-- Insercion de datos iniciales en la tabla de generos
INSERT INTO `generos` (`nombre`) VALUES ('Hombre'), ('Mujer'), ('Otro');

-- Insercion puestos de trabajo
INSERT INTO `puestos_de_trabajo` (`nombre`) VALUES ('Desarrollador'), ('Diseñador'), ('Gestor de Proyectos');

-- Insercion de usuarios
INSERT INTO `usuarios` (`contrasena`, `fecha_hora_creacion`, `fecha_nacimiento`, `hora_desayuno`, `nick_usuario`, `nombre`, `primer_apellido`, `segundo_apellido`, `genero_id`, `puesto_de_trabajo_id`) VALUES
('password123', '2024-06-01 10:00:00', '1990-01-01', '08:00:00', 'usuario1', 'Juan', 'Pérez', 'García', 1, 1),
('password456', '2024-06-02 11:00:00', '1992-02-02', '08:30:00', 'usuario2', 'María', 'López', 'Martínez', 2, 2),
('password789', '2024-06-03 12:00:00', '1995-03-03', NULL, 'usuario3', 'Alex', 'Sánchez', NULL, 3, NULL);

-- Insercion de direcciones
INSERT INTO `direcciones` (`direccion_principal`, `nombre_calle`, `numero_calle`, `usuario_id`) VALUES
(1, 'Calle Mayor', 123, 1),
(0, 'Avenida de la Constitución', 456, 1),
(1, 'Calle del Sol', 789, 2);
