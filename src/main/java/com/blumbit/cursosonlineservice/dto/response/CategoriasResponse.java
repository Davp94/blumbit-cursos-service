package com.blumbit.cursosonlineservice.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoriasResponse {

    List<CategoriaResponse> categorias;
}
