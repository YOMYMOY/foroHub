package com.yomymoy.foroHub.dto;

import java.util.List;

public record UsuarioDTO(
        Long id,
        String nombre,
        String correoElectronico,
        String contrasena
) {
}
