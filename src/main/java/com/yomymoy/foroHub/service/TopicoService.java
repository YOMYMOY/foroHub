package com.yomymoy.foroHub.service;

import com.yomymoy.foroHub.dto.DatosActualizarTopico;
import com.yomymoy.foroHub.dto.DatosRegistroTopico;
import com.yomymoy.foroHub.model.Curso;
import com.yomymoy.foroHub.model.Topico;
import com.yomymoy.foroHub.model.Usuario;
import com.yomymoy.foroHub.repository.CursoRepository;
import com.yomymoy.foroHub.repository.TopicoRepository;
import com.yomymoy.foroHub.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    public Topico crearTopico(DatosRegistroTopico datos) {
        Optional<Curso> cursoOptional = cursoRepository.findById(datos.idCurso());
        Optional<Usuario> autorOptional = usuarioRepository.findById(datos.idAutor());
        if (cursoOptional.isPresent() && autorOptional.isPresent()) {
            Curso curso = cursoOptional.get();
            Usuario autor = autorOptional.get();
            return new Topico(datos, curso, autor);  // Pasar el curso encontrado
        } else {
            throw new RuntimeException("Curso no encontrado.");
        }
    }

    public void actualizarTopico(Long id, DatosActualizarTopico datos) {
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        if (topicoOptional.isPresent()) {
            Topico topico = topicoOptional.get();
            Optional<Curso> cursoOptional = cursoRepository.findById(datos.idCurso());
            if (cursoOptional.isPresent()) {
                Curso curso = cursoOptional.get();
                topico.actualizarDatos(datos, curso);  // Pasar el nuevo curso
                topicoRepository.save(topico);
            } else {
                throw new RuntimeException("Curso no encontrado.");
            }
        } else {
            throw new RuntimeException("Tópico no encontrado.");
        }
    }

}
