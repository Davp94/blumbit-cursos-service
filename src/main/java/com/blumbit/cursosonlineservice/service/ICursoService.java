package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.entities.Curso;

import java.util.List;

public interface ICursoService {

    List<Curso> findAllCursos();

    Curso createCurso(Curso curso);

    Curso enableCurso(Short id);

    Curso disableCurso(Short id);


}
