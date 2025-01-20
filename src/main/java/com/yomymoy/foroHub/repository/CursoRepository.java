package com.yomymoy.foroHub.repository;

import com.yomymoy.foroHub.model.Curso;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Optional<Curso> findById(@NotBlank Long id);
}
