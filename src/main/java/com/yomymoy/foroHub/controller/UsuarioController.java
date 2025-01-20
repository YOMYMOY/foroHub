package com.yomymoy.foroHub.controller;

import com.yomymoy.foroHub.dto.UsuarioDTO;
import com.yomymoy.foroHub.model.Perfil;
import com.yomymoy.foroHub.model.Usuario;
import com.yomymoy.foroHub.repository.PerfilRepository;
import com.yomymoy.foroHub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    @Transactional
    public void registrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO) {
        Perfil estudiantePerfil = perfilRepository.findByNombre("estudiante");
        Usuario usuario = new Usuario(usuarioDTO, estudiantePerfil);
        usuarioRepository.save(usuario);
    }
}
