package com.yomymoy.foroHub.dto;

import com.yomymoy.foroHub.model.enums.StatusTopico;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        StatusTopico status,
        Long idCurso
) {
}
