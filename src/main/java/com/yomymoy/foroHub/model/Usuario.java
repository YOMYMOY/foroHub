package com.yomymoy.foroHub.model;

import com.yomymoy.foroHub.dto.PerfilDTO;
import com.yomymoy.foroHub.dto.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique = true)
    private String correoElectronico;
    private String contrasena;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "usuarios_perfiles",
        joinColumns = @JoinColumn(name = "usuario_id"),
        inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfiles = new ArrayList<>();

    public Usuario(@Valid UsuarioDTO autor, Perfil estudiantePerfil) {
        this.nombre = autor.nombre();
        this.correoElectronico = autor.correoElectronico();
        this.contrasena = autor.contrasena();
        this.perfiles.add(estudiantePerfil);
    }

//    private List<Perfil> convertirPerfiles(List<PerfilDTO> perfilDTOs) {
//        List<Perfil> perfiles = new ArrayList<>();
//        for (PerfilDTO perfilDTO : perfilDTOs) {
//            perfiles.add(new Perfil(perfilDTO));
//        }
//        return perfiles;
//    }
}
