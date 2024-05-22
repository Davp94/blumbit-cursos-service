package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.request.CursosPaginationRequest;
import com.blumbit.cursosonlineservice.entities.Curso;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICursoService {

    List<Curso> findAllCursos();

    Curso createCurso(Curso curso);

    Curso enableCurso(Short id);

    Curso disableCurso(Short id);

    Page<Curso> findByCurNombre(CursosPaginationRequest cursopPaginationRequest);


}
