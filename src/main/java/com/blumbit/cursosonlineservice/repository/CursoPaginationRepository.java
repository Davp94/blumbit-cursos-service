package com.blumbit.cursosonlineservice.repository;

import com.blumbit.cursosonlineservice.entities.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;

import java.util.List;

public interface CursoPaginationRepository extends ListPagingAndSortingRepository<Curso, Short> {

    Page<Curso> findByCurNombre(String curNombre, Pageable pageable);
}
