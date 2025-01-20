package com.yomymoy.foroHub.controller;

import com.yomymoy.foroHub.dto.DatosActualizarTopico;
import com.yomymoy.foroHub.dto.DatosRegistroTopico;
import com.yomymoy.foroHub.dto.DatosListadoTopico;
import com.yomymoy.foroHub.model.Topico;
import com.yomymoy.foroHub.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public void agregarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        topicoRepository.save(new Topico(datos));
    }

    @GetMapping
    public Page<DatosListadoTopico> listarTopicos(@PageableDefault(
                                size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC)
                    Pageable paginacion) {
        return topicoRepository.findAll(paginacion)
                .map(DatosListadoTopico::new);
    }

    @PutMapping("{id}")
    @Transactional
    public void actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

}
