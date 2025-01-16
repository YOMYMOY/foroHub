package com.yomymoy.foroHub.dto;

import com.yomymoy.foroHub.model.enums.StatusTopico;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        UsuarioDTO autor,
        CursoDTO curso
) {
}
