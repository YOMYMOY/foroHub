package com.yomymoy.foroHub.dto;

import com.yomymoy.foroHub.model.Topico;
import com.yomymoy.foroHub.model.enums.StatusTopico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico estado,
        String autor,
        String curso
) {
    public DatosListadoTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
