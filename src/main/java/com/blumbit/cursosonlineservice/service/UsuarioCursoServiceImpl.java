package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.entities.UsuarioCurso;
import com.blumbit.cursosonlineservice.repository.UsuarioCursoRepository;

public class UsuarioCursoServiceImpl implements IUsuarioCursoService {

    private final UsuarioCursoRepository usuarioCursoRepository;

    public UsuarioCursoServiceImpl(UsuarioCursoRepository usuarioCursoRepository) {
        this.usuarioCursoRepository = usuarioCursoRepository;
    }

    @Override
    public UsuarioCurso createUsuarioCurso(UsuarioCurso usuarioCurso) {
        return this.usuarioCursoRepository.save(usuarioCurso);
    }
}
