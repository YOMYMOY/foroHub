package com.yomymoy.foroHub.repository;

import com.yomymoy.foroHub.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findBycorreoElectronico(String username);
}
