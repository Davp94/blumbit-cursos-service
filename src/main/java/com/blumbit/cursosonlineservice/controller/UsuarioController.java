package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.entities.Usuario;
import com.blumbit.cursosonlineservice.service.IUsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario){
        return this.usuarioService.createUsuario(usuario);
    }
}
