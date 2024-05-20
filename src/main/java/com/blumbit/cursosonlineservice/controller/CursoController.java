package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.entities.Curso;
import com.blumbit.cursosonlineservice.entities.Usuario;
import com.blumbit.cursosonlineservice.service.ICursoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/cursos")
public class CursoController {

    private final ICursoService cursoService;

    public CursoController(ICursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public Curso createUsuario(@RequestBody Curso curso){
        return this.cursoService.createCurso(curso);
    }
}
