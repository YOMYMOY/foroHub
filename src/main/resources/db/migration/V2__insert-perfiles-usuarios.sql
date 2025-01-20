-- 1. Insertar los perfiles
INSERT INTO perfiles (nombre) VALUES
    ('administrador'),
    ('estudiante'),
    ('profesor');

-- 2. Insertar los usuarios
INSERT INTO usuarios (nombre, correo_electronico, contrasena) VALUES
    ('Administrador', 'admin@example.com', 'contrasena1'),
    ('Usuario 2', 'usuario2@example.com', 'contrasena2'),
    ('Usuario 3', 'usuario3@example.com', 'contrasena3'),
    ('Usuario 4', 'usuario4@example.com', 'contrasena4'),
    ('Usuario 5', 'usuario5@example.com', 'contrasena5'),
    ('Usuario 6', 'usuario6@example.com', 'contrasena6'),
    ('Usuario 7', 'usuario7@example.com', 'contrasena7'),
    ('Usuario 8', 'usuario8@example.com', 'contrasena8'),
    ('Usuario 9', 'usuario9@example.com', 'contrasena9'),
    ('Usuario 10', 'usuario10@example.com', 'contrasena10');

-- 3. Asignar perfiles a los usuarios
-- Asignamos el perfil de 'estudiante' por defecto a todos los usuarios
INSERT INTO usuarios_perfiles (usuario_id, perfil_id)
SELECT id, (SELECT id FROM perfiles WHERE nombre = 'estudiante') FROM usuarios;

-- Asignamos el perfil de 'administrador' al primer usuario
INSERT INTO usuarios_perfiles (usuario_id, perfil_id)
SELECT id, (SELECT id FROM perfiles WHERE nombre = 'administrador')
FROM usuarios WHERE nombre = 'Administrador';

-- Asignamos el perfil de 'profesor' al usuario 2
INSERT INTO usuarios_perfiles (usuario_id, perfil_id)
SELECT id, (SELECT id FROM perfiles WHERE nombre = 'profesor')
FROM usuarios WHERE nombre = 'Usuario 2';