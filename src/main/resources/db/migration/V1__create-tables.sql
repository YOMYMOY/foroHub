-- Crear tabla 'perfiles'
CREATE TABLE perfiles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Crear tabla 'usuarios'
CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL UNIQUE,
    contrasena VARCHAR(255) NOT NULL
);

-- Crear tabla intermedia 'usuario_perfil'
CREATE TABLE usuarios_perfiles (
    usuario_id BIGINT NOT NULL,
    perfil_id BIGINT NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (perfil_id) REFERENCES perfiles(id) ON DELETE CASCADE
);

-- Crear tabla 'cursos'
CREATE TABLE cursos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    categoria ENUM('Programación', 'Front End', 'Data Science', 'Innovación y Gestión', 'DevOps', 'Off Topic') NOT NULL
);

-- Crear tabla 'topicos'
CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('ABIERTO', 'SOLUCIONADO', 'CERRADO') DEFAULT 'ABIERTO',
    autor_id BIGINT NOT NULL,
    curso_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (curso_id) REFERENCES cursos(id) ON DELETE CASCADE
);

-- Crear tabla 'respuestas'
CREATE TABLE respuestas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    mensaje TEXT NOT NULL,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    autor_id BIGINT NOT NULL,
    topico_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (topico_id) REFERENCES topicos(id) ON DELETE CASCADE
);
