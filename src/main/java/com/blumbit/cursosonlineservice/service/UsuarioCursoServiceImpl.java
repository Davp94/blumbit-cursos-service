package com.blumbit.cursosonlineservice.service;

import org.springframework.stereotype.Service;

import com.blumbit.cursosonlineservice.dto.request.UsuarioCursoRequest;
import com.blumbit.cursosonlineservice.entities.Curso;
import com.blumbit.cursosonlineservice.entities.Usuario;
import com.blumbit.cursosonlineservice.entities.UsuarioCurso;
import com.blumbit.cursosonlineservice.repository.CursoRepository;
import com.blumbit.cursosonlineservice.repository.UsuarioCursoRepository;
import com.blumbit.cursosonlineservice.repository.UsuariosRepository;

@Service
public class UsuarioCursoServiceImpl implements IUsuarioCursoService {

    private final UsuarioCursoRepository usuarioCursoRepository;
    private final UsuariosRepository usuariosRepository;
    private final CursoRepository cursoRepository;

    public UsuarioCursoServiceImpl(UsuarioCursoRepository usuarioCursoRepository, UsuariosRepository usuariosRepository,
            CursoRepository cursoRepository) {
        this.usuarioCursoRepository = usuarioCursoRepository;
        this.usuariosRepository = usuariosRepository;
        this.cursoRepository = cursoRepository;
    }

    @Override
    public UsuarioCurso createUsuarioCurso(UsuarioCursoRequest usuarioCursoRequest) {
        Usuario usuario = this.usuariosRepository.findById(usuarioCursoRequest.getUsuarioCodigo()).get();
        Curso curso = this.cursoRepository.findById(usuarioCursoRequest.getCursoCodigo()).get();
        UsuarioCurso usuarioCurso = new UsuarioCurso();
        usuarioCurso.setCurso(curso);
        usuarioCurso.setUsuario(usuario);
        return this.usuarioCursoRepository.save(usuarioCurso);
    }
}
