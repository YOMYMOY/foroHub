package com.yomymoy.foroHub.repository;

import com.yomymoy.foroHub.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Perfil findByNombre(String estudiante);
}
