package com.yomymoy.foroHub.dto;

import com.yomymoy.foroHub.model.enums.CategoriaCurso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDTO(
        Long id,
        @NotBlank
        String nombre,
        @NotNull
        CategoriaCurso categoria
) {
}
