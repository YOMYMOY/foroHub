package com.yomymoy.foroHub.model;

import com.yomymoy.foroHub.dto.DatosActualizarTopico;
import com.yomymoy.foroHub.dto.DatosRegistroTopico;
import com.yomymoy.foroHub.model.enums.StatusTopico;
import com.yomymoy.foroHub.repository.CursoRepository;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    @Enumerated(EnumType.STRING)
    private StatusTopico status;
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

    public Topico(@Valid DatosRegistroTopico datos, Curso curso, Usuario autor) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = LocalDateTime.now();
        this.status = StatusTopico.ABIERTO;
        this.autor = autor;
        this.curso = curso;
    }

    public void actualizarDatos(DatosActualizarTopico datos, Curso curso) {
        if (datos.status() != null) {
            if (EnumSet.allOf(StatusTopico.class).contains(datos.status())) {
                this.status = datos.status();
            } else {
                throw new IllegalArgumentException("El estado proporcionado no es válido");
            }
        }
        if (datos.idCurso() != null) {
            this.curso = curso;
        }

    }
}
