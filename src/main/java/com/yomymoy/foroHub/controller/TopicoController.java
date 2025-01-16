package com.yomymoy.foroHub.controller;

import com.yomymoy.foroHub.dto.TopicoDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @PostMapping
    public void agregarTopico(@RequestBody TopicoDTO topicoDTO) {
        System.out.println(topicoDTO);
    }

}
