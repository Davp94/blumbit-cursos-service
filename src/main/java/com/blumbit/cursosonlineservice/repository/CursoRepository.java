package com.blumbit.cursosonlineservice.repository;

import com.blumbit.cursosonlineservice.entities.Curso;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface CursoRepository extends ListCrudRepository<Curso, Short> {

 /*   Optional<Curso> findCursoByCurEstadoAndCurId(Boolean estado, Short curId);

    @Query(value = "select * from curso where cur_id = ?id and cur_estado= ?estado", nativeQuery = true)
    Optional<Curso> getCursosByEstadoAndId(Boolean estado, Short id);

    @Query(value = "select Curso from Curso where curId = ?id and curEstado = ?estado")
    Optional<Curso> getCursosByEstadoAndIdJpql(Boolean estado, Short id);*/
}
