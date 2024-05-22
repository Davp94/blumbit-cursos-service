package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.request.CursosPaginationRequest;
import com.blumbit.cursosonlineservice.entities.Categoria;
import com.blumbit.cursosonlineservice.entities.Curso;
import com.blumbit.cursosonlineservice.repository.CursoPaginationRepository;
import com.blumbit.cursosonlineservice.repository.CursoRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService{

    private final CursoRepository cursoRepository;

    private final CursoPaginationRepository cursoPaginationRepository;

    public CursoServiceImpl(CursoRepository cursoRepository, CursoPaginationRepository cursoPaginationRepository) {
        this.cursoRepository = cursoRepository;
        this.cursoPaginationRepository = cursoPaginationRepository;
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
        //Curso cursoFinded = this.cursoRepository.findCursoByCurEstadoAndCurId(false, id).orElse(null);
        /*if(cursoFinded != null){
            cursoFinded.setCurEstado(true);
        }*/
        return null;
    }

    @Override
    public Curso disableCurso(Short id) {
        /*Curso cursoFinded = this.cursoRepository.getCursosByEstadoAndId(true, id).orElse(null);
        if(cursoFinded != null){
            cursoFinded.setCurEstado(false);
        }*/
        return this.cursoRepository.save(null);
    }

    public boolean validateCurso(Curso curso){
        return this.cursoRepository.count()<100;
    }

    @Override
    public Page<Curso> findByCurNombre(CursosPaginationRequest cursosPaginationRequest) {
        Pageable requestPageable = PageRequest.of(cursosPaginationRequest.page, cursosPaginationRequest.size, Sort.by(cursosPaginationRequest.order == 1 ? Direction.ASC : Direction.DESC, cursosPaginationRequest.sortParam));
        return this.cursoPaginationRepository.findByCurNombreContainingIgnoreCase(cursosPaginationRequest.nombre, requestPageable);
    }
}
