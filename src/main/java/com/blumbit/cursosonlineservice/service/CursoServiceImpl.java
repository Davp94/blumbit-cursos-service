package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.entities.Categoria;
import com.blumbit.cursosonlineservice.entities.Curso;
import com.blumbit.cursosonlineservice.repository.CursoRepository;

import java.util.List;

public class CursoServiceImpl implements ICursoService{

    private final CursoRepository cursoRepository;

    public CursoServiceImpl(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Override
    public List<Curso> findAllCursos() {
        return this.cursoRepository.findAll();
    }

    @Override
    public Curso createCurso(Curso curso) {
        return this.cursoRepository.save(curso);
    }

    @Override
    public Curso enableCurso(Short id) {
        Curso cursoFinded = this.cursoRepository.findCursoByCurEstadoAndCurId(false, id).orElse(null);
        if(cursoFinded != null){
            cursoFinded.setCurEstado(true);
        }
        return this.cursoRepository.save(cursoFinded);
    }

    @Override
    public Curso disableCurso(Short id) {
        Curso cursoFinded = this.cursoRepository.getCursosByEstadoAndId(true, id).orElse(null);
        if(cursoFinded != null){
            cursoFinded.setCurEstado(false);
        }
        return this.cursoRepository.save(cursoFinded);
    }
}
