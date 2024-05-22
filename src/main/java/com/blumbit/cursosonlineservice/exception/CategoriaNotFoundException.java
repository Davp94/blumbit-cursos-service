package com.blumbit.cursosonlineservice.exception;

public class CategoriaNotFoundException extends RuntimeException {
    public CategoriaNotFoundException(Short categoriaId){
        super("Categoria no encontrada con id: "+ categoriaId);
    }
}
