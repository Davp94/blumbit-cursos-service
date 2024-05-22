package com.blumbit.cursosonlineservice.service;

import com.blumbit.cursosonlineservice.dto.request.CategoriaRequest;
import com.blumbit.cursosonlineservice.dto.response.CategoriaResponse;
import com.blumbit.cursosonlineservice.dto.response.CategoriasResponse;
import com.blumbit.cursosonlineservice.entities.Categoria;
import com.blumbit.cursosonlineservice.exception.CategoriaNotFoundException;
import com.blumbit.cursosonlineservice.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaResponse> getCategorias() {
        List<CategoriaResponse> categoriasResponse = new ArrayList<>();
        List<Categoria> categorias = this.categoriaRepository.findAll();
        for (int i = 0; i < categorias.toArray().length; i++) {
            CategoriaResponse categoriaResponse = new CategoriaResponse();
            categoriaResponse.setId(categorias.get(i).getCatId());
            categoriaResponse.setDescripcion(categorias.get(i).getCatDescripcion());
            categoriaResponse.setNombre(categorias.get(i).getCatNombre());
            categoriaResponse.setCorrelativo(categorias.get(i).getCatCorrelativo());
            categoriasResponse.add(categoriaResponse);
        }
        return categoriasResponse;
    }

    @Override
    public Optional<CategoriaResponse> getCategoriasById(Short id) {
        Categoria cat= this.categoriaRepository.findById(id).orElse(null);
        CategoriaResponse categoriaResponse = new CategoriaResponse();
        if(cat!=null){
            categoriaResponse.setId(cat.getCatId());
            categoriaResponse.setDescripcion(cat.getCatDescripcion());
            categoriaResponse.setNombre(cat.getCatNombre());
            categoriaResponse.setCorrelativo(cat.getCatCorrelativo());
        }else {
            throw new CategoriaNotFoundException(id);
        }
        return Optional.of(categoriaResponse);
    }

    @Override
    public CategoriaResponse createCategoria(CategoriaRequest categoriaRequest) {
        Categoria categoria = new Categoria();
        categoria.setCatNombre(categoriaRequest.getNombre());
        categoria.setCatCorrelativo(categoriaRequest.getCorrelativo());
        categoria.setCatDescripcion(categoriaRequest.getDescripcion());
        Categoria categoriaCreated = this.categoriaRepository.save(categoria);
        CategoriaResponse categoriaResponse = new CategoriaResponse();
        categoriaResponse.setId(categoriaCreated.getCatId());
        categoriaResponse.setDescripcion(categoriaCreated.getCatDescripcion());
        categoriaResponse.setNombre(categoriaCreated.getCatNombre());
        categoriaResponse.setCorrelativo(categoriaCreated.getCatCorrelativo());
        return categoriaResponse;
    }

    @Override
    public CategoriaResponse updateCategoria(CategoriaRequest categoriaRequest, Short id) {
        Categoria categoriaFinded = this.categoriaRepository.findById(id).orElse(null);
        CategoriaResponse categoriaResponse = new CategoriaResponse();
        if(categoriaFinded != null){
            categoriaFinded.setCatNombre(categoriaRequest.getNombre());
            categoriaFinded.setCatDescripcion(categoriaRequest.getDescripcion());
            categoriaFinded.setCatCorrelativo(categoriaRequest.getCorrelativo());
            Categoria categoriaUpdated = this.categoriaRepository.save(categoriaFinded);

            categoriaResponse.setId(categoriaUpdated.getCatId());
            categoriaResponse.setDescripcion(categoriaUpdated.getCatDescripcion());
            categoriaResponse.setNombre(categoriaUpdated.getCatNombre());
            categoriaResponse.setCorrelativo(categoriaUpdated.getCatCorrelativo());
        }

        return categoriaResponse;
    }

    @Override
    public void deleteCategoriaById(Short id) {
        this.categoriaRepository.deleteById(id);
    }

    @Override
    public void logicDeleteById(Short id) {
        Categoria categoriaFinded = this.categoriaRepository.findById(id).orElse(null);
        if(categoriaFinded != null){
            categoriaFinded.setEstado(false);
            this.categoriaRepository.save(categoriaFinded);
        }
    }

    @Override
    public void enableById(Short id) {
        Categoria categoriaFinded = this.categoriaRepository.findById(id).orElse(null);
        if(categoriaFinded != null){
            categoriaFinded.setEstado(true);
            this.categoriaRepository.save(categoriaFinded);
        }
    }
}
