package com.yomymoy.foroHub.dto;

import java.time.LocalDateTime;

public record RespuestaDTO(
        Long id,
        String mensaje,
        TopicoDTO topico,
        LocalDateTime fechaCreacion,
        UsuarioDTO autor,
        Boolean solucion
) {
}
