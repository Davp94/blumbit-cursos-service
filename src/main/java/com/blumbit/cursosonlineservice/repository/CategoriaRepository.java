package com.blumbit.cursosonlineservice.repository;

import com.blumbit.cursosonlineservice.entities.Categoria;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoriaRepository extends ListCrudRepository<Categoria, Short> {
}
