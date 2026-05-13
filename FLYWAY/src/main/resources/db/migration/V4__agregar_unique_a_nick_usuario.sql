ALTER TABLE usuarios
ADD CONSTRAINT uk_usuarios_nick_usuario
UNIQUE (nick_usuario);