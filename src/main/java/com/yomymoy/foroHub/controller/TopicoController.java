package com.yomymoy.foroHub.controller;

import com.yomymoy.foroHub.dto.DatosActualizarTopico;
import com.yomymoy.foroHub.dto.DatosRegistroTopico;
import com.yomymoy.foroHub.dto.DatosListadoTopico;
import com.yomymoy.foroHub.dto.DatosRespuestaTopico;
import com.yomymoy.foroHub.model.Topico;
import com.yomymoy.foroHub.repository.TopicoRepository;
import com.yomymoy.foroHub.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> agregarTopico(@RequestBody @Valid DatosRegistroTopico datos,
                                        UriComponentsBuilder uriComponentsBuilder) {
        Topico topico =  topicoService.crearTopico(datos);
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getStatus(),
                topico.getAutor().getNombre(), topico.getCurso().getNombre());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(
                                size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC)
                    Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion)
                .map(DatosListadoTopico::new));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoService.actualizarTopico(id, datos);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getStatus(),
                                    topico.getAutor().getNombre(), topico.getCurso().getNombre()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity retornarDatosTopico(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(topico.getTitulo(), topico.getMensaje(), topico.getStatus(),
                topico.getAutor().getNombre(), topico.getCurso().getNombre());
        return ResponseEntity.ok(datosTopico);
    }
}
