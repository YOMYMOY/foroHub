package com.yomymoy.foroHub.model;

import com.yomymoy.foroHub.dto.CursoDTO;
import com.yomymoy.foroHub.model.enums.CategoriaCurso;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private CategoriaCurso categoria;

    public Curso(@Valid CursoDTO curso) {
        this.nombre = curso.nombre();
        this.categoria = curso.categoria();
    }
}
