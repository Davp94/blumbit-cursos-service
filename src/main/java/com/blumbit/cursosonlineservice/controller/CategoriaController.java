package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.entities.Categoria;
import com.blumbit.cursosonlineservice.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

/*  Inyeccion de dependencias con anotaciones
    @Autowired
    CategoriaRepository categoriaRepository;*/

    /*  Inyeccion de dependencias por constructor
    */
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping()
    public List<Categoria> getCategorias(){
        return this.categoriaRepository.findAll();
    }

    @GetMapping(":id")
    public Optional<Categoria> getCategoriasById(@PathVariable Short id){
        return this.categoriaRepository.findById(id);
    }

    @PostMapping()
    public Categoria createCategoria(@RequestBody Categoria categoria){
        return this.categoriaRepository.save(categoria);
    }

    @PutMapping()
    public Categoria updateCategoria(@RequestBody Categoria categoria){
        Categoria categoriaFinded = this.categoriaRepository.findById(categoria.catId).orElse(null);

        if(categoriaFinded != null){
            categoriaFinded.setCatNombre(categoria.getCatNombre());
            categoriaFinded.setCatDescripcion(categoria.getCatDescripcion());
            this.categoriaRepository.save(categoriaFinded);
        }

        return categoriaFinded;
    }

    @DeleteMapping(":id")
    public void deleteCategoriaById(@PathVariable Short id){
        this.categoriaRepository.deleteById(id);
    }

}
