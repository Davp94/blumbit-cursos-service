package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.dto.request.CategoriaRequest;
import com.blumbit.cursosonlineservice.dto.request.CursosPaginationRequest;
import com.blumbit.cursosonlineservice.dto.request.UsuarioCursoRequest;
import com.blumbit.cursosonlineservice.entities.Curso;
import com.blumbit.cursosonlineservice.entities.UsuarioCurso;
import com.blumbit.cursosonlineservice.service.ICursoService;
import com.blumbit.cursosonlineservice.service.IUsuarioCursoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cursos")
public class CursoController {

    private final ICursoService cursoService;

    private final IUsuarioCursoService usuarioCursoService;

    public CursoController(ICursoService cursoService, IUsuarioCursoService usuarioCursoService) {
        this.cursoService = cursoService;
        this.usuarioCursoService = usuarioCursoService;
    }

    @PostMapping
    public Curso createUsuario(@RequestBody Curso curso){
        return this.cursoService.createCurso(curso);
    }

    @GetMapping()
    public Page<Curso> findAllCursos(@RequestParam int page, @RequestParam int size, @RequestParam String sortParam, @RequestParam int order, @RequestParam String nombre){
        return this.cursoService.findByCurNombre(new CursosPaginationRequest(page, size, sortParam, order, nombre));
    }

    @PostMapping("/usuario")
    public UsuarioCurso createUsuarioCurso(@RequestBody UsuarioCursoRequest usuarioCursoRequest){
        return this.usuarioCursoService.createUsuarioCurso(usuarioCursoRequest);
    }

    
}
