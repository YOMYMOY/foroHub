package com.yomymoy.foroHub.repository;

import com.yomymoy.foroHub.model.Perfil;

public interface PerfilRepository {
    Perfil findByNombre(String estudiante);
}
