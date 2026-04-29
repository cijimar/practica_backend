CREATE TABLE `generos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK9u5buu0dehagjdoqm3wv6orm3` (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `puestos_de_trabajo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contrasena` varchar(255) NOT NULL,
  `fecha_hora_creacion` datetime(6) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `hora_desayuno` time(6) DEFAULT NULL,
  `nick_usuario` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `primer_apellido` varchar(255) NOT NULL,
  `segundo_apellido` varchar(255) DEFAULT NULL,
  `genero_id` int NOT NULL,
  `puesto_de_trabajo_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7cbljtyx7p0dy7j7ckkcikb4v` (`genero_id`),
  KEY `FKtaxa9nqsee1x8d5ts5rbvbxok` (`puesto_de_trabajo_id`),
  CONSTRAINT `FK7cbljtyx7p0dy7j7ckkcikb4v` FOREIGN KEY (`genero_id`) REFERENCES `generos` (`id`),
  CONSTRAINT `FKtaxa9nqsee1x8d5ts5rbvbxok` FOREIGN KEY (`puesto_de_trabajo_id`) REFERENCES `puestos_de_trabajo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `direcciones` (
  `id` int NOT NULL AUTO_INCREMENT,
  `direccion_principal` bit(1) NOT NULL,
  `nombre_calle` varchar(255) NOT NULL,
  `numero_calle` int DEFAULT NULL,
  `usuario_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK54oy4k8b4ltgwmoq6kuocwhc7` (`usuario_id`),
  CONSTRAINT `FK54oy4k8b4ltgwmoq6kuocwhc7` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;