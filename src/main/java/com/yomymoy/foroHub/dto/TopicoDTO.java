package com.yomymoy.foroHub.dto;

import com.yomymoy.foroHub.model.enums.StatusTopico;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TopicoDTO(
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico status,
        @NotNull
        @Valid
        UsuarioDTO autor,
        @NotNull
        @Valid
        CursoDTO curso
) {
}
