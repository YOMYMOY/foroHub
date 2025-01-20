package com.yomymoy.foroHub.model;

import com.yomymoy.foroHub.dto.PerfilDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Perfil")
@Table(name = "perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    public Perfil(String nombre) {
        this.nombre = nombre;
    }
}
