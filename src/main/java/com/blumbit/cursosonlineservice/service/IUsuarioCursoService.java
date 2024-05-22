package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.request.UsuarioCursoRequest;
import com.blumbit.cursosonlineservice.entities.UsuarioCurso;

public interface IUsuarioCursoService {

    UsuarioCurso createUsuarioCurso(UsuarioCursoRequest usuarioCurso);
}
