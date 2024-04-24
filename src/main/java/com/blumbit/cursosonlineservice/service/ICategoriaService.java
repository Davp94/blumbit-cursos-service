package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.request.CategoriaRequest;
import com.blumbit.cursosonlineservice.dto.response.CategoriaResponse;
import com.blumbit.cursosonlineservice.dto.response.CategoriasResponse;
import com.blumbit.cursosonlineservice.entities.Categoria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {

    List<CategoriaResponse> getCategorias();

    Optional<CategoriaResponse> getCategoriasById(Short id);

    CategoriaResponse createCategoria(CategoriaRequest categoria);

    CategoriaResponse updateCategoria(CategoriaRequest categoria, Short id);

    void deleteCategoriaById(Short id);
}
