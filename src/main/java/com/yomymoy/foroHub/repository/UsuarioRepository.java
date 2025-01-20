package com.yomymoy.foroHub.repository;

import com.yomymoy.foroHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
