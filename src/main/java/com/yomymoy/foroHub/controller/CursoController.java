package com.yomymoy.foroHub.controller;

import com.yomymoy.foroHub.dto.CursoDTO;
import com.yomymoy.foroHub.model.Curso;
import com.yomymoy.foroHub.repository.CursoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public void registrarCurso(@RequestBody @Valid CursoDTO cursoDTO) {
        cursoRepository.save(new Curso(cursoDTO));
    }
}
