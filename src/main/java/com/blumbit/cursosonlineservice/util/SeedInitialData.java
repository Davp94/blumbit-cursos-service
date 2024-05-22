package com.blumbit.cursosonlineservice.util;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.cursosonlineservice.entities.Categoria;
import com.blumbit.cursosonlineservice.entities.Curso;
import com.blumbit.cursosonlineservice.entities.Usuario;
import com.blumbit.cursosonlineservice.repository.CategoriaRepository;
import com.blumbit.cursosonlineservice.repository.CursoRepository;
import com.blumbit.cursosonlineservice.repository.UsuariosRepository;

@Component
public class SeedInitialData implements CommandLineRunner{

    private final CursoRepository cursoRepository;

    private final CategoriaRepository categoriaRepository;

    private final UsuariosRepository usuariosRepository;

    public SeedInitialData(CursoRepository cursoRepository, CategoriaRepository categoriaRepository, UsuariosRepository usuariosRepository){
        this.cursoRepository = cursoRepository;
        this.categoriaRepository = categoriaRepository;
        this.usuariosRepository = usuariosRepository;
    }

    @Override
    public void run(String... args) {
        Usuario usuario1 = new Usuario();
        usuario1.setUsuario("usuario1");
        usuario1.setPassword("$2a$12$nDbdBtjkAobDGzPrUDWys.AodVDndOXjYifuO6WbW.RY12XatEexa");
        usuario1.setIsLocked(false);
        usuario1.setAvatar("avatar.png");
        Usuario usuario2 = new Usuario();
        usuario2.setUsuario("usuario2");
        usuario2.setPassword("$2a$12$nDbdBtjkAobDGzPrUDWys.AodVDndOXjYifuO6WbW.RY12XatEexa");
        usuario2.setIsLocked(false);
        usuario2.setAvatar("avatar.png");
        Usuario usuario3 = new Usuario();
        usuario3.setAvatar("avatar.png");
        usuario3.setUsuario("usuario3");
        usuario3.setPassword("$2a$12$nDbdBtjkAobDGzPrUDWys.AodVDndOXjYifuO6WbW.RY12XatEexa");
        usuario3.setIsLocked(false);

        this.usuariosRepository.saveAll(List.of(usuario1, usuario2, usuario3));

        Categoria categoria1 = new Categoria();
        categoria1.setCatNombre("Desarrollo Web");
        categoria1.setCatDescripcion("Desarrollo Web frontend y backend, bases de datos.");

        Categoria categoria2 = new Categoria();
        categoria2.setCatNombre("Desarrollo Mobile");
        categoria2.setCatDescripcion("Desarrollo mobile android, ios y flutter");
        
        Categoria categoria3 = new Categoria();
        categoria3.setCatNombre("Devops");
        categoria3.setCatDescripcion("Admnistrador de Sistemas, redes, docker kubernetes");

        List<Categoria> categoriaRegistered = this.categoriaRepository.saveAll(List.of(categoria1, categoria2, categoria3));

        Curso curso1 = new Curso();
        curso1.setCurNombre("Desarrollo Web Spring Boot y Angular 17");
        curso1.setCurDescripcion("Curso fullstack desarrollo web con base de datos postgres");
        curso1.setCategoria(categoriaRegistered.getFirst());
        curso1.setCurBanner("spring-angular.png");

        Curso curso2 = new Curso();
        curso2.setCurNombre("Desarrollo Web Spring Boot y React Nextjs");
        curso2.setCurDescripcion("Curso fullstack desarrollo web con base de datos postgres");
        curso2.setCategoria(categoriaRegistered.getFirst());
        curso2.setCurBanner("spring-angular.png");

        Curso curso3 = new Curso();
        curso3.setCurNombre("Desarrollo Web Laravel y VueJs3");
        curso3.setCurDescripcion("Curso fullstack desarrollo web con base de datos postgres");
        curso3.setCategoria(categoriaRegistered.getFirst());
        curso3.setCurBanner("spring-angular.png");

        Curso curso4 = new Curso();
        curso4.setCurNombre("Desarrollo Web NestJs y Angular 17");
        curso4.setCurDescripcion("Curso fullstack desarrollo web con base de datos postgres");
        curso4.setCategoria(categoriaRegistered.getFirst());
        curso4.setCurBanner("spring-angular.png");

        Curso curso5 = new Curso();
        curso5.setCurNombre("Desarrollo Mobile Flutter");
        curso5.setCurDescripcion("Curso fullstack desarrollo mobile con base de datos postgres");
        curso5.setCategoria(categoriaRegistered.get(1));
        curso5.setCurBanner("spring-angular.png");

        Curso curso6 = new Curso();
        curso6.setCurNombre("Desarrollo Mobile Android y Kotlin");
        curso6.setCurDescripcion("Curso fullstack desarrollo mobile con base de datos postgres");
        curso6.setCategoria(categoriaRegistered.get(1));
        curso6.setCurBanner("spring-angular.png");

        Curso curso7 = new Curso();
        curso7.setCurNombre("Desarrollo Docker y Cubernetes");
        curso7.setCurDescripcion("Curso devops");
        curso7.setCategoria(categoriaRegistered.get(2));
        curso7.setCurBanner("spring-angular.png");

        this.cursoRepository.saveAll(List.of(curso1, curso2, curso3, curso4, curso5, curso6, curso7));
    }

}
