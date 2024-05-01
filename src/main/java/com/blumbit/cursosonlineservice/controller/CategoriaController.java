package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.dto.request.CategoriaRequest;
import com.blumbit.cursosonlineservice.dto.response.CategoriaResponse;
import com.blumbit.cursosonlineservice.entities.Categoria;
import com.blumbit.cursosonlineservice.repository.CategoriaRepository;
import com.blumbit.cursosonlineservice.service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoriaController {

    private final ICategoriaService categoriaService;

    @Autowired
    public CategoriaController(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping()
    public List<CategoriaResponse> getCategorias(){
        return this.categoriaService.getCategorias();
    }

    @GetMapping("/{id}")
    public Optional<CategoriaResponse> getCategoriasById(@PathVariable Short id){
        return this.categoriaService.getCategoriasById(id);
    }

    @PostMapping()
    public CategoriaResponse createCategoria(@RequestBody CategoriaRequest categoriaRequest){
        return this.categoriaService.createCategoria(categoriaRequest);
    }

    @PutMapping("/{id}")
    public CategoriaResponse updateCategoria(@PathVariable Short id, @RequestBody CategoriaRequest categoria){
        return this.categoriaService.updateCategoria(categoria, id);
    }

    @PutMapping("/enable/{id}")
    public void enableCategoria(@PathVariable Short id){
        this.categoriaService.enableById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoriaById(@PathVariable Short id){
        this.categoriaService.deleteCategoriaById(id);
    }

    @DeleteMapping("/logic/{id}")
    public void logicDeleteCategoriaById(@PathVariable Short id){
        this.categoriaService.logicDeleteById(id);
    }

}
