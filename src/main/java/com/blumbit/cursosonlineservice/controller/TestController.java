package com.blumbit.cursosonlineservice.controller;

import com.blumbit.cursosonlineservice.entities.Curso;
import com.blumbit.cursosonlineservice.repository.CursoPaginationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {

    private final CursoPaginationRepository cursoPaginationRepository;

    public TestController(CursoPaginationRepository cursoPaginationRepository) {
        this.cursoPaginationRepository = cursoPaginationRepository;
    }

    @GetMapping()
    public String greeting(){
        return "HELLO WORLD";
    }

    @GetMapping("cursos")
    public Page<Curso> findAllCursos(@RequestParam Pageable pageable, String nombre){
        /*Pageable test1 = PageRequest.of(0, 2);
        return this.cursoPaginationRepository.findAll(pageable);*/
        System.out.println(pageable);
        System.out.println(nombre);
        return this.cursoPaginationRepository.findByCurNombre(nombre, pageable);
    }
}
