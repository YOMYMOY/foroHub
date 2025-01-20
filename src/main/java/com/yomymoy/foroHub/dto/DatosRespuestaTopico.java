package com.yomymoy.foroHub.dto;

import com.yomymoy.foroHub.model.enums.StatusTopico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        StatusTopico status,
        String nombreAutor,
        String nombreCurso
) {
}
